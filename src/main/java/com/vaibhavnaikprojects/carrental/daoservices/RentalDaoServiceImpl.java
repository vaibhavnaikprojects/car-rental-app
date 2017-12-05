package com.vaibhavnaikprojects.carrental.daoservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.vaibhavnaikprojects.carrental.beans.Rental;
import com.vaibhavnaikprojects.carrental.queries.RentalQueries;

@Repository
public class RentalDaoServiceImpl extends NamedParameterJdbcDaoSupport{
	public void addRental(Rental rental) {
		int rentalTypeId=1;
		if(rental.getRentalType().equalsIgnoreCase("Daily"))
			rentalTypeId=1;
		else
			rentalTypeId=2;
		Map<String, String> map=new HashMap<String, String>();
		map.put("noOfRentalType", rental.getNoOfRentalType()+"");
		map.put("rentalTypeId", rentalTypeId+"");
		map.put("vehicleId", rental.getCar().getVehicleId()+"");
		map.put("ownerId", rental.getOwner().getOwnerId()+"");
		map.put("customerId", rental.getCustomer().getId()+"");
		map.put("startDate", rental.getStartDate());
		map.put("endDate", rental.getReturnDate());
		map.put("amountDue", rental.getAmountDue()+"");
		getNamedParameterJdbcTemplate().update(RentalQueries.INSERT_RENTAL,map);
	}
}
