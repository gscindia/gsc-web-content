package org.gsc.medha.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.gsc.medha.entity.School;
import org.gsc.medha.entity.Venue;
import org.springframework.jdbc.core.RowMapper;

public class SchoolRowmapper implements RowMapper<School> {

	@Override
	public School mapRow(ResultSet rs, int rowNum) throws SQLException {
		School school = new School();
		Venue venue = new Venue();
		school.setId(rs.getInt("scid"));
		school.setName(rs.getString("sname"));
		school.setAddress(rs.getString("sadd"));
		school.setDistrict(rs.getString("dist"));
		school.setState(rs.getString("state"));
		school.setPincode(rs.getString("pincode"));
		school.setContactno(rs.getString("contact"));
		school.setPoc(rs.getString("poc"));
		school.setPicture(rs.getString("pic"));
		school.setStatus(rs.getString("sstatus"));
				
		venue.setId(rs.getInt("id"));
		venue.setName(rs.getString("vname"));
		venue.setStatus(rs.getString("vstatus"));
		
		school.setVenue(venue);
		return school;
	}

}
