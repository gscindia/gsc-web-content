package org.gsc.medha.api.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.dto.FormADataTableDto;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.facade.ExamFacade;
import org.gsc.medha.page.form.ExamForm;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.service.ExamService;
import org.json.JSONObject;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	@Resource(name = "marksPreviewDataTablePopulator")
	Populator<Candidate, String[]> marksPreviewTableDataPopulator;

	@ResponseBody
	@GetMapping
	public List<ExamDto> getExams() {
		return examFacade.getAllExam();
	}

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

	@PostMapping("/upload-file")
	public String uploadMarks(@RequestParam("file") MultipartFile file, HttpSession session) throws Exception {
		String status = "Failed";
		FormADataTableDto dto = new FormADataTableDto();
		try {
			if (file.isEmpty()) {
				throw new IllegalArgumentException("File is empty");
			}
			List<Candidate> candidate = examFacade.readMarksFromFile(file.getInputStream());
			List<String[]> preview = new ArrayList<String[]>();
			marksPreviewTableDataPopulator.populateAll(candidate, preview);
			dto.setData(preview);
			session.setAttribute("previewData", dto);
			session.setAttribute("candidateList", candidate);
			status = "Uploaded";
		} catch (IOException e) {
			throw new IllegalArgumentException("Error reading file");
		} catch (Exception e) {
			throw new Exception("Error Processing Data");

		}
		return status;
	}

	@PostMapping("/preview-marks")
	public FormADataTableDto showMarksTablePreview(HttpSession session) {
		return (FormADataTableDto) session.getAttribute("previewData");

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/save-marks")
	@ResponseBody
	public Map<Integer, Integer> saveMarksheet(HttpSession session) {
		List<Candidate> attribute = (List<Candidate>) session.getAttribute("candidateList");
		Map<Integer, Integer> saveMarksheet = examFacade.saveMarksheet(attribute);
		session.removeAttribute("candidateList");
		return saveMarksheet;
	}
}
