package org.gsc.medha.api.endpoint;

import java.util.List;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.facade.CandidateFacade;
import org.gsc.medha.facade.ExamFacade;
import org.gsc.medha.page.form.CandidateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medha/student")
public class StudentController {

	@Autowired
	CandidateFacade candidateFacade;
	@Autowired
	ExamFacade examFacade;

	@PostMapping
	@ResponseBody
	public List<CandidateDto> get() {

		return candidateFacade.getAll();

	}

	@PostMapping("/add")
	@ResponseBody
	public CandidateDto enrollCandidate(@RequestBody CandidateForm form) {
		CandidateDto dto = examFacade.addCandidate(form);
		return dto;
	}

	@PostMapping("/edit")
	@ResponseBody
	public void editCandidate(@RequestBody CandidateForm form) {
		form.setAction("edit");
		candidateFacade.editCandidate(form);
	}

	@PostMapping("/remove/{id}")
	@ResponseBody
	public void removeCandidate(@PathVariable int id) {
		 candidateFacade.removeCandidate(id);
	}
}
