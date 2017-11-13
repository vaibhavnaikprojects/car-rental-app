package com.vaibhavnaikprojects.carrental.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vaibhavnaikprojects.carrental.beans.Owner;

public class OwnerMapper implements RowMapper<Owner>{
	@Override
	public Owner mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Owner(rs.getInt("ownerId"), rs.getString("ownerType"),rs.getString("name"), rs.getString("address"),rs.getString("status"),rs.getString("leavingDate"),rs.getString("joiningDate"));
	}
}
