package org.gsc.medha.dto;


public class SchoolDto {

	int id;
	String name;
	String address;
	String formattedAddress;
	String district;
	String state;
	String pincode;
	String contactno;
	String poc;
	String picture;
	String status;
	VenueDto venue;
	
	
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
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the formattedAddress
	 */
	public String getFormattedAddress() {
		return formattedAddress;
	}
	/**
	 * @param formattedAddress the formattedAddress to set
	 */
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the contactno
	 */
	public String getContactno() {
		return contactno;
	}
	/**
	 * @param contactno the contactno to set
	 */
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	/**
	 * @return the poc
	 */
	public String getPoc() {
		return poc;
	}
	/**
	 * @param poc the poc to set
	 */
	public void setPoc(String poc) {
		this.poc = poc;
	}
	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
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
	public VenueDto getVenue() {
		return venue;
	}
	/**
	 * @param venue the venue to set
	 */
	public void setVenue(VenueDto venue) {
		this.venue = venue;
	}
	
	
	
}
