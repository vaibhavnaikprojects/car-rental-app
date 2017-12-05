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

import com.vaibhavnaikprojects.carrental.beans.CarType;
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.CustomerType;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.beans.OwnerType;
import com.vaibhavnaikprojects.carrental.services.CatalogServiceImpl;

@Controller
public class CatalogController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);
	
	@Autowired
	CatalogServiceImpl catalogService;
	
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public ModelAndView catalogGet(HttpServletRequest request) {
		ModelAndView view=new ModelAndView("catalog");
		List<CustomerType> customerTypes=catalogService.getCustomerTypes();
		List<OwnerType> ownerTypes=catalogService.getOwnerTypes();
		List<CarType> carTypes=catalogService.getCarTypes();
		StringBuilder cType = new StringBuilder(),oType=new StringBuilder(),custType=new StringBuilder();
		for (CarType carType : carTypes) {
			cType.append(carType.getCarTypeId()+":"+carType.getCarType()+";");
		}
		for (OwnerType ownerType : ownerTypes) {
			oType.append(ownerType.getOwnerTypeId()+":"+ownerType.getOwnerType()+";");
		}
		for (CustomerType customerType : customerTypes) {
			custType.append(customerType.getCustomerTypeId()+":"+customerType.getCustomerType()+";");
		}
		view.addObject("carType",cType.substring(0,cType.length()-1));
		view.addObject("ownerType",oType.substring(0,oType.length()-1));
		view.addObject("customerType",custType.substring(0,custType.length()-1));
		return view;
	}
	
	@RequestMapping(value = "/ownerType", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<OwnerType> getOwnerType(HttpServletRequest request){
		return catalogService.getOwnerTypes();
	}
	
	@RequestMapping(value = "/customerType", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<CustomerType> getCustomerTypes(HttpServletRequest request){
		return catalogService.getCustomerTypes();
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Customer> getCustomers(HttpServletRequest request,@RequestParam("filter") String filter){
		LOGGER.info("customers "+filter);
		if(filter==null || "".equalsIgnoreCase(filter))
			return catalogService.getCustomers(null);
		return catalogService.getCustomers(filter);
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public boolean editCustomer(HttpServletRequest request){
		LOGGER.info("delete Customer "+Integer.parseInt(request.getParameter("id")));
		catalogService.deleteCustomer(Integer.parseInt(request.getParameter("id")));
		return true;
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public boolean addCustomer(HttpServletRequest request,@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("customerType") int customerType){
		Customer customer=new Customer(0, name, customerType+"", phone);
		LOGGER.info("addCustomer "+customer);
		catalogService.editCustomer(customer);
		return true;
	}
	
	@RequestMapping(value = "/owners", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Owner> getOwners(HttpServletRequest request){
		return catalogService.getOwners();
	}
	
	@RequestMapping(value = "/editOwner", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public boolean editOwner(HttpServletRequest request){
		LOGGER.info("delete Owner "+Integer.parseInt(request.getParameter("id")));
		catalogService.deleteOwner(Integer.parseInt(request.getParameter("id")));
		return true;
	}
	@RequestMapping(value = "/addOwner", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public boolean addOwner(HttpServletRequest request,@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("ownerTypeId") int ownerTypeId){
		Owner owner=new Owner(0, ownerTypeId+"", name, address);
		LOGGER.info("add Owner"+owner);
		catalogService.editOwner(owner);
		return true;
	}
	
	@RequestMapping(value = "/rate", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<CarType> getCarTypes(HttpServletRequest request){
		return catalogService.getCarTypes();
	}
	
	@RequestMapping(value = "/editRate", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public boolean editRate(HttpServletRequest request){
		LOGGER.info("delete Rate "+Integer.parseInt(request.getParameter("id")));
		if("edit".equalsIgnoreCase(request.getParameter("oper"))) {
			CarType carType=new CarType(Integer.parseInt(request.getParameter("id")),request.getParameter("carType"),Double.parseDouble(request.getParameter("dailyRate")),Double.parseDouble(request.getParameter("weeklyRate")));	
			catalogService.updatePrices(carType.getDailyRate(), carType.getWeeklyRate(), carType.getCarTypeId());
		}
		else {
			catalogService.deleteRate(Integer.parseInt(request.getParameter("id")));
		}
		return true;
	}
	
	@RequestMapping(value = "/addRate", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public boolean addRate(HttpServletRequest request,@RequestParam("carType") String carType,@RequestParam("dailyRate") double dailyRate,@RequestParam("weeklyRate") double weeklyRate){
		CarType carType1=new CarType(0, carType, dailyRate, weeklyRate);
		LOGGER.info("rate"+carType1);
		catalogService.editCarRate(carType1);
		return true;
	}
	
	
	
}
