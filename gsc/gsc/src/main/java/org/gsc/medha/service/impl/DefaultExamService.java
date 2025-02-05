package org.gsc.medha.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.gsc.medha.data.ExamRevenueData;
import org.gsc.medha.data.ExamShiftAnalysisData;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.prop.Status;
import org.gsc.medha.repository.CandidateRepository;
import org.gsc.medha.repository.ExamRepository;
import org.gsc.medha.repository.VenueRepository;
import org.gsc.medha.service.ExamService;
import org.gsc.utility.GscSecurity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class DefaultExamService implements ExamService {

	@Autowired
	ExamRepository examRepository;
	@Autowired
	VenueRepository venueRepository;
	@Autowired
	CandidateRepository candidateRepository;
	@Autowired
	GscSecurity gscSecurity;

	@Override
	public Exam save(Exam exam) {
		exam = examRepository.save(exam);
		return exam;
	}

	@Override
	public List<Exam> getAll() {
		List<Exam> exams = new ArrayList<>();
		examRepository.findAll().forEach(exams::add);
		return exams;
	}

	@Override
	public Exam getActiveExam() {
		return examRepository.getActiveExam();

	}

	@Override
	public Exam getPostExam() {
		return examRepository.getPostExam();

	}

	@Override
	public Candidate registerCandidate(Candidate candidate) {
		candidate.setRoll(this.incrementRoll(candidate, candidate.getExam()));
		candidate = candidateRepository.save(candidate);

		return candidate;
	}

	@Override
	public Integer incrementRoll(Candidate candidate, Exam exam) {

		Integer roll = candidateRepository.getLatestRoll(candidate.getSection(), exam);
		return null == roll ? 1 : roll + 1;
	}

	@Override
	public Exam getExamById(int id) {
		List<Exam> exams = examRepository.findById(id).stream().collect(Collectors.toList());
		return CollectionUtils.isEmpty(exams) ? null : exams.get(0);
	}

	@Override
	public List<Candidate> getFormB(Candidate candidate) {

		return examRepository.filterFormB(candidate.getExam(), candidate.getSection());
	}

	@Override
	public List<Candidate> getAdmitCards(Candidate candidate) {

		return examRepository.filterFormB(candidate.getExam(), candidate.getSection());
	}

	@Override
	public JSONObject updateAttendance(JSONObject json) {
		JSONArray jsonarray = json.getJSONArray("data");

		List<String> listOfHash = new ArrayList<>();
		jsonarray.forEach(array -> listOfHash.add(array.toString()));
		List<Candidate> candidates = candidateRepository.getAllStudent(getPostExam(), Status.ACTIVE.name());
		candidates = candidates.stream()
				.filter(candidate -> listOfHash.contains(
						gscSecurity.encrypt(String.valueOf(candidate.getId())))).toList();
		candidates.forEach(Candidate::updateAttendance);
		
		candidateRepository.saveAll(candidates);
		
		JSONObject summary = new JSONObject();
		summary.put("inbound", listOfHash.size());
		summary.put("processed", candidates.size());

		return summary;
	}
	@Override
	public List<ExamRevenueData> getRevenueSummaryByClass(){
		return examRepository.getExamRevenueTrend();
	}
	@Override
	public List<ExamRevenueData> getRevenueSummary(){
		List<ExamRevenueData> result = new ArrayList<>();
		List<ExamRevenueData> trend = getRevenueSummaryByClass();
		List<Long> totalRevenuesByYear = trend.stream()
                .collect(Collectors.groupingBy(ExamRevenueData::getExamId,
                        Collectors.summingLong(ExamRevenueData::getRevenue)))
                .values()
                .stream()
                .toList();
		totalRevenuesByYear.forEach(revenue ->{
			ExamRevenueData obj = new ExamRevenueData(0, 0, revenue);
			result.add(obj);
		});

		return result;
	}

	public List<Candidate> getAllEnrolledCandidates(Exam exam) {

		return null == exam ? candidateRepository.getAllStudent() 
							: candidateRepository.getAllStudent(exam, Status.ACTIVE.name());

	}

	@Override
	public String resolveGrade(int marks) {
		String grade;
		if (marks >= 90)
			grade = "A++";
		else if (marks >= 80)
			grade = "A+";
		else if (marks >= 70)
			grade = "A";
		else if (marks >= 60)
			grade = "B+";
		else if (marks >= 50)
			grade = "B";
		else if (marks >= 40)
			grade = "C";
		else
			grade = "-";

		return grade;

	}

	@Override
	public List<ExamShiftAnalysisData> historicalShiftAnalysis() {
		return examRepository.historicalShiftAnalysis();
	}
}
