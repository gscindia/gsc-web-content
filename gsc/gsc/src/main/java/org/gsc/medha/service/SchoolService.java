package org.gsc.medha.service;

import java.util.List;
import java.util.Map;

import org.gsc.medha.data.SchoolLeaderBoard;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.School;

public interface SchoolService {
	List<School> getAllSchool();

	School findBySchoolName(String name);

	School getSchoolById(int id);

	List<Candidate> getFormA(Candidate criteria);

	List<Candidate> getFormAByExam(Candidate candidate);

	School add(School school);

	List<Map<String, String>> getClassGenderStatistics(Exam exam);

	List<Map<String, String>> getStudentStatistics(Exam exam, School school);

	List<SchoolLeaderBoard> getSchoolLeaderboard();
	
	List<SchoolLeaderBoard> getSchoolLeaderboardByYear(int examId);

}
