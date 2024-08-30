package org.gsc.medha.data;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamRevenueData {
    private int examId;
    private String examName;
    private int classNum;
    private Long revenue;
}
