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
			str[1] = "<a target='_blank' class='tooltipped' data-tooltip='Print Admit Card' data-position='top' href='admit-card/" + s.getId() + "'>"
					+ s.getName().toUpperCase() + "</a>&nbsp;" + "<i onClick='popModal(" + s.getId()
					+ ");' class='tooltipped material-icons tiny right' data-tooltip='Edit Student Details' data-position='left'>edit</i>"
					+ "&nbsp;<i class='tooltipped material-icons tiny right' data-tooltip='Delete Student Record' data-position='right' data-id='" + s.getId()
					+ "' onClick='removeStudent(" + s.getId() + ");'>remove_circle</i>";
			str[2] = GscUtils.integerToRoman(s.getSection());
			if (s.getExam().getDate() != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
				str[3] = formatter.format(s.getExam().getDate());
			}
			else {
				str[3]="";
			}
			str[4] = null == s.getMarks() ? "" : String.valueOf(s.getMarks());
			target.add(str);

		});

	}

}
