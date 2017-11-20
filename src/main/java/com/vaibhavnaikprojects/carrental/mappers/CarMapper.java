package com.vaibhavnaikprojects.carrental.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.CarType;
import com.vaibhavnaikprojects.carrental.beans.Owner;

public class CarMapper implements RowMapper<Car>{
	@Override
	public Car mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Car(rs.getInt("vehicleId"),rs.getString("model"),rs.getInt("year"),rs.getString("vehicleNo"),new CarType(rs.getInt("carTypeId"),rs.getString("carType"),rs.getDouble("dailyRate"),rs.getDouble("weeklyRate")),rs.getString("status"),rs.getString("joiningDate"),rs.getString("leavingDate"),new Owner(rs.getInt("ownerId"),rs.getString("ownerType"),rs.getString("name"),rs.getString("address")));
	}
}
