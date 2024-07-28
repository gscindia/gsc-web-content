package org.gsc.medha.facade.impl;

import java.util.List;
import java.util.Map;

import org.gsc.medha.dto.SchoolGenderDataDto;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.School;
import org.gsc.medha.facade.MedhaSandhanAnalyticsFacade;
import org.gsc.medha.service.ExamService;
import org.gsc.medha.service.SchoolService;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class DefaultMedhaSandhanAnalyticsFacade implements MedhaSandhanAnalyticsFacade {
	@Resource(name="studentGenderChartDataPopulator")
	Populator<List<Map<String, String>>, SchoolGenderDataDto> populator;
	@Resource(name="classGenderChartDataPopulator")
	Populator<List<Map<String, String>>, SchoolGenderDataDto> classPopulator;
	@Autowired
	SchoolService schoolService;
	@Autowired
	ExamService examService;

	@Override
	public SchoolGenderDataDto getSchoolGenderChartData(int examId, int schoolId) {
		SchoolGenderDataDto dto = new SchoolGenderDataDto();
		Exam exam = examService.getExamById(examId);
		School school = schoolService.getSchoolById(schoolId);
		populator.populate(schoolService.getStudentStatistics(exam,school), dto);
		return dto;

	}
	@Override
	public SchoolGenderDataDto getClassGenderStatistics(int examId) {
		SchoolGenderDataDto dto = new SchoolGenderDataDto();
		Exam exam = examService.getExamById(examId);
		classPopulator.populate(schoolService.getClassGenderStatistics(exam), dto);
		return dto;
		
	}
	@Override
	public int enrollmentCount(int examId) {
		Exam exam = examService.getExamById(examId);
		return examService.getAllEnrolledCandidates(exam).size();
	}

}
