package org.gsc.medha.facade;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.entity.Candidate;
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

	List<Candidate> readMarksFromFile(InputStream is) throws IOException;

	Map<Integer, Integer> saveMarksheet(List<Candidate> cand);

	ByteArrayOutputStream  preFillData(FilterForm form) throws IOException;

	List<CandidateDto> addCandidates(List<CandidateForm> source);

	List<CandidateForm> readBulkEnrollmentFile(InputStream is) throws IOException;

}
