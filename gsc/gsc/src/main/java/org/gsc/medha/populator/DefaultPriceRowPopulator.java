package org.gsc.medha.populator;

import java.util.List;

import org.gsc.medha.dto.PricerowDto;
import org.gsc.medha.entity.Pricerow;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("basicPriceRowPopulator")
public class DefaultPriceRowPopulator implements Populator<Pricerow, PricerowDto> {

	@Override
	public void populate(Pricerow source, PricerowDto target) {
		target.setId(source.getId());
		target.setName(source.getName());
		target.setSegment(source.getSegment());
		target.setMrp(source.getMrp());
	}

	@Override
	public void populateAll(List<Pricerow> source, List<PricerowDto> target) {
		source.forEach(s -> {
			PricerowDto pr = new PricerowDto();
			this.populate(s, pr);
			target.add(pr);
		});

	}

}
