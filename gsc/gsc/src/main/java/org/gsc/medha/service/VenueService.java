package org.gsc.medha.service;

import java.util.List;

import org.gsc.medha.entity.Venue;

public interface VenueService {
	List<Venue> getAllVenue();

	List<Venue> getAllActiveVenue();

	Venue save(Venue venue);

	Venue findOneByName(String name);
}
