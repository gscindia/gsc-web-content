package org.gsc.medha.populator;

import java.text.SimpleDateFormat;
import java.util.List;

import org.gsc.api.dto.ExamDto;
import org.gsc.medha.entity.Exam;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("examPopulator")
public class DefaultExamPopulator implements Populator<Exam, ExamDto> {

	@Override
	public void populate(Exam source, ExamDto target) {
		target.setName(source.getName());
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
	    String strDate= formatter.format(source.getDate());
		target.setDate(strDate);
		target.setId(source.getId());
		target.setStatus(source.getStatus());
		

	}

	@Override
	public void populateAll(List<Exam> source, List<ExamDto> target) {
		for (Exam s : source) {
			ExamDto exam = new ExamDto();
			this.populate(s, exam);
			target.add(exam);
		}

	}

}