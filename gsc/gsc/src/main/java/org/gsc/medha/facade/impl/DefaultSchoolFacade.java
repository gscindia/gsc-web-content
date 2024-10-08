package org.gsc.medha.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.FormAPageableDto;
import org.gsc.medha.dto.SchoolDto;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.School;
import org.gsc.medha.facade.SchoolFacade;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.page.form.SchoolForm;
import org.gsc.medha.service.SchoolService;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class DefaultSchoolFacade implements SchoolFacade {

	@Autowired
	SchoolService schoolService;
	@Resource(name = "schoolWebPopulator")
	Populator<School, SchoolDto> populator;
	@Resource(name = "schoolRevPopulator")
	Populator<SchoolForm, School> schoolRevPopulator;
	@Resource(name = "candidatePopulator")
	Populator<Candidate, CandidateDto> candidatePopulator;
	@Resource(name = "filterPopulator")
	Populator<FilterForm, Candidate> filterPopulator;
	@Resource(name = "admitCardPopulator")
	Populator<Candidate, CandidateDto> admitCardPopulator;
	@Resource(name = "markSheetPopulator")
	Populator<Candidate, CandidateDto> markSheetPopulator;

	@Override
	public SchoolDto add(SchoolForm form) {
		SchoolDto dto = new SchoolDto();
		School school = new School();
		schoolRevPopulator.populate(form, school);
		schoolService.add(school);
		populator.populate(school, dto);
		return dto;
	}

	@Override
	public List<SchoolDto> getAllSchool() {
		List<SchoolDto> target = new ArrayList<>();
		populator.populateAll(schoolService.getAllSchool(), target);
		return target;
	}

	@Override
	public SchoolDto findBySchoolName(String name) {
		SchoolDto school = new SchoolDto();
		populator.populate(schoolService.findBySchoolName(name), school);
		return school;
	}

	@Override
	public SchoolDto getSchoolById(String id) {
		SchoolDto school = new SchoolDto();
		populator.populate(schoolService.getSchoolById(Integer.parseInt(id)), school);
		return school;
	}

	@Override
	public List<CandidateDto> filteFormA(FilterForm filter) {

		List<CandidateDto> candidatesDto = new ArrayList<>();
		Candidate candidate = new Candidate();
		filterPopulator.populate(filter, candidate);
		candidatePopulator.populateAll(candidate.getExam() == null ? schoolService.getFormA(candidate)
				: schoolService.getFormAByExam(candidate), candidatesDto);
		return candidatesDto;
	}

	@Override
	public FormAPageableDto pageableForm(List<CandidateDto> list, int page) {

		FormAPageableDto response = new FormAPageableDto();
		List<List<CandidateDto>> breakup = new ArrayList<List<CandidateDto>>();
		List<CandidateDto> row = new ArrayList<CandidateDto>();
		for (int i = 0, ctr = 1; i < list.size(); i++) {
			row.add(list.get(i));

			if (ctr == page) {
				ctr = 1;
				breakup.add(row);
				row = new ArrayList<CandidateDto>();
				continue;

			} else {

				++ctr;
			}

		}
		if (!CollectionUtils.isEmpty(row)) {
			breakup.add(row);
		}
		response.setBreakup(breakup);
		return response;

	}

	@Override
	public List<CandidateDto> getAdmitCards(FilterForm filter) {

		List<CandidateDto> candidatesDto = new ArrayList<>();
		Candidate candidate = new Candidate();
		filterPopulator.populate(filter, candidate);
		admitCardPopulator.populateAll(schoolService.getFormAByExam(candidate), candidatesDto);
		return candidatesDto;
	}

	@Override
	public List<CandidateDto> getMarks(FilterForm filter) {
		List<CandidateDto> marksDto = new ArrayList<>();
		Candidate candidate = new Candidate();
		filterPopulator.populate(filter, candidate);
		markSheetPopulator.populateAll(schoolService.getFormAByExam(candidate), marksDto);
		return marksDto;
	}

}
