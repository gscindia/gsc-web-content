package org.gsc.medha.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RevenueAnalysisDto {
private String name;
private List<Long> data = new ArrayList<>();
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Long> getData() {
	return data;
}
public void setData(List<Long> data) {
	this.data = data;
}

}
