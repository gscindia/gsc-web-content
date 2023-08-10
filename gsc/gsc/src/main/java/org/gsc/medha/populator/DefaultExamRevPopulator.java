package org.gsc.medha.populator;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.Venue;
import org.gsc.medha.page.form.ExamForm;
import org.gsc.medha.service.VenueService;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("examRevPopulator")
public class DefaultExamRevPopulator implements Populator<ExamForm, Exam> {

	@Autowired
	VenueService venueService;
	@Value("${gsc.medha.exam.class}")
	private String classes;
	@Override
	public void populate(ExamForm source, Exam target) {

		if (StringUtils.hasText(source.getDate())) {
			target.setDate(Date.valueOf(source.getDate()));
		}
		Set<Venue> venues = new HashSet<>();
		source.getVenue().forEach(v -> {
			Venue venue = venueService.findOneByName(v);
			venues.add(venue);
		});
		target.setVenue(venues);
		target.setName(source.getName());
		target.setStatus(source.getStatus());
		target.setClasses(classes);
	}

	@Override
	public void populateAll(List<ExamForm> source, List<Exam> target) {
		// TODO Auto-generated method stub

	}

}
