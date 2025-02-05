package org.gsc.medha.service;

import java.util.List;

import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.School;

public interface CandidateService {

	public List<Candidate> getAllStudent(School school, int section, Exam exam);

	public List<Candidate> getAllStudent(School school, int section, Exam exam, String status);

	public List<Candidate> getAllStudent(int section, Exam exam);

	public List<Candidate> getAllStudent(int section, Exam exam, String status);

	public List<Candidate> getAllStudent(Exam exam);

	public List<Candidate> getAllStudent(Exam exam, String status);

	public List<Candidate> getAllStudent(School school);

	public List<Candidate> getAllStudent(School school, String status);

	List<Candidate> getAllStudent(School school, Exam exam, String status);

	Candidate getStudent(int id);

	List<Candidate> getPendingNotifications(Exam exam);

	Candidate getStudent(int roll, int cls, Exam exam, String status);

	List<Candidate> getAllStudent(List<Integer> id);

	List<Candidate> getAllStudent();

}
