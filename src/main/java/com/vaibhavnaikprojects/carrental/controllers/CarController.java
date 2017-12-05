package com.vaibhavnaikprojects.carrental.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.CarType;
import com.vaibhavnaikprojects.carrental.beans.CarUI;
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.beans.Rental;
import com.vaibhavnaikprojects.carrental.services.CatalogServiceImpl;
import com.vaibhavnaikprojects.carrental.util.ApplicationValues;

@Controller
public class CarController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	CatalogServiceImpl catalogService;
	
	@RequestMapping(value = "/rentcar", method = RequestMethod.GET)
	public ModelAndView homeGet(HttpServletRequest request) {
		return new ModelAndView("home","applicationDate",ApplicationValues.applicationDate);
	}
	@RequestMapping(value = "/returncar", method = RequestMethod.GET)
	public ModelAndView returncarGet(HttpServletRequest request) {
		return new ModelAndView("returncar");
	}
	
	@RequestMapping(value = "/rentcars", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Car> getRentCars(HttpServletRequest request,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate){
		LOGGER.info("rentcar startDate"+startDate+" application Date: "+endDate);
		return catalogService.getCarsToRent(startDate,endDate);
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<CarUI> getCars(HttpServletRequest request,@RequestParam("filter") String filter){
		LOGGER.info("car "+filter);
		if(filter==null || "".equalsIgnoreCase(filter))
			return catalogService.getCars(null);
		return catalogService.getCars(filter);
	}
	
	@RequestMapping(value = "/addCar", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public boolean addCar(HttpServletRequest request,@RequestParam("model")String model,@RequestParam("year")int year,@RequestParam("vehicleNo")String vehicleNo,@RequestParam("carTypeId")int carTypeId,@RequestParam("ownerId") int ownerId){
		Car car=new Car(0,model,year,vehicleNo,new CarType(carTypeId),"","","",new Owner(ownerId));
		LOGGER.info("Add Car "+car);
		catalogService.editCar(car);
		return true;
	}
	
	@RequestMapping(value = "/editCar", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public boolean deleteCar(HttpServletRequest request){
		LOGGER.info("deleteCar Car "+request.getParameter("id"));
		catalogService.deleteCar(Integer.parseInt(request.getParameter("id")));
		return true;
	}
	@RequestMapping(value = "/rentingcar", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public String rentingcar(HttpServletRequest request){
		//@RequestParam("customerId")int customerId,@RequestParam("vehicleId")int vehicleId,@RequestParam("rentalType")String rentalType,@RequestParam("startDate")String startDate,@RequestParam("endDate") String endDate,@RequestParam("no") int no,@RequestParam("ownerId") int ownerId
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		int vehicleId=Integer.parseInt(request.getParameter("vehicleId"));
		String rentalType=request.getParameter("rentalType");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		int no=Integer.parseInt(request.getParameter("no"));
		int ownerId=Integer.parseInt(request.getParameter("ownerId"));
		double amountDue=Double.parseDouble(request.getParameter("amountDue"));
		Rental rental=new Rental(0, rentalType, new Customer(customerId), new Car(vehicleId), new Owner(ownerId), no, startDate, endDate,amountDue);
		catalogService.addRental(rental);
		return "true";
	}
	
	@RequestMapping(value = "/getRentedCars", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Car> getRentedCars(HttpServletRequest request){
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		return catalogService.getRentedCars(customerId);
	}
	@RequestMapping(value = "/getRentalDetails", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public Rental getRentalDetails(HttpServletRequest request){
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		int vehicleId=Integer.parseInt(request.getParameter("vehicleId"));
		return catalogService.getRentalDetails(customerId,vehicleId);
	}
	@RequestMapping(value = "/returnCar", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public String returnCar(HttpServletRequest request){
		int rentalId=Integer.parseInt(request.getParameter("rentalId"));
		catalogService.returnCar(rentalId);
		return "true";
	}
	@RequestMapping(value = "/ownercars", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Car> ownercars(HttpServletRequest request){
		int ownerId=Integer.parseInt(request.getParameter("ownerId"));
		return catalogService.ownercars(ownerId);
	}
	
}
