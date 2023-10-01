package com.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcelTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);

	Sheet sh = wb.getSheet("Sheet1");
	int lastRow = sh.getLastRowNum();
	int lastCell = sh.getRow(1).getLastCellNum();
	
	//sh.getRow(2).getCell(1).setCellValue("Shivamogga");	
	sh.createRow(5).createCell(0).setCellValue("Shivu");
	sh.getRow(5).createCell(1).setCellValue("gadag");
	sh.getRow(5).createCell(2).setCellValue("'25");
	
	FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	wb.write(fos);


}}
