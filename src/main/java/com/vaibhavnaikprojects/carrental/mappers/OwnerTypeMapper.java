package com.vaibhavnaikprojects.carrental.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vaibhavnaikprojects.carrental.beans.OwnerType;

public class OwnerTypeMapper implements RowMapper<OwnerType>{

	@Override
	public OwnerType mapRow(ResultSet rs, int arg1) throws SQLException {
		return new OwnerType(rs.getInt("ownerTypeId"),rs.getString("ownerType"));
	}

}
