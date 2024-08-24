package org.gsc.medha.dto;

import java.sql.Date;

public class CandidateDto {
	String roll;
	String rollId;
	String name;
	String cls;
	SchoolDto school;
	Date dob;
	String status;
	String gender;
	String schedule;
	ExamDto exam = new ExamDto();
	String maskedRollid;
	String marks;
	String editStatus;
	String grade;
	String contact;
	Integer attendance;
	

	public Integer getAttendance() {
		return attendance;
	}

	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEditStatus() {
		return editStatus;
	}

	public void setEditStatus(String editStatus) {
		this.editStatus = editStatus;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	/**
	 * @return the roll
	 */
	public String getRoll() {
		return roll;
	}

	/**
	 * @param roll the roll to set
	 */
	public void setRoll(String roll) {
		this.roll = roll;
	}

	/**
	 * @return the rollId
	 */
	public String getRollId() {
		return rollId;
	}

	/**
	 * @param rollId the rollId to set
	 */
	public void setRollId(String rollId) {
		this.rollId = rollId;
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
	 * @return the cls
	 */
	public String getCls() {
		return cls;
	}

	/**
	 * @param cls the cls to set
	 */
	public void setCls(String cls) {
		this.cls = cls;
	}

	/**
	 * @return the school
	 */
	public SchoolDto getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(SchoolDto school) {
		this.school = school;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public ExamDto getExam() {
		return exam;
	}

	public void setExam(ExamDto exam) {
		this.exam = exam;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getMaskedRollid() {
		return maskedRollid;
	}

	public void setMaskedRollid(String maskedRollid) {
		this.maskedRollid = maskedRollid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	

}
