package org.gsc.medha.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SchoolLeaderBoardDto {
    List<String> school = new ArrayList<>();
    List<Long> application = new ArrayList<>();
	public List<String> getSchool() {
		return school;
	}
	public void setSchool(List<String> school) {
		this.school = school;
	}
	public List<Long> getApplication() {
		return application;
	}
	public void setApplication(List<Long> application) {
		this.application = application;
	}
    
}
