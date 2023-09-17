package org.gsc.medha.service;

import java.util.List;

import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;

public interface ExamService {

	Exam save(Exam exam);

	List<Exam> getAll();

	Exam getActiveExam();

	Candidate registerCandidate(Candidate candidate);

	Integer incrementRoll(Candidate candidate, Exam exam);

	Exam getExamById(int id);

	List<Candidate> getFormB(Candidate candidate);

	List<Candidate> getAdmitCards(Candidate candidate);

	List<Candidate> getAllEnrolledCandidates(Exam exam);

}
