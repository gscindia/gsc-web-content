package org.gsc.medha.facade.impl;

import java.util.List;
import java.util.Map;

import org.gsc.api.dto.SchoolGenderDataDto;
import org.gsc.medha.facade.MedhaSandhanAnalytics;
import org.gsc.medha.service.SchoolService;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultMedhaSandhanAnalytics implements MedhaSandhanAnalytics {
	@Autowired
	Populator<List<Map<String, String>>, SchoolGenderDataDto> populator;
	@Autowired
	SchoolService schoolService;

	@Override
	public SchoolGenderDataDto getSchoolGenderChartData() {
		SchoolGenderDataDto dto = new SchoolGenderDataDto();
		populator.populate(schoolService.getStudentStatistics(), dto);
		return dto;

	}
	@Override
	public SchoolGenderDataDto getClassGenderStatistics() {
		SchoolGenderDataDto dto = new SchoolGenderDataDto();
		populator.populate(schoolService.getClassGenderStatistics(), dto);
		return dto;
		
	}

}
