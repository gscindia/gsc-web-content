package org.gsc.medha.populator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.School;
import org.gsc.medha.page.form.CandidateForm;
import org.gsc.medha.prop.Status;
import org.gsc.medha.service.ExamService;
import org.gsc.medha.service.SchoolService;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("candidateRevPopulator")
public class DefaultCandRevPopulator implements Populator<CandidateForm, Candidate> {

	@Autowired
	SchoolService schoolService;

	@Autowired
	ExamService examService;

	@Override
	public void populate(CandidateForm source, Candidate target) {
		if (source.getAction() != null && source.getAction().equalsIgnoreCase("edit")) {
			target.setName(source.getName());
			target.setGender(source.getGender());
			School school = schoolService.getSchoolById(Integer.parseInt(source.getSchool()));
			target.setSchool(school);
			if (StringUtils.isNotEmpty(source.getMobile()) && source.getMobile().length() == 10) {
				target.setContact(source.getMobile());
			}
		} else {
			target.setName(source.getName());
			target.setSection(Integer.parseInt(source.getCls()));
			target.setStatus(Status.ACTIVE.toString());
			School school = schoolService.getSchoolById(Integer.parseInt(source.getSchool()));
			target.setSchool(school);
			target.setExam(examService.getActiveExam());
			target.setGender(source.getGender());
			target.setNotification("NOT_SENT");
			if (StringUtils.isNotEmpty(source.getMobile()) && source.getMobile().length() == 10) {
				target.setContact(source.getMobile());
			}
		}
	}

	@Override
	public void populateAll(List<CandidateForm> source, List<Candidate> target) {
		// TODO Auto-generated method stub

	}

}
