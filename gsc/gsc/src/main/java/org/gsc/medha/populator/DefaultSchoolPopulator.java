package org.gsc.medha.populator;

import java.util.List;

import javax.annotation.Resource;

import org.gsc.medha.dto.SchoolDto;
import org.gsc.medha.dto.VenueDto;
import org.gsc.medha.entity.School;
import org.gsc.medha.entity.Venue;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("schoolWebPopulator")
public class DefaultSchoolPopulator implements Populator<School, SchoolDto> {

	@Resource(name = "venueWebPopulator")
	Populator<Venue, VenueDto> populator;

	@Override
	public void populate(School source, SchoolDto target) {
		VenueDto venue = new VenueDto();
		populator.populate(source.getVenue(), venue);
		target.setId(source.getId());
		target.setName(source.getName());
		target.setPoc(source.getPoc());
		target.setVenue(venue);
		target.setStatus(source.getStatus());
	}

	@Override
	public void populateAll(List<School> source, List<SchoolDto> target) {
		source.forEach(s -> {
			SchoolDto school = new SchoolDto();
			this.populate(s, school);
			target.add(school);
		});
	}

}
