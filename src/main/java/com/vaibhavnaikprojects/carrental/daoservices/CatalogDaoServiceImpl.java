package com.vaibhavnaikprojects.carrental.daoservices;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.CarType;
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.CustomerType;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.beans.OwnerType;
import com.vaibhavnaikprojects.carrental.beans.Rental;
import com.vaibhavnaikprojects.carrental.mappers.CarMapper;
import com.vaibhavnaikprojects.carrental.mappers.CarTypeMapper;
import com.vaibhavnaikprojects.carrental.mappers.CustomerMapper;
import com.vaibhavnaikprojects.carrental.mappers.CustomerTypeMapper;
import com.vaibhavnaikprojects.carrental.mappers.OwnerMapper;
import com.vaibhavnaikprojects.carrental.mappers.OwnerTypeMapper;
import com.vaibhavnaikprojects.carrental.mappers.RentalMapper;
import com.vaibhavnaikprojects.carrental.queries.CarQueries;
import com.vaibhavnaikprojects.carrental.queries.CustomerQueries;
import com.vaibhavnaikprojects.carrental.queries.OwnerQueries;
import com.vaibhavnaikprojects.carrental.queries.RentalQueries;

@Repository
public class CatalogDaoServiceImpl extends JdbcDaoSupport{

	public void insertCustomer(Customer customer) {
		getJdbcTemplate().update(CustomerQueries.INSERT_CUSTOMER,new Object[] {customer.getName(),Integer.parseInt(customer.getCustomerType()),customer.getPhone()});
	}
	public void deleteCustomer(int custId) {
		getJdbcTemplate().update(CustomerQueries.INACTIVATE_CUSTOMER,new Object[] {custId});
	}
	public void insertOwner(Owner owner) {
		getJdbcTemplate().update(OwnerQueries.INSERT_OWNER,new Object[] {Integer.parseInt(owner.getOwnerType()),owner.getName(),owner.getAddress()});
	}
	public void deleteOwner(int ownerId) {
		getJdbcTemplate().update(OwnerQueries.INACTIVATE_OWNER,new Object[] {ownerId});
	}
	public void updatePriceByType(double dailyRate,double weeklyRate,int type) {
		getJdbcTemplate().update(CarQueries.UPDATE_PRICES_BY_TYPE,new Object[] {dailyRate,weeklyRate,type});
	}
	public void deleteCar(int carId) {
		getJdbcTemplate().update(CarQueries.INACTIVATE_CAR,new Object[]{carId});
	}
	public List<Car> getCars() {
		return getJdbcTemplate().query(CarQueries.GET_CARS, new CarMapper());
	}
	public List<Car> getCarsByAvailablity(String startDate,String endDate) {
		return getJdbcTemplate().query(CarQueries.GET_CARS_BY_AVAILABLITY,new Object[] {startDate,endDate,startDate,endDate},new CarMapper());
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
	public void insertCar(Car car) {
		getJdbcTemplate().update(CarQueries.INSERT_CAR,new Object[] {car.getModel(),car.getYear(),car.getVehicleNo(),car.getCarType().getCarTypeId(),car.getOwner().getOwnerId()});
		
	}
	public List<CarType> getCarTypes() {
		return getJdbcTemplate().query(CarQueries.GET_CAR_TYPES,new CarTypeMapper());
	}
	public List<CustomerType> getCustomerTypes() {
		return getJdbcTemplate().query(CustomerQueries.GET_CUSTOMERTYPE,new CustomerTypeMapper());
	}
	public List<OwnerType> getOwnerTypes() {
		return getJdbcTemplate().query(OwnerQueries.GET_OWNERTYPE,new OwnerTypeMapper());
	}
	public void insertCarType(CarType carType) {
		getJdbcTemplate().update(CarQueries.INSERT_CAR_TYPE,new Object[] {carType.getCarType(),carType.getDailyRate(),carType.getWeeklyRate()});
	}
	public void updateCarType(CarType carType) {
		getJdbcTemplate().update(CarQueries.UPDATE_PRICES_BY_TYPE,new Object[] {carType.getDailyRate(),carType.getWeeklyRate(),carType.getCarTypeId()});
	}
	public void deleteCarType(int carTypeId) {
		getJdbcTemplate().update(CarQueries.DELETE_CAR_TYPE,new Object[] {carTypeId});
	}
	public void updateRentals(String applicationDate) {
		/*getJdbcTemplate().update(CarQueries.UPDATE_RENTALS_AFTER);
		getJdbcTemplate().update(CarQueries.UPDATE_RENTALS_BEFORE,new Object[] {applicationDate});
		getJdbcTemplate().update(CarQueries.UPDATE_RENTALS_PROCESS,new Object[] {applicationDate});*/
	}
	public List<Car> getRentedCars(int customerId) {
		return getJdbcTemplate().query(RentalQueries.GET_RENTED_CARS, new Object[] {customerId},new CarMapper());
	}
	public Rental getRentalDetails(int customerId, int vehicleId) {
		return getJdbcTemplate().queryForObject(RentalQueries.GET_RENTAL_DETAILS, new Object[] {customerId,vehicleId},new RentalMapper());
	}
	public void returnCar(int rentalId) {
		getJdbcTemplate().update(RentalQueries.RETURN_CAR,new Object[] {rentalId});
	}
	public List<Car> ownercars(int ownerId) {
		return getJdbcTemplate().query(CarQueries.GET_CARS_BY_OWNER,new Object[] {ownerId},new CarMapper());
	}
	
}
