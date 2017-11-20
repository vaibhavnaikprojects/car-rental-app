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
import com.vaibhavnaikprojects.carrental.beans.CarType;
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
			List<String> ownerType=new ArrayList<String>();
			for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				Row row=sheet.getRow(i);
				ownerType.add(row.getCell(0).getStringCellValue());
			}
			LOGGER.info("ownerType added "+ownerType);
			excelObjects.put("ownerType",ownerType);
			sheet=workbook.getSheetAt(1);
			List<Owner> owners=new ArrayList<Owner>(sheet.getLastRowNum()+1);
			for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				Row row=sheet.getRow(i);
				owners.add(new Owner(0, row.getCell(1).getStringCellValue(), row.getCell(0).getStringCellValue(), row.getCell(2).getStringCellValue()));
			}
			excelObjects.put("owners",owners);
			LOGGER.info("owners added "+owners);
			sheet=workbook.getSheetAt(2);
			List<String> customerType=new ArrayList<String>();
			for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				Row row=sheet.getRow(i);
				customerType.add(row.getCell(0).getStringCellValue());
			}
			LOGGER.info("customerType added "+customerType);
			excelObjects.put("customerType",customerType);
			sheet=workbook.getSheetAt(3);
			List<Customer> customers=new ArrayList<Customer>(sheet.getLastRowNum()+1);
			for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				Row row=sheet.getRow(i);
				customers.add(new Customer(0, row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue()));
			}
			LOGGER.info("customers added "+customers);
			excelObjects.put("customers",customers);
			sheet=workbook.getSheetAt(4);
			List<CarType> carTypes=new ArrayList<CarType>(sheet.getLastRowNum()+1);
			for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				Row row=sheet.getRow(i);
				carTypes.add(new CarType(0,row.getCell(0).getStringCellValue(), row.getCell(1).getNumericCellValue(), row.getCell(2).getNumericCellValue()));
			}
			excelObjects.put("carTypes",carTypes);
			LOGGER.info("carTypes added "+carTypes);
			sheet=workbook.getSheetAt(5);
			List<Car> cars=new ArrayList<Car>(sheet.getLastRowNum()+1);
			for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				Row row=sheet.getRow(i);
				cars.add(new Car(0,row.getCell(1).getStringCellValue(),row.getCell(2).getNumericCellValue(),row.getCell(3).getStringCellValue(),new CarType(row.getCell(0).getStringCellValue()),"AVAILABLE","","",new Owner(row.getCell(5).getStringCellValue())));
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
