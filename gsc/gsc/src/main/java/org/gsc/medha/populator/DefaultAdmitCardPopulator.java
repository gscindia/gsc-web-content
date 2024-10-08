package org.gsc.medha.populator;

import java.util.List;

import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.entity.Candidate;
import org.gsc.populator.Populator;
import org.gsc.utility.GscSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("admitCardPopulator")
public class DefaultAdmitCardPopulator extends DefaultCandidatePopulator implements Populator<Candidate, CandidateDto> {
	@Autowired
	GscSecurity gscSecurity;
	@Override
	public void populate(Candidate source, CandidateDto target) {
		super.populate(source, target);
		target.setSchedule(source.getSection() <= 4 ? "11 AM" : "2 PM");
		try {
			target.setMaskedRollid(gscSecurity.encrypt(String.valueOf(source.getId())));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
