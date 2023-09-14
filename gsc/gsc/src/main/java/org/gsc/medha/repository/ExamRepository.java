package org.gsc.medha.repository;

import java.util.List;

import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Integer> {

	@Query("Select e from Exam e where e.status='ACTIVE'")
	public Exam getActiveExam();
	@Query("Select e from Exam e where e.status='POST'")
	public Exam getPostExam();
	@Query("Select c from Candidate c where c.exam=?1 and c.section=?2 and c.status='ACTIVE' order by c.roll")
	public List<Candidate> filterFormB( Exam exam, int class_);
	
}
