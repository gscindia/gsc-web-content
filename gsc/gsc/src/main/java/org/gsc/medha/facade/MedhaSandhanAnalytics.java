package org.gsc.medha.facade;

import org.gsc.api.dto.SchoolGenderDataDto;

public interface MedhaSandhanAnalytics {

	SchoolGenderDataDto getSchoolGenderChartData();

	SchoolGenderDataDto getClassGenderStatistics();

}
