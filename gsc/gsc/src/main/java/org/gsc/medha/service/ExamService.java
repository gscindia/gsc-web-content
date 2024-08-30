package org.gsc.medha.service;

import java.util.List;

import org.gsc.medha.data.ExamRevenueData;
import org.gsc.medha.data.ExamShiftAnalysisData;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.json.JSONObject;

public interface ExamService {

	Exam save(Exam exam);

	List<Exam> getAll();

	Exam getActiveExam();

	Candidate registerCandidate(Candidate candidate);

	Integer incrementRoll(Candidate candidate, Exam exam);

	Exam getExamById(int id);

	List<Candidate> getFormB(Candidate candidate);

	List<Candidate> getAdmitCards(Candidate candidate);

	JSONObject updateAttendance(JSONObject json);

	Exam getPostExam();

	List<Candidate> getAllEnrolledCandidates(Exam exam);

	String resolveGrade(int marks);

	List<ExamRevenueData> getRevenueSummary();

	List<ExamShiftAnalysisData> historicalShiftAnalysis();

}
