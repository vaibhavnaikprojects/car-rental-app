package com.vaibhavnaikprojects.carrental.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vaibhavnaikprojects.carrental.beans.Customer;

public class CustomerMapper implements RowMapper<Customer>{
	@Override
	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("customerType"),rs.getString("phone"),rs.getString("status"),rs.getString("joiningDate"),rs.getString("leavingDate"));
	}
}
