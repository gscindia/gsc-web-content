package org.gsc.medha.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.FormADataTableDto;
import org.gsc.medha.dto.notification.TemplateMessage;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.facade.CandidateFacade;
import org.gsc.medha.page.form.CandidateForm;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.prop.Status;
import org.gsc.medha.repository.CandidateRepository;
import org.gsc.medha.service.CandidateService;
import org.gsc.medha.service.ExamService;
import org.gsc.populator.Populator;
import org.gsc.service.NotificationService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultCandidateFacade implements CandidateFacade {
	@Autowired
	CandidateRepository candidateRepository;

	@Resource(name = "candidatePopulator")
	Populator<Candidate, CandidateDto> candidatePopulator;

	@Resource(name = "admitCardPopulator")
	Populator<Candidate, CandidateDto> admitCardPopulator;

	@Resource(name = "candidateRevPopulator")
	Populator<CandidateForm, Candidate> candidateRevPopulator;

	@Resource(name = "filterPopulator")
	Populator<FilterForm, Candidate> filterPopulator;

	@Resource(name = "formADataTablePopulator")
	Populator<Candidate, String[]> formADataTablePopulator;

	@Autowired
	CandidateService candidateService;

	@Autowired
	ExamService examService;

	@Resource(name = "medhaRegistrationConfirmationWhatsAppMsgPopulator")
	Populator<Candidate, Map<Integer, TemplateMessage>> whatsappPopulator;

	@Autowired
	NotificationService notificationService;

	@Override
	public List<CandidateDto> getAll() {
		List<CandidateDto> list = new ArrayList<>();
		List<Candidate> candidate = new ArrayList<>();
		candidateRepository.findAll().forEach(c -> candidate.add(c));
		candidatePopulator.populateAll(candidate, list);
		return list;
	}

	@Override
	public FormADataTableDto getDataTable(FilterForm form) {
		List<String[]> dto = new ArrayList<>();
		Candidate filter = new Candidate();
		filterPopulator.populate(form, filter);
		if (filter.getSchool() != null) {
			formADataTablePopulator.populateAll(candidateService.getAllStudent(filter.getSchool(), Status.ACTIVE.name()), dto);
		} else {
			formADataTablePopulator.populateAll(candidateService.getAllStudent(), dto);
		}
		FormADataTableDto result = new FormADataTableDto();
		result.setData(dto);
		return result;
	}

	@Override
	public CandidateDto getCandidate(int id) {
		CandidateDto dto = new CandidateDto();
		Candidate candidate = candidateService.getStudent(id);
		if (candidate != null) {
			candidatePopulator.populate(candidate, dto);
		}
		return dto;
	}

	@Override
	public CandidateDto getAdmitCard(int id) {
		CandidateDto dto = new CandidateDto();
		Candidate candidate = candidateService.getStudent(id);
		if (candidate != null) {
			admitCardPopulator.populate(candidate, dto);
		}
		return dto;
	}

	@Override
	public CandidateDto editCandidate(CandidateForm form) {
		CandidateDto dto = new CandidateDto();
		Candidate entity = candidateRepository.findById(form.getId()).get();
		
		if (entity.getExam().getStatus().equalsIgnoreCase(Status.ACTIVE.name())
				|| entity.getExam().getStatus().equalsIgnoreCase(Status.POST.name())) {
			candidateRevPopulator.populate(form, entity);
			candidateRepository.save(entity);
			candidatePopulator.populate(entity, dto);
			dto.setEditStatus("Done");
		}else {
			dto.setEditStatus("Failed");
		}

		
		return dto;
	}

	@Override
	public void removeCandidate(int id) {
		Candidate entity = candidateRepository.findById(id).get();
		entity.setStatus("DELETED");
		candidateRepository.save(entity);
	}

	@Override
	public List<Map<Integer, TemplateMessage>> getPendingRegistrationNotification(Exam exam) {
		List<Candidate> pending = candidateService.getPendingNotifications(exam);
		List<Map<Integer, TemplateMessage>> notifications = new ArrayList<Map<Integer, TemplateMessage>>();
		whatsappPopulator.populateAll(pending, notifications);
		return notifications;
	}

	@Override
	public void updateRegistrationNotificationStatus(List<Map<Integer, JSONObject>> source) {
		List<Candidate> listOfUpdate = new ArrayList<Candidate>();
		source.forEach(map -> {
			map.keySet().forEach(key -> {
				if (map.get(key).has("messages")) {
					Candidate candidate = candidateRepository.findById(key).get();
					candidate.setNotification("SENT");
					listOfUpdate.add(candidate);
				}
			});
		});
		candidateRepository.saveAll(listOfUpdate);
	}
}
