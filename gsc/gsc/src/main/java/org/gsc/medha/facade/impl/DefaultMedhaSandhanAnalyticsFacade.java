package org.gsc.medha.facade.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.gsc.medha.data.ExamRevenueData;
import org.gsc.medha.data.ExamShiftAnalysisData;
import org.gsc.medha.data.SchoolLeaderBoard;
import org.gsc.medha.dto.RevenueAnalysisDto;
import org.gsc.medha.dto.SchoolGenderDataDto;
import org.gsc.medha.dto.SchoolLeaderBoardDto;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.School;
import org.gsc.medha.facade.MedhaSandhanAnalyticsFacade;
import org.gsc.medha.service.ExamService;
import org.gsc.medha.service.SchoolService;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultMedhaSandhanAnalyticsFacade implements MedhaSandhanAnalyticsFacade {
	@Resource(name = "studentGenderChartDataPopulator")
	Populator<List<Map<String, String>>, SchoolGenderDataDto> populator;
	@Resource(name = "classGenderChartDataPopulator")
	Populator<List<Map<String, String>>, SchoolGenderDataDto> classPopulator;
	@Resource(name = "revenuePopulator")
	Populator<ExamRevenueData, RevenueAnalysisDto> revenuePopulator;
	@Resource(name = "totalRevenueTrendPopulator")
	Populator<ExamRevenueData, RevenueAnalysisDto> totalRevenueTrendPopulator;
	@Resource(name="examShiftPopulator")
	Populator<ExamShiftAnalysisData, RevenueAnalysisDto> examShifPopulator;
	@Autowired
	SchoolService schoolService;
	@Autowired
	ExamService examService;

	@Override
	public SchoolGenderDataDto getSchoolGenderChartData(int examId, int schoolId) {
		SchoolGenderDataDto dto = new SchoolGenderDataDto();
		Exam exam = examService.getExamById(examId);
		School school = schoolService.getSchoolById(schoolId);
		populator.populate(schoolService.getStudentStatistics(exam, school), dto);
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

	@Override
	public List<RevenueAnalysisDto> revenueTrendByClass() {
		List<ExamRevenueData> results = examService.getRevenueSummaryByClass();
		List<RevenueAnalysisDto> responseDtos = new ArrayList<>();
		revenuePopulator.populateAll(results, responseDtos);
		return responseDtos;
	}

	@Override
	public List<RevenueAnalysisDto> revenueTrend() {
		List<ExamRevenueData> results = examService.getRevenueSummary();
		List<RevenueAnalysisDto> responseDtos = new ArrayList<>();
		totalRevenueTrendPopulator.populateAll(results, responseDtos);
		return responseDtos;
	}

	@Override
	public SchoolLeaderBoardDto getSchoolLeaderboard(int examId) {
		List<SchoolLeaderBoard> details = examId <= 0 ? schoolService.getSchoolLeaderboard()
				: schoolService.getSchoolLeaderboardByYear(examId);
		SchoolLeaderBoardDto respBoardDto = new SchoolLeaderBoardDto();
		respBoardDto.setSchool(details.stream()
										.map(SchoolLeaderBoard::getSchoolName)
										.collect(Collectors.toList()));
		respBoardDto.setApplication(details.stream()
										.map(SchoolLeaderBoard::getCount)
										.collect(Collectors.toList()));
		return respBoardDto;
		
	}
	@Override
	public List<RevenueAnalysisDto> historicalShiftAnalysis(){
		List<ExamShiftAnalysisData> results = examService.historicalShiftAnalysis();
		List<RevenueAnalysisDto> responseDtos = new ArrayList<>();
		examShifPopulator.populateAll(results, responseDtos);
		return responseDtos;

	}

}
