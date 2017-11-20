package com.vaibhavnaikprojects.carrental.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vaibhavnaikprojects.carrental.beans.CustomerType;

public class CustomerTypeMapper implements RowMapper<CustomerType>{

	@Override
	public CustomerType mapRow(ResultSet rs, int arg1) throws SQLException {
		return new CustomerType(rs.getInt("customerTypeId"), rs.getString("customerType"));
	}
}
