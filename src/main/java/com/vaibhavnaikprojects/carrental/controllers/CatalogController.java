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
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.services.CatalogServiceImpl;

@Controller
public class CatalogController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);
	
	@Autowired
	CatalogServiceImpl catalogService;
	
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public ModelAndView catalogGet(HttpServletRequest request) {
		return new ModelAndView("catalog");
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Car> getCars(HttpServletRequest request,@RequestParam("filter") String filter){
		LOGGER.info("car "+filter);
		if(filter==null || "".equalsIgnoreCase(filter))
			return catalogService.getCars(null);
		return catalogService.getCars(filter);
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Customer> getCustomers(HttpServletRequest request,@RequestParam("filter") String filter){
		LOGGER.info("customers "+filter);
		if(filter==null || "".equalsIgnoreCase(filter))
			return catalogService.getCustomers(null);
		return catalogService.getCustomers(filter);
	}
	@RequestMapping(value = "/owners", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Owner> getOwners(HttpServletRequest request){
		return catalogService.getOwners();
	}
}
