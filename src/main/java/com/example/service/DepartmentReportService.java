package com.example.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.repository.DepartmentRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class DepartmentReportService {
	
	@Autowired
	private DepartmentRepository repository;
	
	public  void generateExcel(HttpServletResponse response) throws Exception {
		
		List<Department> departments = repository.findAll();
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Department-Info");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("deptId");
		row.createCell(1).setCellValue("deptAddress");
		row.createCell(2).setCellValue("deptCode");
		row.createCell(3).setCellValue("deptName");
		
		int dataRowIndex=1;
		
		for(Department dept:departments) {
			HSSFRow row2 = sheet.createRow(dataRowIndex);
			row2.createCell(0).setCellValue(dept.getDeptId());
			row2.createCell(1).setCellValue(dept.getDeptAddress());
			row2.createCell(2).setCellValue(dept.getDeptCode());
			row2.createCell(3).setCellValue(dept.getDeptName());
			dataRowIndex ++;
		}
		
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();
		
	}

}
