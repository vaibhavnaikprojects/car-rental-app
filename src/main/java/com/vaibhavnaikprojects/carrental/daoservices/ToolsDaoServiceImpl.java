package com.vaibhavnaikprojects.carrental.daoservices;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.queries.CarQueries;
import com.vaibhavnaikprojects.carrental.queries.CustomerQueries;
import com.vaibhavnaikprojects.carrental.queries.OwnerQueries;

@Repository
public class ToolsDaoServiceImpl extends JdbcDaoSupport{
	@SuppressWarnings("unchecked")
	public void insertRecords(Map<String, Object> excelSheetObj) {
		deleteRecords();
		final List<Customer> customers=(List<Customer>)excelSheetObj.get("customers");
		getJdbcTemplate().batchUpdate(CustomerQueries.INSERT_CUSTOMER, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return customers.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Customer customer = customers.get(i);
				ps.setString(1, customer.getName());
				ps.setString(2, customer.getCustomerType());
				ps.setString(3, customer.getPhone());
			}
		});
		final List<Owner> owners=(List<Owner>) excelSheetObj.get("owners");
		getJdbcTemplate().batchUpdate(OwnerQueries.INSERT_OWNER, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return owners.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Owner owner = owners.get(i);
				ps.setString(1,owner.getOwnerType() );
				ps.setString(2,owner.getName());
				ps.setString(3,owner.getAddress());	
			}
		});
		final List<Car> cars=(List<Car>) excelSheetObj.get("cars");
		getJdbcTemplate().batchUpdate(CarQueries.INSERT_CAR, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return cars.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Car car = cars.get(i);
				ps.setString(1,car.getModel());
				ps.setInt(2,car.getYear());
				ps.setString(3,car.getVehicleNo());
				ps.setString(4,car.getCarType());
				ps.setDouble(5, car.getDailyRate());
				ps.setDouble(6, car.getWeeklyRate());
			}
		});
	}

	public void deleteRecords() {
		getJdbcTemplate().update(CustomerQueries.DELETE_CUSTOMERS);
		getJdbcTemplate().update(OwnerQueries.DELETE_OWNERS);
		getJdbcTemplate().update(CarQueries.DELETE_CARS);
		//TODO delete rental records
	}
}
