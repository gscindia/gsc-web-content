package org.gsc.medha.facade;

import java.util.List;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.page.form.CandidateForm;
import org.gsc.medha.page.form.ExamForm;
import org.gsc.medha.page.form.FilterForm;

public interface ExamFacade {
	ExamDto createExam(ExamForm form);

	List<ExamDto> getAllExam();

	CandidateDto addCandidate(CandidateForm source);

	List<CandidateDto> filterFormB(FilterForm form);

	List<CandidateDto> getAdmitCards(FilterForm form);

	ExamDto getActiveExam();


}
