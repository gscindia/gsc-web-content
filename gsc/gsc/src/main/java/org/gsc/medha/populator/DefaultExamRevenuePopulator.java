package org.gsc.medha.populator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.gsc.medha.data.ExamRevenueData;
import org.gsc.medha.dto.RevenueAnalysisDto;
import org.gsc.populator.Populator;
import org.gsc.utility.GscUtils;
import org.springframework.stereotype.Component;

@Component("revenuePopulator")
public class DefaultExamRevenuePopulator implements Populator<ExamRevenueData, RevenueAnalysisDto> {

    @Override
    @Deprecated
    public void populate(ExamRevenueData source, RevenueAnalysisDto target) {
        //target.setClassName(source.getClassNum() + "");
    }

    @Override
    public void populateAll(List<ExamRevenueData> source, List<RevenueAnalysisDto> target) {
        Map<Integer,List<Long>> resultMap  = new LinkedHashMap<>();
        for (int classNum = 2; classNum <= 10; classNum++) {
            final int i = classNum;
            List<Long> revenues = source.stream()
                .filter(exam -> exam.getClassNum() == i)
                .map(ExamRevenueData::getRevenue)
                .collect(Collectors.toList());           
            resultMap.put(classNum, revenues);
        }       
        // List<Long> totalRevenueList = source.stream()
        //         .filter(exam -> exam.getClassNum() == 0)
        //         .map(ExamRevenueData::getRevenue)
        //         .collect(Collectors.toList());
        //         resultMap.put(0, totalRevenueList);

        resultMap.forEach((classNum, revenues) -> {            
            RevenueAnalysisDto objecDto = new RevenueAnalysisDto();
            if(classNum!=0){
                objecDto.setName(GscUtils.integerToRoman(classNum));
                objecDto.setData(revenues);
            }else{
                // objecDto.setName("Total Revenue");
                // objecDto.setData(totalRevenueList);
            }
            
            target.add(objecDto);
        });

        
        
    }

}
