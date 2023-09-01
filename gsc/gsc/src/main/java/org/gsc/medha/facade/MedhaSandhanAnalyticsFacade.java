package org.gsc.medha.facade;

import org.gsc.api.dto.SchoolGenderDataDto;

public interface MedhaSandhanAnalyticsFacade {

	SchoolGenderDataDto getSchoolGenderChartData(int examId);

	SchoolGenderDataDto getClassGenderStatistics(int examId);

}
