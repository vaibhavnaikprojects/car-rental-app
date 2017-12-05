package com.vaibhavnaikprojects.carrental.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.CarType;
import com.vaibhavnaikprojects.carrental.beans.CarUI;
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.CustomerType;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.beans.OwnerType;
import com.vaibhavnaikprojects.carrental.beans.Rental;
import com.vaibhavnaikprojects.carrental.daoservices.CatalogDaoServiceImpl;
import com.vaibhavnaikprojects.carrental.daoservices.RentalDaoServiceImpl;

@Service
public class CatalogServiceImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);
	@Autowired
	CatalogDaoServiceImpl catalogDaoService;
	@Autowired
	RentalDaoServiceImpl rentalDaoService;
	
	public void editCustomer(Customer customer) {
		catalogDaoService.insertCustomer(customer);
	}

	public void deleteCustomer(int custId) {
		catalogDaoService.deleteCustomer(custId);
	}

	public void editOwner(Owner owner) {
		catalogDaoService.insertOwner(owner);
	}
	public void deleteOwner(int ownerId) {
		catalogDaoService.deleteOwner(ownerId);
	}

	public void editCar(Car car) {
		catalogDaoService.insertCar(car);
	}

	public void editCarRate(CarType carType) {
		if(carType.getCarTypeId()>0)
			catalogDaoService.updateCarType(carType);
		else
			catalogDaoService.insertCarType(carType);
	}

	public void deleteCar(int carId) {
		catalogDaoService.deleteCar(carId);
	}

	public void updatePrices(double dailyRate,double weeklyRate,int type) {
		catalogDaoService.updatePriceByType(dailyRate, weeklyRate, type);
	}

	public List<CarUI> getCars(String filter) {
		List<Car> cars;
		if(filter!=null)
			cars=catalogDaoService.getCarsByAvailablity(filter,null);
		else
			cars=catalogDaoService.getCars();
		List<CarUI> carList=new ArrayList<>(cars.size());
		for (Car car : cars) {
			carList.add(new CarUI(car, car.getCarType().getCarType(),car.getCarType().getDailyRate(),car.getCarType().getWeeklyRate(), car.getOwner().getName()));
		}
		return carList;
	}

	public List<Car> getCarsToRent(String startDate,String endDate) {
		return catalogDaoService.getCarsByAvailablity(startDate,endDate);
	}

	public List<Customer> getCustomers(String filter) {
		if(filter!=null)
			return catalogDaoService.getCustomersByAvailablity(filter);
		else
			return catalogDaoService.getCustomers();
	}

	public List<Owner> getOwners() {
		return catalogDaoService.getOwners();
	}

	public List<CarType> getCarTypes() {
		return catalogDaoService.getCarTypes();
	}

	public List<OwnerType> getOwnerTypes() {
		return catalogDaoService.getOwnerTypes();
	}

	public List<CustomerType> getCustomerTypes() {
		return catalogDaoService.getCustomerTypes();
	}

	public void deleteRate(int parseInt) {
		catalogDaoService.deleteCarType(parseInt);
	}

	public void updateRentals(String applicationDate) {
		catalogDaoService.updateRentals(applicationDate);
	}

	public void addRental(Rental rental) {
		rentalDaoService.addRental(rental);
	}

	public List<Car> getRentedCars(int customerId) {
		List<Car> cars=catalogDaoService.getRentedCars(customerId);
		return cars;
	}

	public Rental getRentalDetails(int customerId, int vehicleId) {
		return catalogDaoService.getRentalDetails(customerId,vehicleId);
	}

	public void returnCar(int rentalId) {
		catalogDaoService.returnCar(rentalId);
	}

	public List<Car> ownercars(int ownerId) {
		return catalogDaoService.ownercars(ownerId);
	}
}

