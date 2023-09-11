package org.gsc.medha.populator;

import java.text.SimpleDateFormat;
import java.util.List;

import org.gsc.medha.entity.Candidate;
import org.gsc.populator.Populator;
import org.gsc.utility.GscUtils;
import org.springframework.stereotype.Component;

@Component("formADataTablePopulator")
public class DefaultFormADatatablePopulator implements Populator<Candidate, String[]> {

	@Override
	public void populate(Candidate source, String[] target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void populateAll(List<Candidate> source, List<String[]> target) {
		source.forEach(s -> {
			String[] str = new String[6];
			str[0] = (s.getGender().equalsIgnoreCase("F") ? "F" : "").concat(s.getRoll() + "");
			str[1] = "<a target='_blank' title='Print Admit Card' href='admit-card/" + s.getId() + "'>"
					+ s.getName().toUpperCase() + "</a>&nbsp;" + "<i onClick='popModal(" + s.getId()
					+ ");' class='material-icons tiny right' title='Edit Details'>edit</i>"
					+ "&nbsp;<i class='material-icons tiny right' title='Remove' data-id='" + s.getId()
					+ "' onClick='removeStudent(" + s.getId() + ");'>remove_circle</i>";
			str[2] = GscUtils.integerToRoman(s.getSection());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
			str[3] = formatter.format(s.getExam().getDate());
			str[4] = s.getStatus();
			target.add(str);

		});

	}

}
