package com.vaibhavnaikprojects.carrental.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vaibhavnaikprojects.carrental.beans.CarType;

public class CarTypeMapper implements RowMapper<CarType>{

	@Override
	public CarType mapRow(ResultSet rs, int arg1) throws SQLException {
		return new CarType(rs.getInt("carTypeId"), rs.getString("carType"), rs.getDouble("dailyRate"), rs.getDouble("weeklyRate"));
	}

}
