package com.vaibhavnaikprojects.carrental.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vaibhavnaikprojects.carrental.exceptions.AppException;
import com.vaibhavnaikprojects.carrental.services.ToolsServiceImpl;
import com.vaibhavnaikprojects.carrental.util.FileDownloader;

@Controller
public class ToolController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ToolController.class);
	@Autowired
	ToolsServiceImpl toolsService;
	@Autowired
	FileDownloader filedownloader;
	
	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public ModelAndView toolsGet(HttpServletRequest request) {
		return new ModelAndView("tools");
	}
	@RequestMapping(value = "/uploadsheet", method = RequestMethod.POST)
	@ResponseBody public String index(@RequestParam("uploadsheet") MultipartFile uploadtrack) {
		String msg="success";
		LOGGER.info("File Uploaded "+uploadtrack.getName());
		try {
			Map<String, Object> excelSheetObj=toolsService.uploadExcel(uploadtrack.getInputStream());
			toolsService.addObjectsToDB(excelSheetObj);
		} catch (IOException | AppException e) {
			msg="error: "+e.getMessage();
		}
		return msg;
	}
	
	@RequestMapping(value = "/systemdataset", method = RequestMethod.GET)
	@ResponseBody public String systemdataset() {
		String msg="success";
		try {
		FileInputStream inputStream=new FileInputStream(new ClassPathResource("/DB import.xlsx").getFile());
			Map<String, Object> excelSheetObj=toolsService.uploadExcel(inputStream);
			toolsService.addObjectsToDB(excelSheetObj);
		} catch (IOException | AppException e) {
			msg="error: "+e.getMessage();
		}
		return msg;
	}
	
	@RequestMapping(value = "/downloadtemplate", method = RequestMethod.GET)
	@ResponseBody public String downloadtemplate(HttpServletResponse response) {
		String msg="success";
		try {
		File file=new ClassPathResource("/DBTemplate.xlsx").getFile();
		filedownloader.downloadFile(file, response, "DBTemplate.xlsx");
		} catch (IOException e) {
			msg="error: "+e.getMessage();
		}
		return msg;
	}
	

}
