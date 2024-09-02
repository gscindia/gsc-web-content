package org.gsc.medha.facade;

import java.util.List;

import org.gsc.medha.dto.RevenueAnalysisDto;
import org.gsc.medha.dto.SchoolGenderDataDto;
import org.gsc.medha.dto.SchoolLeaderBoardDto;

public interface MedhaSandhanAnalyticsFacade {

	SchoolGenderDataDto getSchoolGenderChartData(int examId, int schoolId);

	SchoolGenderDataDto getClassGenderStatistics(int examId);

	int enrollmentCount(int examId);

	List<RevenueAnalysisDto> revenueTrendByClass();

	List<RevenueAnalysisDto> revenueTrend();

	SchoolLeaderBoardDto getSchoolLeaderboard(int examId);

	List<RevenueAnalysisDto> historicalShiftAnalysis();

}
