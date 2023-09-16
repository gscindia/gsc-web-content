package org.gsc.medha.populator;

import java.util.ArrayList;
import java.util.List;

import org.gsc.medha.entity.Candidate;
import org.springframework.stereotype.Component;

@Component("marksPreviewDataTablePopulator")
public class DefaultMarksPreviewPopulator extends DefaultFormADatatablePopulator {

	@Override
	public void populate(Candidate source, String[] target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void populateAll(List<Candidate> source, List<String[]> target) {
		List<String[]> finalTarget = new ArrayList<String[]>();
		super.populateAll(source, target);
		for (int i = 0; i < target.size(); i++) {
			String[] tempTarget = target.get(i);
			tempTarget[3] = source.get(i).getMarks() + "";
			tempTarget[1] = source.get(i).getName().toUpperCase();
			finalTarget.add(tempTarget);
		}
		target = finalTarget;

	}

}
