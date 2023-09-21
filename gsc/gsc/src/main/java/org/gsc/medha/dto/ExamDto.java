package org.gsc.medha.dto;

import java.util.ArrayList;
import java.util.List;

public class ExamDto {
	int id;
	String name;
	String formattedName;
	String date;
	String status;
	List<VenueDto> venue = new ArrayList<>();
	List<PricerowDto> pricees = new ArrayList<PricerowDto>();

	public List<PricerowDto> getPricees() {
		return pricees;
	}

	public void setPricees(List<PricerowDto> pricees) {
		this.pricees = pricees;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getFormattedName() {
		return formattedName;
	}

	public void setFormattedName(String formattedName) {
		this.formattedName = formattedName;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the venue
	 */
	public List<VenueDto> getVenue() {
		return venue;
	}

	/**
	 * @param venue the venue to set
	 */
	public void setVenue(List<VenueDto> venue) {
		this.venue = venue;
	}

}
