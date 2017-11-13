package com.vaibhavnaikprojects.carrental.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.vaibhavnaikprojects.carrental.beans.Rental;
public class RentalMapper implements RowMapper<Rental>{
	@Override
	public Rental mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Rental();
	}
}
