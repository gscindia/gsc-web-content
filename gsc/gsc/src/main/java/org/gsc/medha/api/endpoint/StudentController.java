package org.gsc.medha.api.endpoint;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.gsc.medha.dto.BulkRegistrationResponse;
import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.facade.CandidateFacade;
import org.gsc.medha.facade.ExamFacade;
import org.gsc.medha.page.form.CandidateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		CandidateDto dto = new CandidateDto();
		if (StringUtils.isNotEmpty(form.getName()) && StringUtils.isNotEmpty(form.getCls())
				&& StringUtils.isNotEmpty(form.getGender())
				&& StringUtils.isNotEmpty(form.getSchool())) {
				
					dto = examFacade.addCandidate(form);
		}
		return dto;
	}

	@PostMapping("/bulk-registration/{schoolId}")
	@ResponseBody
	public BulkRegistrationResponse enrollCandidate(@RequestParam("file") MultipartFile file,
			@PathVariable String schoolId)
			throws IOException {
		List<CandidateForm> form = examFacade.readBulkEnrollmentFile(file.getInputStream());
		BulkRegistrationResponse response = new BulkRegistrationResponse();
		form.stream().filter(i -> Objects.nonNull(i)).forEach(candidate -> candidate.setSchool(schoolId));
		List<CandidateDto> dto = examFacade.addCandidates(form);
		response.setProcessed(dto.size() + "");
		response.setResponse(dto);
		return response;
	}

	@PostMapping("/edit")
	@ResponseBody
	public CandidateDto editCandidate(@RequestBody CandidateForm form) {
		form.setAction("edit");
		return candidateFacade.editCandidate(form);
	}

	@PostMapping("/remove/{id}")
	@ResponseBody
	public void removeCandidate(@PathVariable int id) {
		candidateFacade.removeCandidate(id);
	}
}
