package org.gsc.api.dto;

import java.util.List;

public class FormAPageableDto {
	
	int pageSize;
	List<List<CandidateDto>> breakup;


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<List<CandidateDto>> getBreakup() {
		return breakup;
	}

	public void setBreakup(List<List<CandidateDto>> breakup) {
		this.breakup = breakup;
	}

	

}
