package org.gsc.medha.facade;

import java.util.List;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.FormAPageableDto;
import org.gsc.medha.dto.SchoolDto;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.page.form.SchoolForm;

public interface SchoolFacade {
	List<SchoolDto> getAllSchool();

	SchoolDto findBySchoolName(String name);

	SchoolDto getSchoolById(String id);

	List<CandidateDto> filteFormA(FilterForm filter);

	FormAPageableDto pageableForm(List<CandidateDto> list, int page);

	SchoolDto add(SchoolForm form);

	List<CandidateDto> getAdmitCards(FilterForm filter);
}
