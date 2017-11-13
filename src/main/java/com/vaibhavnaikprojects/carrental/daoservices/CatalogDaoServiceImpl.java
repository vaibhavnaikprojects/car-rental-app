package com.vaibhavnaikprojects.carrental.daoservices;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.mappers.CarMapper;
import com.vaibhavnaikprojects.carrental.mappers.CustomerMapper;
import com.vaibhavnaikprojects.carrental.mappers.OwnerMapper;
import com.vaibhavnaikprojects.carrental.queries.CarQueries;
import com.vaibhavnaikprojects.carrental.queries.CustomerQueries;
import com.vaibhavnaikprojects.carrental.queries.OwnerQueries;

@Repository
public class CatalogDaoServiceImpl extends JdbcDaoSupport{

	public void updateCustomer(Customer customer) {
		getJdbcTemplate().update(CustomerQueries.UPDATE_CUSTOMER,new Object[] {customer.getPhone(),customer.getId()});
	}
	public void insertCustomer(Customer customer) {
		getJdbcTemplate().update(CustomerQueries.INSERT_CUSTOMER,new Object[] {customer.getName(),customer.getCustomerType(),customer.getPhone()});
	}
	public void deleteCustomer(int custId) {
		getJdbcTemplate().update(CustomerQueries.INACTIVATE_CUSTOMER,new Object[] {custId});
	}
	public void updateOwner(Owner owner) {
		getJdbcTemplate().update(OwnerQueries.UPDATE_OWNER,new Object[] {owner.getAddress(),owner.getOwnerId()});	
	}
	public void insertOwner(Owner owner) {
		getJdbcTemplate().update(CustomerQueries.INSERT_CUSTOMER,new Object[] {owner.getOwnerType(),owner.getName(),owner.getAddress()});
		
	}
	public void deleteOwner(int ownerId) {
		getJdbcTemplate().update(OwnerQueries.INACTIVATE_OWNER,new Object[] {ownerId});
	}
	public void updateCar(Car car) {
		getJdbcTemplate().update(CarQueries.UPDATE_CAR,new Object[] {car.getDailyRate(),car.getWeeklyRate(),car.getVehicleId()});
	}
	public void updatePriceByType(double dailyRate,double weeklyRate,String type) {
		getJdbcTemplate().update(CarQueries.UPDATE_PRICES_BY_TYPE,new Object[] {dailyRate,weeklyRate,type});
	}
	public void insertCar(Car car) {
		getJdbcTemplate().update(CarQueries.INSERT_CAR,new Object[]{car.getModel(),car.getYear(),car.getVehicleNo(),car.getCarType(),car.getDailyRate(),car.getWeeklyRate()});
	}
	public void deleteCar(int carId) {
		getJdbcTemplate().update(CarQueries.INACTIVATE_CAR,new Object[]{carId});
		
	}
	public List<Car> getCars() {
		return getJdbcTemplate().query(CarQueries.GET_CARS, new CarMapper());
	}
	public List<Car> getCarsByAvailablity(String filter) {
		return getJdbcTemplate().query(CarQueries.GET_CARS_BY_AVAILABLITY,new Object[] {filter},new CarMapper());
	}
	public List<Customer> getCustomers() {
		return getJdbcTemplate().query(CustomerQueries.GET_CUSTOMERS,new CustomerMapper());
	}
	public List<Owner> getOwners() {
		return getJdbcTemplate().query(OwnerQueries.GET_OWNERS,new OwnerMapper());
	}
	public List<Customer> getCustomersByAvailablity(String filter) {
		return getJdbcTemplate().query(CustomerQueries.GET_CUSTOMERS_BY_AVAILABLITY,new Object[] {filter},new CustomerMapper());
	}

}
