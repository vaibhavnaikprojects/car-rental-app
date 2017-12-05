package com.vaibhavnaikprojects.carrental.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.vaibhavnaikprojects.carrental.services.CatalogServiceImpl;
import com.vaibhavnaikprojects.carrental.util.ApplicationValues;

@Controller
public class ApplicationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);
	@Autowired
	CatalogServiceImpl catalogService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView(new RedirectView("rentcar"));
	}
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView infoGet(HttpServletRequest request) {
		return new ModelAndView("info");
	}
	@RequestMapping(value = "/applicationDate", method = RequestMethod.GET)
	@ResponseBody public boolean applicationDate(HttpServletRequest request,@RequestParam("applicationDate") String applicationDate) {
		ApplicationValues.applicationDate=applicationDate;
		catalogService.updateRentals(applicationDate);
		return true;
	}
	
	
}
