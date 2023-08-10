package org.gsc.api.dto;

import java.util.Set;

public class VenueDto {
	int id;
	String name;
	String status;
	String code;
	String address;
	String convenor;
	String phone;
	String picture;
	Set<ExamDto> exam;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the convenor
	 */
	public String getConvenor() {
		return convenor;
	}

	/**
	 * @param convenor the convenor to set
	 */
	public void setConvenor(String convenor) {
		this.convenor = convenor;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * @return the exam
	 */
	public Set<ExamDto> getExam() {
		return exam;
	}

	/**
	 * @param exam the exam to set
	 */
	public void setExam(Set<ExamDto> exam) {
		this.exam = exam;
	}

	
	

}
