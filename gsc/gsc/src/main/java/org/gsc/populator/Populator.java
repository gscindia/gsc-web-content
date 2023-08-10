package org.gsc.populator;

import java.util.List;

public interface Populator<SOURCE, TARGET> {
	void populate(SOURCE source, TARGET target);
	void populateAll(List<SOURCE> source, List<TARGET> target);
}
