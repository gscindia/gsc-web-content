package org.gsc.medha.populator;

import java.util.List;

import org.apache.commons.text.WordUtils;
import org.gsc.medha.entity.School;
import org.gsc.medha.page.form.SchoolForm;
import org.gsc.medha.repository.VenueRepository;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("schoolRevPopulator")
public class DefaultSchoolRevPopulator implements Populator<SchoolForm, School> {
	@Autowired
	VenueRepository venueRepository;

	@Override
	public void populate(SchoolForm source, School target) {
		target.setName(source.getName());
		target.setAddress(WordUtils.capitalizeFully(source.getAddress()));
		target.setVenue(venueRepository.findById(source.getVenue()).get());

	}

	@Override
	public void populateAll(List<SchoolForm> source, List<School> target) {
		// TODO Auto-generated method stub

	}

}
