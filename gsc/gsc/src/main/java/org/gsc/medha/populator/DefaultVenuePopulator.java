package org.gsc.medha.populator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.dto.VenueDto;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.Venue;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("venueWebPopulator")
public class DefaultVenuePopulator implements Populator<Venue,VenueDto> {

	@Resource(name="examPopulator")
	Populator<Exam,ExamDto> examPopulator;
	@Override
	public void populate(Venue source, VenueDto target) {
		
		target.setId(source.getId());
		target.setName(source.getName());
		target.setStatus(source.getStatus());
		target.setCode(source.getCode());
		target.setAddress(source.getAddress());
		target.setConvenor(source.getConvenor().toUpperCase());
		target.setPhone("+91 "+source.getPhone());
		target.setPicture(source.getPicture());
		List<ExamDto> examSet = new ArrayList<>();
		examPopulator.populateAll(source.getExam().stream().collect(Collectors.toList()), examSet);
		target.setExam(examSet.stream().collect(Collectors.toSet()));
	}

	@Override
	public void populateAll(List<Venue> source, List<VenueDto> target) {
		for(Venue s: source) {
			VenueDto venue = new VenueDto();
			this.populate(s, venue);
			target.add(venue);
		}
		
	}

}
