package org.gsc.medha.populator;

import java.util.List;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.dto.SchoolDto;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.School;
import org.gsc.populator.Populator;
import org.gsc.utility.GscUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("candidatePopulator")
public class DefaultCandidatePopulator implements Populator<Candidate, CandidateDto> {

	@Autowired
	Populator<Exam, ExamDto> exampoPopulator;
	@Autowired
	Populator<School, SchoolDto> schoolPopulator;
	@Override
	public void populate(Candidate source, CandidateDto target) {
		target.setName(source.getName());
		ExamDto examDto = new ExamDto();
		exampoPopulator.populate(source.getExam(), examDto);
		target.setExam(examDto);
		target.setDob(source.getDob());
		target.setGender(source.getGender());
		SchoolDto schoolDto = new SchoolDto();
		schoolPopulator.populate(source.getSchool(),schoolDto);
		target.setSchool(schoolDto);
		target.setRoll(String.valueOf(source.getRoll()));
		target.setCls(String.valueOf(GscUtils.integerToRoman(source.getSection())));
		target.setRollId(String.valueOf(source.getId()));
		target.setStatus(source.getStatus());
		target.setContact(source.getContact());
		
	}

	@Override
	public void populateAll(List<Candidate> source, List<CandidateDto> target) {
		source.forEach(t -> {
			CandidateDto dto = new CandidateDto();
			this.populate(t, dto);
			target.add(dto);
		});
	}

	
}
