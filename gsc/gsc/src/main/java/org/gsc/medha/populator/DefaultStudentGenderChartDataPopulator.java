/**
 * 
 */
package org.gsc.medha.populator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gsc.medha.dto.SchoolGenderDataDto;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

/**
 * @author Suman_Banerjee
 *
 */
@Component("studentGenderChartDataPopulator")
public class DefaultStudentGenderChartDataPopulator
		implements Populator<List<Map<String, String>>, SchoolGenderDataDto> {

	@Override
	public void populate(List<Map<String, String>> source, SchoolGenderDataDto target) {
		List<String> school = new ArrayList<String>();
		List<Integer> male = new ArrayList<Integer>();
		List<Integer> female = new ArrayList<Integer>();
		for (Map<String, String> s : source) {
			school.add(s.get("series1"));
			male.add(Integer.valueOf(s.get("series2")));
			female.add(Integer.valueOf(s.get("series3")));
		}
		target.setSchool(school);
		target.setMale(male);
		target.setFemale(female);
	}

	@Override
	public void populateAll(List<List<Map<String, String>>> source, List<SchoolGenderDataDto> target) {
		// TODO Auto-generated method stub

	}

}
