package org.gsc.medha.facade;

import java.util.List;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.FormADataTableDto;
import org.gsc.medha.dto.notification.TemplateMessage;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.page.form.CandidateForm;
import org.gsc.medha.page.form.FilterForm;

public interface CandidateFacade {
	
	List<CandidateDto> getAll();

	FormADataTableDto getDataTable(FilterForm form);

	void editCandidate(CandidateForm form);

	CandidateDto getCandidate(int id);

	void removeCandidate(int id);

	CandidateDto getAdmitCard(int id);

	List<TemplateMessage> getPendingNotification(Exam exam);

}
