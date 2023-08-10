package org.gsc.medha.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.gsc.medha.entity.Venue;
import org.gsc.medha.repository.VenueRepository;
import org.gsc.medha.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultVenueService implements VenueService {
	@Autowired
	VenueRepository venueRepository;

	@Override
	public List<Venue> getAllVenue() {
		List<Venue> venues = new ArrayList<>();
		venueRepository.findAll().forEach(venues::add);
		return venues;
	}

	@Override
	public List<Venue> getAllActiveVenue() {
		return this.getAllVenue().stream().filter(v -> v.getStatus().equalsIgnoreCase("active"))
				.collect(Collectors.toList());

	}

	@Override
	public Venue save(Venue venue) {
		return venueRepository.save(venue);
	}

	@Override
	public Venue findOneByName(String name) {
		Venue venue = (Venue) venueRepository.findByVenueName(name).get(0);
		return venue;
	}

}
