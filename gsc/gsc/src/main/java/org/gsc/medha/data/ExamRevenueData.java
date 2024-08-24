package org.gsc.medha.data;


import lombok.Data;

@Data
public class ExamRevenueData {
    private int examId;
    private String examName;
    private int classNum;
    private Long revenue;
    public ExamRevenueData(int examId, String examName, int classNum, Long revenue) {
        this.examId = examId;
        this.examName = examName;
        this.classNum = classNum;
        this.revenue = revenue;
    }

    
}
