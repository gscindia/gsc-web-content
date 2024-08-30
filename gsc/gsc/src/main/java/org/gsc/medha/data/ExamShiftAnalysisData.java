package org.gsc.medha.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamShiftAnalysisData {
    String examName;
    Long firstHalf;
    Long secondHalf;
}
