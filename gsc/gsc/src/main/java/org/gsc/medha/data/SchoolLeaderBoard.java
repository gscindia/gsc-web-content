package org.gsc.medha.data;



public class SchoolLeaderBoard {
    private String schoolName;
    private Long count;
	public SchoolLeaderBoard(String schoolName, Long count) {
		super();
		this.schoolName = schoolName;
		this.count = count;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
    

}
