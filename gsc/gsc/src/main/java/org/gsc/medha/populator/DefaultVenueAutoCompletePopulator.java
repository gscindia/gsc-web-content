package org.gsc.medha.populator;

import java.util.List;
import java.util.Map;

import org.gsc.medha.entity.Venue;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("venueAutoCompletePopulator")
public class DefaultVenueAutoCompletePopulator implements Populator<List<Venue>, Map<String, String>> {

	@Override
	public void populate(List<Venue> source, Map<String, String> target) {
		source.forEach(s -> target.put(s.getName(), null));

	}

	@Override
	public void populateAll(List<List<Venue>> source, List<Map<String, String>> target) {
		// TODO Auto-generated method stub

	}

	

}
