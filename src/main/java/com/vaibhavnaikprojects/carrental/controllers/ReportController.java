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

import com.vaibhavnaikprojects.carrental.beans.Rental;
import com.vaibhavnaikprojects.carrental.daoservices.ReportDaoServiceImpl;

@Controller
public class ReportController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);
	@Autowired
	ReportDaoServiceImpl reportService;
	
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public ModelAndView reportsGet(HttpServletRequest request) {
		return new ModelAndView("reports");
	}
	
	@RequestMapping(value = "/ownerReport", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Rental> ownerReport(HttpServletRequest request,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate,@RequestParam("ownerId") int ownerId) {
		LOGGER.info("ownerReport startDate "+startDate+" endDate "+endDate+" ownerId "+ownerId);
		return reportService.ownerReport(startDate,endDate,ownerId);
	}
	
	@RequestMapping(value = "/carTypeReport", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Rental> carTypeReport(HttpServletRequest request,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate,@RequestParam("carTypeId")int carTypeId) {
		LOGGER.info("carTypeReport "+carTypeId);
		return reportService.carTypeReport(startDate,endDate,carTypeId);
	}
	
	@RequestMapping(value = "/ownerCarReport", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public List<Rental> ownerCarReport(HttpServletRequest request,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate,@RequestParam("ownerId")int ownerId,@RequestParam("carId") int carId) {
		LOGGER.info("ownerCarReport ownerId "+ownerId+" carId "+carId+" start date "+startDate+" end date "+endDate);
		return reportService.ownerCarReport(startDate,endDate,ownerId,carId);
	}
}
