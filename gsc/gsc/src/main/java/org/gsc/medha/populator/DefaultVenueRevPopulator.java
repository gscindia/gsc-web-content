package org.gsc.medha.populator;

import java.util.List;

import org.gsc.medha.entity.Venue;
import org.gsc.medha.page.form.VenueForm;
import org.gsc.medha.prop.Status;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("venueRevPopulator")
public class DefaultVenueRevPopulator implements Populator<VenueForm, Venue> {

	@Override
	public void populate(VenueForm source, Venue target) {
		target.setName(source.getName());
		target.setCode(source.getCode());
		target.setPhone(source.getPhone());
		target.setAddress(source.getAddress());
		target.setStatus(Status.ACTIVE.toString());
		target.setConvenor(source.getConvenor());
		target.setPicture(source.getPicture() != null ? source.getPicture() : "school.jpg");
	}

	@Override
	public void populateAll(List<VenueForm> source, List<Venue> target) {
		// TODO Auto-generated method stub

	}

}
