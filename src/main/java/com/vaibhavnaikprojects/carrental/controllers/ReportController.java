package com.vaibhavnaikprojects.carrental.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/ownerReport", method = RequestMethod.GET)
	public ModelAndView ownerReport(HttpServletRequest request,@RequestParam("ownerId") int ownerId) {
		reportService.ownerReport(ownerId);
		return new ModelAndView("reports");
	}
	
	@RequestMapping(value = "/carTypeReport", method = RequestMethod.GET)
	public ModelAndView carTypeReport(HttpServletRequest request,@RequestParam("carTypeId")int carTypeId) {
		reportService.carTypeReport(carTypeId);
		return new ModelAndView("reports");
	}
	
	@RequestMapping(value = "/ownerCarReport", method = RequestMethod.GET)
	public ModelAndView ownerCarReport(HttpServletRequest request,@RequestParam("ownerId")int ownerId,@RequestParam("carId") int carId) {
		reportService.ownerCarReport(ownerId,carId);
		return new ModelAndView("reports");
	}
}
