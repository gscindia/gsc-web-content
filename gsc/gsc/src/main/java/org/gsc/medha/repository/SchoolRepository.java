package org.gsc.medha.repository;

import java.util.List;

import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Integer> {
	@Query("SELECT s FROM School s WHERE s.name=?1 ")
	public List<Object> findBySchoolName(String name);

	@Query("Select c from Candidate c where c.school=?1 and c.exam=?2 and c.status='ACTIVE' order by c.roll")
	public List<Candidate> filterFormA(School school, Exam exam);

}
