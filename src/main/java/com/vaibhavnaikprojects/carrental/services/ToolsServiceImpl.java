package com.vaibhavnaikprojects.carrental.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.daoservices.ToolsDaoServiceImpl;
import com.vaibhavnaikprojects.carrental.exceptions.AppException;

@Service
public class ToolsServiceImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(ToolsServiceImpl.class);
	@Autowired
	ToolsDaoServiceImpl toolsDaoService;
	
	public Map<String, Object> uploadExcel(InputStream inputStream) {
		try {
			Map<String, Object> excelObjects=new HashMap<String,Object>();
			Workbook workbook=new XSSFWorkbook(inputStream);
			LOGGER.info("workbook read");
			Sheet sheet=workbook.getSheetAt(0);
			List<Customer> customers=new ArrayList<Customer>(sheet.getLastRowNum());
			for(int i=1;i<sheet.getLastRowNum();i++) {
				Row row=sheet.getRow(i);
				customers.add(new Customer(0, row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue()));
			}
			LOGGER.info("customers added "+customers);
			excelObjects.put("customers",customers);
			sheet=workbook.getSheetAt(1);
			List<Owner> owners=new ArrayList<Owner>(sheet.getLastRowNum());
			for(int i=1;i<sheet.getLastRowNum();i++) {
				Row row=sheet.getRow(i);
				owners.add(new Owner(0, row.getCell(1).getStringCellValue(), row.getCell(0).getStringCellValue(), row.getCell(2).getStringCellValue()));
			}
			excelObjects.put("owners",owners);
			LOGGER.info("owners added "+owners);
			sheet=workbook.getSheetAt(2);
			List<Car> cars=new ArrayList<Car>(sheet.getLastRowNum());
			for(int i=1;i<sheet.getLastRowNum();i++) {
				Row row=sheet.getRow(i);
				cars.add(new Car(0,row.getCell(1).getStringCellValue(), row.getCell(2).getNumericCellValue(), row.getCell(3).getStringCellValue(),row.getCell(0).getStringCellValue(), row.getCell(4).getNumericCellValue(), row.getCell(5).getNumericCellValue(), "available"));
			}
			excelObjects.put("cars",cars);
			LOGGER.info("cars added "+cars);
			workbook.close();
			return excelObjects;
		} catch (IOException e) {
			LOGGER.error("uploadExcel",e);
			return null;
		}
	}

	public void addObjectsToDB(Map<String, Object> excelSheetObj) throws AppException {
		try {
			toolsDaoService.insertRecords(excelSheetObj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
	}

}
