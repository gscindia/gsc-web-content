package org.gsc.medha.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="code")
	int id;
	String name;
	int roll;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "school", referencedColumnName = "id")
	School school;
	@Column(name = "class")
	int section;
	Date dob;
	String status;
	String gender;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "exam", referencedColumnName = "id")
	Exam exam = new Exam();
	String contact;
	String notification;

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
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * @return the section
	 */
	public int getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public void setSection(int section) {
		this.section = section;
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

	/**
	 * @return the exam
	 */
	public Exam getExam() {
		return exam;
	}

	/**
	 * @param exam the exam to set
	 */
	public void setExam(Exam exam) {
		this.exam = exam;
	}


	/**
	 * @return the roll
	 */
	public int getRoll() {
		return roll;
	}

	/**
	 * @param roll the roll to set
	 */
	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	

	

}
