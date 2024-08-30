package org.gsc.medha.populator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.gsc.medha.data.ExamShiftAnalysisData;
import org.gsc.medha.dto.RevenueAnalysisDto;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("examShiftPopulator")
public class ExamShiftHistoryPopulator implements Populator<ExamShiftAnalysisData, RevenueAnalysisDto> {

    @Override
    public void populate(ExamShiftAnalysisData source, RevenueAnalysisDto target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'populate'");
    }

    @Override
    public void populateAll(List<ExamShiftAnalysisData> source, List<RevenueAnalysisDto> target) {

        RevenueAnalysisDto shift = new RevenueAnalysisDto();
        shift.setName("Primary");
        shift.setData(
                source
                        .stream()
                        .map(ExamShiftAnalysisData::getFirstHalf)
                        .collect(Collectors.toList()));
        target.add(shift);
        shift = new RevenueAnalysisDto();
        shift.setName("Secondary");
        shift.setData(
                source
                        .stream()
                        .map(ExamShiftAnalysisData::getSecondHalf)
                        .collect(Collectors.toList()));
        target.add(shift);

    }

}
