package com.vaibhavnaikprojects.carrental.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);
	
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public ModelAndView reportsGet(HttpServletRequest request) {
		return new ModelAndView("reports");
	}
	
}
