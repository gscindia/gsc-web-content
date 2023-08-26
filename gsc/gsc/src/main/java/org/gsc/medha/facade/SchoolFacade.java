package org.gsc.medha.facade;

import java.util.List;

import org.gsc.api.dto.CandidateDto;
import org.gsc.api.dto.FormAPageableDto;
import org.gsc.api.dto.SchoolDto;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.page.form.SchoolForm;

public interface SchoolFacade {
	List<SchoolDto> getAllSchool();

	SchoolDto findBySchoolName(String name);

	SchoolDto getSchoolById(String id);

	List<CandidateDto> filteFormA(FilterForm filter);

	FormAPageableDto pageableForm(List<CandidateDto> list, int page);

	SchoolDto add(SchoolForm form);
}