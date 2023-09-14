package org.gsc.medha.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
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
		List<Candidate> candidates = candidateRepository.getAllStudent(getPostExam(), "ACTIVE");
		int count = 0;
		candidates.forEach(can -> {
			try {

				String hash = GscSecurity.wrap(String.valueOf(can.getId()));
				if("82a93b152b275d4c8de67c3d05c9b00e92477eeb024f117c7632cdb26fd874aa".equals(hash)) {
				System.out.println(can.getId()); 
				}
				
				if (listOfHash.contains(hash)) {
					
					//System.out.println(can.getId());
				}else {
					//System.out.println("ID:" + can.getId()+" Roll: "+can.getRoll()+" "+can.getSection()+" S Hash: "+hash);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return null;
	}

}
