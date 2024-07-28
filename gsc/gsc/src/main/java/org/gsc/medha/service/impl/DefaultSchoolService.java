package org.gsc.medha.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;



import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.School;
import org.gsc.medha.repository.SchoolRepository;
import org.gsc.medha.service.ExamService;
import org.gsc.medha.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Component
public class DefaultSchoolService implements SchoolService {

	@Autowired
	SchoolRepository schoolRepo;
	@Autowired
	ExamService examService;
	@Autowired
	EntityManager entityManager;

	@Override
	public School add(School school) {
		school.setStatus("ACTIVE");
		return schoolRepo.save(school);
	}

	@Override
	public List<School> getAllSchool() {

		return schoolRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));

	}

	@Override
	public School findBySchoolName(String name) {
		School school = (School) schoolRepo.findBySchoolName(name).get(0);
		return school;
	}

	@Override
	public School getSchoolById(int id) {
		Optional<School> school = schoolRepo.findById(id);
		return school.isPresent() ? school.stream().collect(Collectors.toList()).get(0) : null;
	}

	@Override
	public List<Candidate> getFormA(Candidate candidate) {

		return schoolRepo.filterFormA(candidate.getSchool(), examService.getActiveExam());
	}

	@Override
	public List<Candidate> getFormAByExam(Candidate candidate) {

		return schoolRepo.filterFormA(candidate.getSchool(), candidate.getExam());
	}

	@Override
	public List<Map<String, String>> getStudentStatistics(Exam exam, School school) {
		String examClause = null == exam ? "" : " and c.exam=:exam ";
		String schoolClause = null == school ? "" : " and c.school=:school ";
		String jpql = "SELECT " + "s.name, " + "SUM(CASE WHEN c.gender = 'M' THEN 1 ELSE 0 END) AS male_students, "
				+ "SUM(CASE WHEN c.gender = 'F' THEN 1 ELSE 0 END) AS female_students FROM School s "
				+ "JOIN Candidate c ON s.id = c.school.id WHERE c.status = 'ACTIVE'" + examClause + schoolClause
				+ "  GROUP BY s.name ORDER BY s.name";

		Query query = entityManager.createQuery(jpql);
		if (!examClause.equalsIgnoreCase(""))
			query.setParameter("exam", exam);

		if (!schoolClause.equalsIgnoreCase(""))
			query.setParameter("school", school);
		
		List<Object[]> results = query.getResultList();

		List<Map<String, String>> studentStatisticsList = new ArrayList<>();
		for (Object[] result : results) {
			Map<String, String> studentStatistics = new TreeMap<>();
			studentStatistics.put("series1", (String) result[0]);
			studentStatistics.put("series2", String.valueOf(result[1]));
			studentStatistics.put("series3", String.valueOf(result[2]));
			studentStatisticsList.add(studentStatistics);
		}

		return studentStatisticsList;

	}

	@Override
	public List<Map<String, String>> getClassGenderStatistics(Exam exam) {
		String examClause = null == exam ? "" : "and s.exam=:exam";
		String queryString = "SELECT s.section, " + "SUM(CASE WHEN s.gender = 'M' THEN 1 ELSE 0 END) AS maleCount, "
				+ "SUM(CASE WHEN s.gender = 'F' THEN 1 ELSE 0 END) AS femaleCount FROM Candidate s "
				+ "WHERE s.status='ACTIVE' " + examClause + " GROUP BY s.section ORDER BY s.section";

		Query query = entityManager.createQuery(queryString);
		if (!examClause.equalsIgnoreCase(""))
			query.setParameter("exam", exam);

		List<Object[]> results = query.getResultList();

		List<Map<String, String>> statistics = new ArrayList<>();
		for (Object[] result : results) {
			String classId = String.valueOf(result[0]);
			String maleCount = String.valueOf(result[1]);
			String femaleCount = String.valueOf(result[2]);

			Map<String, String> classStats = new HashMap<>();
			classStats.put("series1", classId);
			classStats.put("series2", maleCount);
			classStats.put("series3", femaleCount);

			statistics.add(classStats);
		}

		return statistics;
	}

}
