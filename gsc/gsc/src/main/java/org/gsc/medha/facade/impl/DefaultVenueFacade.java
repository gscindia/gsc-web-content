package org.gsc.medha.facade.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gsc.api.dto.VenueDto;
import org.gsc.medha.entity.Venue;
import org.gsc.medha.facade.VenueFacade;
import org.gsc.medha.page.form.VenueForm;
import org.gsc.medha.service.VenueService;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component
public class DefaultVenueFacade implements VenueFacade {

	@Autowired
	VenueService venueService;
	@Resource(name = "venueWebPopulator")
	Populator<Venue, VenueDto> populator;
	@Resource(name = "venueAutoCompletePopulator")
	Populator<List<Venue>, Map<String,String>> autoCompletePopulator;
	@Resource(name="venueRevPopulator")
	Populator<VenueForm,Venue> venueRevPopulator;
	

	@Override
	public List<VenueDto> getAllActiveVenue() {
		List<VenueDto> venues = new ArrayList<>();
		populator.populateAll(venueService.getAllActiveVenue(), venues);
		return venues;
	}

	@Override
	public List<VenueDto> getAllVenue() {
		List<VenueDto> venues = new ArrayList<>();
		populator.populateAll(venueService.getAllVenue(), venues);
		return venues;
	}

	@Override
	public String getAutoComplete() throws JsonProcessingException {
		Map<String,String> data = new HashMap<String, String>();
		autoCompletePopulator.populate(venueService.getAllActiveVenue(), data);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(data);
	}
	@Override
	public String getAutoComplete(List<Venue> source) throws JsonProcessingException {
		Map<String,String> data = new HashMap<String, String>();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(data);
	}
	@Override
	public VenueDto save(VenueForm source) {
		Venue target = new Venue();
		venueRevPopulator.populate(source, target);
		Venue venue = venueService.save(target);
		VenueDto venueDto = new VenueDto();
		populator.populate(venue, venueDto);
		return venueDto;
	}

}
