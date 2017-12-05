package com.vaibhavnaikprojects.carrental.daoservices;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.vaibhavnaikprojects.carrental.beans.Rental;
import com.vaibhavnaikprojects.carrental.mappers.RentalMapper;
import com.vaibhavnaikprojects.carrental.queries.RentalQueries;

@Repository
public class ReportDaoServiceImpl extends JdbcDaoSupport{

	public List<Rental> ownerCarReport(int ownerId, int carId) {
		return getJdbcTemplate().query(RentalQueries.OWNER_CAR_REPORT,new Object[] {ownerId,carId},new RentalMapper());
	}
	public List<Rental> carTypeReport(int carTypeId) {
		return getJdbcTemplate().query(RentalQueries.CAR_TYPE_REPORT,new Object[] {carTypeId},new RentalMapper());
	}

	public List<Rental> ownerReport(int ownerId) {
		return getJdbcTemplate().query(RentalQueries.OWNER_REPORT,new Object[] {ownerId},new RentalMapper());
	}

}
