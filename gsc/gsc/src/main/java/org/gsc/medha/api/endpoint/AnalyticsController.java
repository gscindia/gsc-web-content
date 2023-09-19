package org.gsc.medha.api.endpoint;

import org.gsc.medha.dto.SchoolGenderDataDto;
import org.gsc.medha.facade.ExamFacade;
import org.gsc.medha.facade.MedhaSandhanAnalyticsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class AnalyticsController {

	@Autowired
	MedhaSandhanAnalyticsFacade analytics;
	@Autowired
	ExamFacade examFacade;

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

}
