package org.gsc.api.endpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gsc.api.dto.CandidateDto;
import org.gsc.api.dto.FormADataTableDto;
import org.gsc.api.dto.SchoolDto;
import org.gsc.medha.facade.CandidateFacade;
import org.gsc.medha.facade.SchoolFacade;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.page.form.SchoolForm;
import org.gsc.medha.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medha/school")
public class SchoolController {

	@Autowired
	SchoolFacade schoolFacade;
	@Autowired
	CandidateFacade candidateFacade;
	@Autowired
	SchoolService schoolService;

	@ResponseBody
	@PostMapping("/add")
	public SchoolDto addSchool(@RequestBody SchoolForm form) {

		return schoolFacade.add(form);
	}

	@ResponseBody
	@PostMapping("/forma")
	public List<CandidateDto> getFormA(@RequestBody FilterForm form) {
		List<CandidateDto> candidateDtos = new ArrayList<CandidateDto>();
		try {
			candidateDtos = schoolFacade.filteFormA(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidateDtos;
	}

	@ResponseBody
	@PostMapping("/forma/datatable/{schoolId}")
	public FormADataTableDto renderDataTable(@PathVariable int schoolId) {
		FilterForm form = new FilterForm();
		form.setSchool(schoolId);
		return candidateFacade.getDataTable(form);

	}
}
