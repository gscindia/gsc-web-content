package org.gsc.medha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "cad2examrel")
@Entity
public class CandidateExamRel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@ManyToOne
	@JoinColumn(name = "source", insertable = false, updatable = false)
	Candidate source;

	@ManyToOne
	@JoinColumn(name = "target", insertable = false, updatable = false)
	Exam target;

	int roll;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the source
	 */
	public Candidate getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(Candidate source) {
		this.source = source;
	}

	/**
	 * @return the target
	 */
	public Exam getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Exam target) {
		this.target = target;
	}

	/**
	 * @return the roll
	 */
	public int getRoll() {
		return roll;
	}

	/**
	 * @param roll the roll to set
	 */
	public void setRoll(int roll) {
		this.roll = roll;
	}

}
