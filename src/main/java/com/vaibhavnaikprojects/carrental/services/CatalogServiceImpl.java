package com.vaibhavnaikprojects.carrental.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.daoservices.CatalogDaoServiceImpl;

@Service
public class CatalogServiceImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);
	@Autowired
	CatalogDaoServiceImpl catalogDaoService;
	public void editCustomer(Customer customer) {
		if(customer.getId()>0)
			catalogDaoService.updateCustomer(customer);
		else
			catalogDaoService.insertCustomer(customer);
	}

	public void deleteCustomer(int custId) {
		catalogDaoService.deleteCustomer(custId);
	}

	public void editOwner(Owner owner) {
		if(owner.getOwnerId()>0)
			catalogDaoService.updateOwner(owner);
		else
			catalogDaoService.insertOwner(owner);
	}
	public void deleteOwner(int ownerId) {
		catalogDaoService.deleteOwner(ownerId);
	}

	public void editCar(Car car) {
		if(car.getVehicleId()>0)
			catalogDaoService.updateCar(car);
		else
			catalogDaoService.insertCar(car);
	}

	public void deleteCar(int carId) {
		catalogDaoService.deleteCar(carId);
	}
	
	public void updatePrices(double dailyRate,double weeklyRate,String type) {
		catalogDaoService.updatePriceByType(dailyRate, weeklyRate, type);
	}

	public List<Car> getCars(String filter) {
		if(filter!=null)
			return catalogDaoService.getCarsByAvailablity(filter);
		else
			return catalogDaoService.getCars();
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
}

