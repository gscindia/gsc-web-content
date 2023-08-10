package org.gsc.api.endpoint;

import org.gsc.api.dto.SchoolGenderDataDto;
import org.gsc.medha.facade.MedhaSandhanAnalytics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class AnalyticsController {

	@Autowired
	MedhaSandhanAnalytics analytics;

	@ResponseBody
	@PostMapping("/sgc")
	public SchoolGenderDataDto getSchoolGenderChartData() {

		return analytics.getSchoolGenderChartData();

	}

}
