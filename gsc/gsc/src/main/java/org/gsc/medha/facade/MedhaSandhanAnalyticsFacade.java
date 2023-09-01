package org.gsc.medha.facade;

import org.gsc.medha.dto.SchoolGenderDataDto;

public interface MedhaSandhanAnalyticsFacade {

	SchoolGenderDataDto getSchoolGenderChartData(int examId);

	SchoolGenderDataDto getClassGenderStatistics(int examId);

}
