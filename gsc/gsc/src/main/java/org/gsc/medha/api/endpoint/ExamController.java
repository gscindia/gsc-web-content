package org.gsc.medha.api.endpoint;

import java.util.List;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.facade.ExamFacade;
import org.gsc.medha.page.form.ExamForm;
import org.gsc.medha.page.form.FilterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medha/exam")
public class ExamController {

	@Autowired
	ExamFacade examFacade;

	@PostMapping("/add")
	@ResponseBody
	public ExamDto save(@RequestBody ExamForm form) {

		return examFacade.createExam(form);

	}

	@PostMapping("/formb")
	@ResponseBody
	public List<CandidateDto> getFormB(@RequestBody FilterForm filterForm) {
		return examFacade.filterFormB(filterForm);
	}

}
