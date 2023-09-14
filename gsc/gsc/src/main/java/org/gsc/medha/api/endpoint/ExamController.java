package org.gsc.medha.api.endpoint;

import java.io.IOException;
import java.util.List;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.facade.ExamFacade;
import org.gsc.medha.page.form.ExamForm;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.service.ExamService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/medha/exam")
public class ExamController {

	@Autowired
	ExamFacade examFacade;
	@Autowired
	ExamService examService;

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

	@PostMapping("/upload-attendence")

	public JSONObject uploadAttendance(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new IllegalArgumentException("File is empty");
			}

			// Read the content of the MultipartFile as a JSON string
			String jsonText = new String(file.getBytes());

			// Parse the JSON string to a JSONObject
			JSONObject jsonObject = new JSONObject(jsonText);
			examService.updateAttendance(jsonObject);

			return jsonObject;
		} catch (IOException e) {
			throw new IllegalArgumentException("Error reading file");
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid JSON input");
		}
	}

}
