package org.gsc.medha.populator;

import java.util.List;


import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.service.ExamService;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component("markSheetPopulator")
public class DefaultMarkSheetPopulator extends DefaultCandidatePopulator {
	@Resource
	ExamService examService;

	@Override
	public void populate(Candidate source, CandidateDto target) {
		if (source.getMarks() != null) {
			super.populate(source, target);
			target.setMarks(source.getMarks().toString());
			target.setGrade(examService.resolveGrade(source.getMarks()));
		}

	}

	@Override
	public void populateAll(List<Candidate> source, List<CandidateDto> target) {
		source.forEach(t -> {
			if (t.getMarks() != null) {
				CandidateDto dto = new CandidateDto();
				this.populate(t, dto);
				target.add(dto);
			}
		});

	}

}
