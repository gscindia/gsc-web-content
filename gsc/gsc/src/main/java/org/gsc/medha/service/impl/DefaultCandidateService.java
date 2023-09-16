package org.gsc.medha.service.impl;

import java.util.List;

import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.School;
import org.gsc.medha.repository.CandidateRepository;
import org.gsc.medha.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultCandidateService implements CandidateService {

	@Autowired
	CandidateRepository repository;

	@Override
	public Candidate getStudent(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Candidate> getAllStudent(List<Integer> id) {
		return (List<Candidate>) repository.findAllById(id);
	}

	@Override
	public Candidate getStudent(int roll, int cls, Exam exam, String status) {
		return repository.getStudent(roll, cls, exam, status);
	}

	@Override
	public List<Candidate> getAllStudent(School school, int section, Exam exam) {

		return repository.getAllStudent(school, section, exam);
	}

	@Override
	public List<Candidate> getAllStudent(School school, Exam exam, String status) {

		return repository.getAllStudent(school, exam, status);
	}

	@Override
	public List<Candidate> getAllStudent(School school, int section, Exam exam, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getAllStudent(int section, Exam exam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getAllStudent(int section, Exam exam, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getAllStudent(Exam exam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getAllStudent(Exam exam, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getAllStudent(School school) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getAllStudent(School school, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getPendingNotifications(Exam exam) {

		return repository.getPendingNotification(exam);
	}

}
