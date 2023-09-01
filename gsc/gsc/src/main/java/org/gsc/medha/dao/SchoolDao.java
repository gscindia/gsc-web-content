package org.gsc.medha.dao;

import java.util.List;

import org.gsc.medha.entity.School;

public interface SchoolDao{
	List<School> findAll();
}
