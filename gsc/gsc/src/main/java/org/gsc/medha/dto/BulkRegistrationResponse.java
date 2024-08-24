package org.gsc.medha.dto;

import java.util.List;

public class BulkRegistrationResponse {
	
	List<CandidateDto> response;
	String processed;
	
	public List<CandidateDto> getResponse() {
		return response;
	}
	public void setResponse(List<CandidateDto> response) {
		this.response = response;
	}
	public String getProcessed() {
		return processed;
	}
	public void setProcessed(String processed) {
		this.processed = processed;
	}
	
	

}
