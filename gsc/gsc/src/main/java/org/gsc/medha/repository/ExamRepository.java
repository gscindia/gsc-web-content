package org.gsc.medha.repository;

import java.util.List;

import org.gsc.medha.data.ExamRevenueData;
import org.gsc.medha.data.ExamShiftAnalysisData;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Integer> {
       final String REVENUE_QUERY = "SELECT  " +
           "new org.gsc.medha.data.ExamRevenueData(e.id, c.section, " +
           "CASE WHEN c.section <= 4 THEN " +
           "(COUNT(c.id) * (SELECT pr.margin FROM Pricerow pr JOIN pr.exam pe WHERE pe.id = e.id AND pr.segment = 'first_half')) " +
           "ELSE " +
           "(COUNT(c.id) * (SELECT pr.margin FROM Pricerow pr JOIN pr.exam pe WHERE pe.id = e.id AND pr.segment = 'second_half')) " +
           "END) " +
           "FROM Candidate c " +
           "JOIN c.exam e " +
           "WHERE c.status = 'ACTIVE' " +
           "GROUP BY e.id, e.name, c.section " +
           "ORDER BY e.id, c.section";
	@Query("Select e from Exam e where e.status='ACTIVE'")
	public Exam getActiveExam();
	@Query("Select e from Exam e where e.status='POST'")
	public Exam getPostExam();
	@Query("Select c from Candidate c where c.exam=?1 and c.section=?2 and c.status='ACTIVE' order by c.roll")
	public List<Candidate> filterFormB( Exam exam, int class_);
	@Query(REVENUE_QUERY)
       List<ExamRevenueData> getExamRevenueTrend();
    @Query("SELECT new org.gsc.medha.data.ExamShiftAnalysisData(e.name , SUM(CASE WHEN c.section BETWEEN 2 AND 4 THEN 1 ELSE 0 END), "+
	        "SUM(CASE WHEN c.section BETWEEN 5 AND 10 THEN 1 ELSE 0 END)) "+
            "from Candidate c join Exam e on c.exam=e.id where c.status='ACTIVE' group by exam")
            List<ExamShiftAnalysisData> historicalShiftAnalysis();
	
}
