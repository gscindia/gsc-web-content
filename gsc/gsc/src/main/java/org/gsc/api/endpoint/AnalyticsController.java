package org.gsc.api.endpoint;

import org.gsc.api.dto.SchoolGenderDataDto;
import org.gsc.medha.facade.MedhaSandhanAnalyticsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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

	@ResponseBody
	@PostMapping("/sgc")
	public SchoolGenderDataDto getSchoolGenderChartData(@RequestParam int year) {

		return analytics.getSchoolGenderChartData(year);

	}

	@ResponseBody
	@PostMapping("/cgs")
	public SchoolGenderDataDto getClassGenderStatistics(@RequestParam int year) {

		return analytics.getClassGenderStatistics(year);

	}

}
