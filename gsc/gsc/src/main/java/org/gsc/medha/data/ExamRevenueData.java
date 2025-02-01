package org.gsc.medha.data;


public class ExamRevenueData {
	private int examId;
	private int classNum;
	private Long revenue;

	public ExamRevenueData(int i, int j, Long revenue2) {
		this.examId = i;
		this.classNum = j;
		this.revenue = revenue2;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public Long getRevenue() {
		return revenue;
	}

	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}
}
