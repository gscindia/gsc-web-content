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
		List<Object> obj = examRepository.getActiveExam();
		return CollectionUtils.isEmpty(obj) ? null : (Exam) obj.get(0);

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

		return examRepository.filterFormB( candidate.getExam(),candidate.getSection());
	}

}
