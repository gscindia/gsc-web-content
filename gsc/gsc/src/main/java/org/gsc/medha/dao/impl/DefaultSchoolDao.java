package org.gsc.medha.dao.impl;

import java.util.List;

import org.gsc.medha.dao.SchoolDao;
import org.gsc.medha.entity.School;
import org.gsc.medha.rowmapper.SchoolRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class DefaultSchoolDao implements SchoolDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	final private String SELECT_ALL = "SELECT \r\n" + "sc.contactno contact,sc.id scid,\r\n" + "sc.name sname,\r\n"
			+ "sc.address sadd,\r\n" + "sc.district dist,\r\n" + "sc.state state,\r\n" + "sc.pincode pincode,\r\n"
			+ "sc.pocname poc,\r\n" + "sc.picturepath pic,\r\n" + "sc.status sstatus,\r\n" + "v.id id,\r\n"
			+ "v.name vname,\r\n" + "v.status vstatus\r\n" + "FROM \r\n" + "school sc inner join venue v \r\n"
			+ "on  sc.venue=v.venueid where sc.status='ACTIVE';";

	@Override
	public List<School> findAll() {
		String select = SELECT_ALL;
		List<School> schl = jdbcTemplate.query(select, new SchoolRowmapper());
		return schl;
	}


}
