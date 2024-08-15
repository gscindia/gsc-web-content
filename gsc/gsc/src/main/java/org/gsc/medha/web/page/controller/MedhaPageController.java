package org.gsc.medha.web.page.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpSession;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.dto.FormAPageableDto;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.facade.CandidateFacade;
import org.gsc.medha.facade.ExamFacade;
import org.gsc.medha.facade.SchoolFacade;
import org.gsc.medha.facade.VenueFacade;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.annotation.Resource;

@Controller
@RequestMapping("/medhasandhan")
public class MedhaPageController {
	private static final String BASE_PATH = "medha";
	@Autowired
	SchoolFacade schoolFacade;
	@Autowired
	VenueFacade venueFacade;
	@Autowired
	ExamFacade examFacade;
	@Autowired
	CandidateFacade candidateFacade;
	@Resource(name = "admitCardPopulator")
	Populator<Candidate, CandidateDto> populator;

	@GetMapping
	public String showDashborad() {
		return BASE_PATH + "/dashboard";
	}

	@GetMapping("/exam")
	public String showExamPage(Model model) throws JsonProcessingException {
		model.addAttribute("venues", venueFacade.getAllVenue());
		model.addAttribute("schools", schoolFacade.getAllSchool());
		model.addAttribute("autocompleteData", venueFacade.getAutoComplete());
		model.addAttribute("examList", examFacade.getAllExam());
		return BASE_PATH + "/exam";
	}

	@GetMapping("/candidate")
	public String showStudentPage(Model model) {
		ExamDto dto = examFacade.getActiveExam();
		if (dto != null) {
			model.addAttribute("examName", dto.getName());
		}
		model.addAttribute("schools", schoolFacade.getAllSchool().stream()
				.filter(s -> s.getStatus().equalsIgnoreCase("active")).collect(Collectors.toList()));
		return BASE_PATH + "/student";
	}

	@GetMapping("/school")
	public String testPage(Model model) {
		model.addAttribute("schoolList", schoolFacade.getAllSchool());
		model.addAttribute("venues", venueFacade.getAllActiveVenue());
		return BASE_PATH + "/school";
	}

	@GetMapping("/forma/{part}/{schoolId}/{examId}")
	public String showFormA(Model model, @PathVariable int schoolId, @PathVariable int examId, @PathVariable int part,
			@RequestParam(defaultValue = "10") int page) {

		FilterForm form = new FilterForm();
		form.setSchool(schoolId);
		form.setExam(examId);
		List<CandidateDto> candidateList = schoolFacade.filteFormA(form);
		FormAPageableDto pageData = schoolFacade.pageableForm(candidateList, page);
		model.addAttribute("candidate", candidateList);
		model.addAttribute("pagedata", pageData);

		return BASE_PATH + "/previews/formAPart" + part;
	}

	@GetMapping("/formb/{classId}/{examId}")
	public String showFormB(Model model, @PathVariable int classId, @PathVariable int examId,
			@RequestParam(defaultValue = "10") int page) {

		FilterForm form = new FilterForm();
		form.setCls(classId);
		form.setExam(examId);
		List<CandidateDto> candidateList = examFacade.filterFormB(form);
		FormAPageableDto pageData = schoolFacade.pageableForm(candidateList, page);
		model.addAttribute("candidate", candidateList);
		model.addAttribute("pagedata", pageData);

		return BASE_PATH + "/previews/formB";
	}

	@GetMapping("/admit-cards/{classId}/{examId}")
	public String getAdmitCard(Model model, @PathVariable int classId, @PathVariable int examId,
			@RequestParam(defaultValue = "1") int page) {
		FilterForm form = new FilterForm();
		form.setCls(classId);
		form.setExam(examId);
		List<CandidateDto> candidateList = examFacade.getAdmitCards(form);
		model.addAttribute("candidate", candidateList);

		return BASE_PATH + "/previews/admitCards";
	}

	@GetMapping("/admit-card/{code}")
	public String getAdmitCard(Model model, @PathVariable int code) {
		List<CandidateDto> list = new ArrayList<CandidateDto>();
		list.add(candidateFacade.getAdmitCard(code));
		model.addAttribute("candidate", list);
		return BASE_PATH + "/previews/admitCards";

	}

	@GetMapping("/school-admit-cards/{schoolId}/{examId}")
	public String getAdmitCardsForSchool(Model model, @PathVariable int schoolId, @PathVariable int examId,
			@RequestParam(defaultValue = "1") int page) {
		FilterForm form = new FilterForm();
		form.setSchool(schoolId);
		form.setExam(examId);
		List<CandidateDto> candidateList = schoolFacade.getAdmitCards(form);
		model.addAttribute("candidate", candidateList);

		return BASE_PATH + "/previews/admitCards";
	}

	@GetMapping("/analytics")
	public String showAnalytics(Model model) {
		model.addAttribute("schools", schoolFacade.getAllSchool());
		model.addAttribute("examList", examFacade.getAllExam());
		return BASE_PATH + "/analytics";
	}

	@GetMapping("/upload-result")
	public String uploadMarks(Model model, HttpSession session) {
		session.removeAttribute("candidateList");
		model.addAttribute("candidates");
		model.addAttribute("schools", schoolFacade.getAllSchool());
		model.addAttribute("examList", examFacade.getAllExam());
		return BASE_PATH + "/uploadResult";
	}

	@GetMapping("/issue-mark-sheet")
	public String showMarksheets(Model model) {
		model.addAttribute("schools", schoolFacade.getAllSchool());
		model.addAttribute("examList", examFacade.getAllExam());
		return BASE_PATH + "/issueMarkSheet";
	}

	@GetMapping("/view-ms/{schoolId}/{examId}")
	public String printMarkSheet(Model model, @PathVariable int schoolId, @PathVariable int examId,
			@RequestParam(defaultValue = "1") int page) {
		FilterForm form = new FilterForm();
		form.setSchool(schoolId);
		form.setExam(examId);
		List<CandidateDto> marksList = schoolFacade.getMarks(form);
		model.addAttribute("candidate", marksList);
		return BASE_PATH + "/previews/markSheet";
	}

	@GetMapping("/pre-filled-template")
	public ResponseEntity<byte[]> downloadPrefilledTemplate(@RequestParam("schoolId") int schoolId,
			@RequestParam("examId") int examId) throws IOException {
		FilterForm form = new FilterForm();
		form.setSchool(schoolId);
		form.setExam(examId);
		ByteArrayOutputStream outputStream = examFacade.preFillData(form);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "Prefilled-" + System.currentTimeMillis() + ".xlsx");

		// Convert byte array to ResponseEntity
		return ResponseEntity.ok()
				.headers(headers)
				.body(outputStream.toByteArray());
	}
}
