package org.gsc.medha.facade;

import java.util.List;

import org.gsc.api.dto.VenueDto;
import org.gsc.medha.entity.Venue;
import org.gsc.medha.page.form.VenueForm;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface VenueFacade {
	List<VenueDto> getAllVenue();

	List<VenueDto> getAllActiveVenue();

	String getAutoComplete() throws JsonProcessingException;

	String getAutoComplete(List<Venue> source) throws JsonProcessingException;

	VenueDto save(VenueForm source);

}
