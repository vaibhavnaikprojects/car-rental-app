package com.vaibhavnaikprojects.carrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhavnaikprojects.carrental.daoservices.ReportDaoServiceImpl;
@Service
public class ReportServiceImpl {
	@Autowired
	ReportDaoServiceImpl reportDaoService;
	
/*	public List<Rental> ownerCarReport(int ownerId, int carId) {
		return reportDaoService.ownerCarReport(ownerId, carId);
	}
	public List<Rental> carTypeReport(int carTypeId) {
		return reportDaoService.carTypeReport(carTypeId);
	}

	public List<Rental> ownerReport(int ownerId) {
		return reportDaoService.ownerReport(ownerId);
	}*/
}
