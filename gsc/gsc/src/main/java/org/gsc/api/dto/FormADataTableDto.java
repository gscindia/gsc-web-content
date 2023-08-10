package org.gsc.api.dto;

import java.util.ArrayList;
import java.util.List;

public class FormADataTableDto {

	List<String[]> data = new ArrayList<>();

	public List<String[]> getData() {
		return data;
	}

	public void setData(List<String[]> data) {
		this.data = data;
	}

}
