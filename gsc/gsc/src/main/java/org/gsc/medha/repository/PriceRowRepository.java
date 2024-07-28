package org.gsc.medha.repository;

import java.util.List;
import java.util.Set;

import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.Pricerow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PriceRowRepository extends CrudRepository<Pricerow, Integer> {
	// @Query("Select pr from Pricerow pr where pr.exam in ?1")
	// List<Pricerow> getPriceRows(Set<Exam> exam);

}
