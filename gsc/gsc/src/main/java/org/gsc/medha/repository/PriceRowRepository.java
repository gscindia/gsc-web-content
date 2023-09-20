package org.gsc.medha.repository;

import java.util.List;
import java.util.Set;

import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.PriceRow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PriceRowRepository extends CrudRepository<PriceRow, Integer> {
	@Query("Select pr from PriceRow pr where pr.exam in ?1")
	List<PriceRow> getPriceRows(Set<Exam> exam);

}
