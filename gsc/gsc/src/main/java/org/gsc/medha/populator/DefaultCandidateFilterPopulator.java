package org.gsc.medha.populator;

import java.util.List;

import org.gsc.medha.entity.Candidate;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.service.ExamService;
import org.gsc.medha.service.SchoolService;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("filterPopulator")
public class DefaultCandidateFilterPopulator implements Populator<FilterForm, Candidate> {

	@Autowired
	SchoolService schoolService;
	@Autowired
	ExamService examService;

	@Override
	public void populate(FilterForm source, Candidate target) {

		target.setRoll(source.getRoll());
		target.setSection(source.getCls());
		target.setSchool(schoolService.getSchoolById(source.getSchool()));
		target.setExam(examService.getExamById(source.getExam()));

	}

	@Override
	public void populateAll(List<FilterForm> source, List<Candidate> target) {
		// TODO Auto-generated method stub

	}

}
