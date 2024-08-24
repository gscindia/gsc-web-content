package org.gsc.medha.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RevenueAnalysisDto {
private String name;
private List<Long> data = new ArrayList<>();
}
