package org.gsc.medha.web.page.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/medhasandhan")
public class MedhaPageController {
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
		return "/medha/dashboard";
	}

	@GetMapping("/exam")
	public String showExamPage(Model model) throws JsonProcessingException {
		model.addAttribute("venues", venueFacade.getAllVenue());
		model.addAttribute("schools", schoolFacade.getAllSchool());
		model.addAttribute("autocompleteData", venueFacade.getAutoComplete());
		model.addAttribute("examList", examFacade.getAllExam());
		return "/medha/exam";
	}

	@GetMapping("/candidate")
	public String showStudentPage(Model model) {
		ExamDto dto = examFacade.getActiveExam();
		if (dto != null) {
			model.addAttribute("examName", dto.getName());
		}
		model.addAttribute("schools", schoolFacade.getAllSchool().stream()
				.filter(s -> s.getStatus().equalsIgnoreCase("active")).collect(Collectors.toList()));
		return "/medha/student";
	}

	@GetMapping("/school")
	public String testPage(Model model) {
		model.addAttribute("schoolList", schoolFacade.getAllSchool());
		model.addAttribute("venues", venueFacade.getAllActiveVenue());
		return "/medha/school";
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

		return "/medha/previews/formAPart" + part;
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

		return "/medha/previews/formB";
	}

	@GetMapping("/admit-cards/{classId}/{examId}")
	public String getAdmitCard(Model model, @PathVariable int classId, @PathVariable int examId,
			@RequestParam(defaultValue = "1") int page) {
		FilterForm form = new FilterForm();
		form.setCls(classId);
		form.setExam(examId);
		List<CandidateDto> candidateList = examFacade.getAdmitCards(form);
		model.addAttribute("candidate", candidateList);

		return "/medha/previews/admitCards";
	}

	@GetMapping("/admit-card/{code}")
	public String getAdmitCard(Model model, @PathVariable int code) {
		List<CandidateDto> list = new ArrayList<CandidateDto>();
		list.add(candidateFacade.getAdmitCard(code));
		model.addAttribute("candidate", list);
		return "/medha/previews/admitCards";

	}
	
	@GetMapping("/school-admit-cards/{schoolId}/{examId}")
	public String getAdmitCardsForSchool(Model model, @PathVariable int schoolId, @PathVariable int examId,
			@RequestParam(defaultValue = "1") int page) {
		FilterForm form = new FilterForm();
		form.setSchool(schoolId);
		form.setExam(examId);
		List<CandidateDto> candidateList = schoolFacade.getAdmitCards(form);
		model.addAttribute("candidate", candidateList);

		return "/medha/previews/admitCards";
	}

	@GetMapping("/analytics")
	public String showAnalytics(Model model) {
		model.addAttribute("examList", examFacade.getAllExam());
		return "/medha/analytics";
	}
}
