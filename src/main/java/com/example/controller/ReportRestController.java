package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.DepartmentReportService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportRestController {
	
	@Autowired
	private DepartmentReportService service;
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception {
	  	
		response.setContentType("application/octet-stream");
		
		String headerKey="Content-Disposition";
		String headerValue="attachment;filename=department.xls";
		
		response.setHeader(headerKey, headerValue);
		service.generateExcel(response);
	}

}
