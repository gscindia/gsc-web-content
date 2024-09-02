package org.gsc.medha.populator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.gsc.medha.data.ExamRevenueData;
import org.gsc.medha.dto.RevenueAnalysisDto;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("totalRevenueTrendPopulator")
public class ExamRevenueTrendPopulator implements Populator<ExamRevenueData, RevenueAnalysisDto> {

    @Override
    public void populate(ExamRevenueData source, RevenueAnalysisDto target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'populate'");
    }

    @Override
    public void populateAll(List<ExamRevenueData> source, List<RevenueAnalysisDto> target) {
        Map<Integer, List<Long>> resultMap = new LinkedHashMap<>();
        List<Long> totalRevenueList = source.stream()
                .filter(exam -> exam.getClassNum() == 0)
                .map(ExamRevenueData::getRevenue)
                .collect(Collectors.toList());
        resultMap.put(0, totalRevenueList);

        resultMap.forEach((classNum, revenues) -> {
            RevenueAnalysisDto objecDto = new RevenueAnalysisDto();
            objecDto.setName("Total Revenue");
            objecDto.setData(totalRevenueList);

            target.add(objecDto);
        });
    }

}
