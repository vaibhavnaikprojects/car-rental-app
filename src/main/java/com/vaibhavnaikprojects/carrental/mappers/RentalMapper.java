package com.vaibhavnaikprojects.carrental.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.beans.Rental;
public class RentalMapper implements RowMapper<Rental>{
	@Override
	public Rental mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Rental(rs.getInt("rentalId"),rs.getString("rentalType"), null,new Car(rs.getInt("vehicleId"),rs.getString("model"),rs.getInt("year"),rs.getString("vehicleNo")),new Owner(rs.getInt("ownerId"),rs.getString("name")), rs.getInt("noOfRentalType"),
				rs.getString("startDate"), rs.getString("endDate"), rs.getDouble("amountDue"));
	}
}
