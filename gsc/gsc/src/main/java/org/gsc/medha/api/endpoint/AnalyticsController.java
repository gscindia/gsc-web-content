package org.gsc.medha.api.endpoint;

import java.util.List;

import org.gsc.medha.data.ExamRevenueData;
import org.gsc.medha.dto.RevenueAnalysisDto;
import org.gsc.medha.dto.SchoolGenderDataDto;
import org.gsc.medha.dto.SchoolLeaderBoardDto;
import org.gsc.medha.facade.MedhaSandhanAnalyticsFacade;
import org.gsc.medha.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/reports")
public class AnalyticsController {

	@Autowired
	MedhaSandhanAnalyticsFacade analytics;
	@Autowired 
	ExamRepository examRepository;

	@ResponseBody
	@PostMapping("/sgc")
	public SchoolGenderDataDto getSchoolGenderChartData(@RequestParam(defaultValue = "-1") int year,@RequestParam(defaultValue = "-1") int schoolId) {

		return analytics.getSchoolGenderChartData(year,schoolId);

	}

	@ResponseBody
	@PostMapping("/cgs")
	public SchoolGenderDataDto getClassGenderStatistics(@RequestParam int year) {

		return analytics.getClassGenderStatistics(year);

	}

	@ResponseBody
	@PostMapping("/enrollment")
	public Integer getEnrollmentCountChart(@RequestParam int year) {
		return analytics.enrollmentCount(year);

	}

	@ResponseBody
	@PostMapping("/revenue")
	public List<RevenueAnalysisDto> revenueByClass() {				
		return analytics.revenueTrendByClass();
	}

	@ResponseBody
	@PostMapping("/revenue/trend")
	public List<RevenueAnalysisDto> revenueTrendByYear() {				
		return analytics.revenueTrend();
	}
	
	@ResponseBody
	@PostMapping("/school-leaderboard")
	public SchoolLeaderBoardDto postMethodName(@RequestParam(defaultValue = "-1") int year) {		
		
		return analytics.getSchoolLeaderboard(year);

	}
	@ResponseBody
	@PostMapping("/shift-analysis")
	public List<RevenueAnalysisDto> shiftAnalysis() {
				
		return analytics.historicalShiftAnalysis();
	}
	
	

}
