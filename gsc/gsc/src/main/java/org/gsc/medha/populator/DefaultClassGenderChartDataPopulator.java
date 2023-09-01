package org.gsc.medha.populator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gsc.api.dto.SchoolGenderDataDto;
import org.gsc.utility.GscUtils;
import org.springframework.stereotype.Component;

@Component("classGenderChartDataPopulator")
public class DefaultClassGenderChartDataPopulator extends DefaultStudentGenderChartDataPopulator {

	@Override
	public void populate(List<Map<String, String>> source, SchoolGenderDataDto target) {
		super.populate(source, target);
		List<String> series1 = target.getSchool();
		List<String> formattedSeries1 = new ArrayList<>();
		series1.forEach(s->formattedSeries1.add(GscUtils.integerToRoman(Integer.parseInt(s))));
		target.setSchool(formattedSeries1);
	}

	@Override
	public void populateAll(List<List<Map<String, String>>> source, List<SchoolGenderDataDto> target) {
		// TODO Auto-generated method stub

	}
}
