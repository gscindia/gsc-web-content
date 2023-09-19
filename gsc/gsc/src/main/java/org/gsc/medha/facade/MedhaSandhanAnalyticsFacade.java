package org.gsc.medha.facade;

import org.gsc.medha.dto.SchoolGenderDataDto;

public interface MedhaSandhanAnalyticsFacade {

	SchoolGenderDataDto getSchoolGenderChartData(int examId, int schoolId);

	SchoolGenderDataDto getClassGenderStatistics(int examId);

	int enrollmentCount(int examId);

}
