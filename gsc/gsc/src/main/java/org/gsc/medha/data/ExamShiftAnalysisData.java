package org.gsc.medha.data;

public class ExamShiftAnalysisData {
    String examName;
    Long firstHalf;
    Long secondHalf;
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Long getFirstHalf() {
		return firstHalf;
	}
	public void setFirstHalf(Long firstHalf) {
		this.firstHalf = firstHalf;
	}
	public Long getSecondHalf() {
		return secondHalf;
	}
	public void setSecondHalf(Long secondHalf) {
		this.secondHalf = secondHalf;
	}
	public ExamShiftAnalysisData(String examName, Long firstHalf, Long secondHalf) {
		super();
		this.examName = examName;
		this.firstHalf = firstHalf;
		this.secondHalf = secondHalf;
	}
}
