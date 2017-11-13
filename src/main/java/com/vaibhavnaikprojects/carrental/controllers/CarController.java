package com.vaibhavnaikprojects.carrental.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);
	
	@RequestMapping(value = "/rentcar", method = RequestMethod.GET)
	public ModelAndView homeGet(HttpServletRequest request) {
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/returncar", method = RequestMethod.GET)
	public ModelAndView returncarGet(HttpServletRequest request) {
		return new ModelAndView("returncar");
	}
}
