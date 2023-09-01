package org.gsc.api.dto;

import java.util.List;

public class SchoolGenderDataDto {
	List<String> school;
	List<Integer> male;
	List<Integer> female;

	public List<String> getSchool() {
		return school;
	}

	public void setSchool(List<String> school) {
		this.school = school;
	}

	public List<Integer> getMale() {
		return male;
	}

	public void setMale(List<Integer> male) {
		this.male = male;
	}

	public List<Integer> getFemale() {
		return female;
	}

	public void setFemale(List<Integer> female) {
		this.female = female;
	}


}
