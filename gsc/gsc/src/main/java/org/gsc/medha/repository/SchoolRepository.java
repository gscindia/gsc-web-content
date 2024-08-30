package org.gsc.medha.repository;

import java.util.List;

import org.gsc.medha.data.SchoolLeaderBoard;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.entity.School;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Integer> {
	@Query("SELECT s FROM School s WHERE s.name=?1 ")
	public List<Object> findBySchoolName(String name);

	@Query("Select c from Candidate c where c.school=?1 and c.exam=?2 and c.status='ACTIVE' order by c.section, c.roll")
	public List<Candidate> filterFormA(School school, Exam exam);

	List<School> findAll(Sort sort);

	@Query("Select new org.gsc.medha.data.SchoolLeaderBoard(s.name,count(code)) FROM Candidate c join School s on c.school=s.id where c.status='ACTIVE' and c.exam.id=?1 group by c.school order by count(code) desc")
	List<SchoolLeaderBoard> getSchoolLeaderboardByYear(int examId, Pageable size);

	@Query("Select new org.gsc.medha.data.SchoolLeaderBoard(s.name,count(code)) FROM Candidate c join School s on c.school=s.id where c.status='ACTIVE' group by c.school order by count(code) desc")
	List<SchoolLeaderBoard> getSchoolLeaderboard(Pageable size);
}
