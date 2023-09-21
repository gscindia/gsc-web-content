package org.gsc.medha.populator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.dto.PricerowDto;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.Pricerow;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("examPopulator")
public class DefaultExamPopulator implements Populator<Exam, ExamDto> {
	@Resource(name = "basicPriceRowPopulator")
	Populator<Pricerow, PricerowDto> priceRowPopulator;

	@Override
	public void populate(Exam source, ExamDto target) {
		target.setName(source.getName());
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		String strDate = formatter.format(source.getDate());
		target.setDate(strDate);
		formatter = new SimpleDateFormat("yyyy");
		strDate = formatter.format(source.getDate());
		target.setFormattedName("Session-" + strDate);
		target.setId(source.getId());
		target.setStatus(source.getStatus());
		List<Pricerow> mainList = new ArrayList<Pricerow>();
		List<PricerowDto> priceDto = new ArrayList<PricerowDto>();
		mainList.addAll(source.getPriceRows());
		priceRowPopulator.populateAll(mainList, priceDto);
		target.setPricees(priceDto);
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
