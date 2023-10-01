package com.SalesAndInventory.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This consists of excel sheet related methods
 * @author Admin
 *
 */
public class ExcelUtility extends JavaUtility{
	/**
	 * this method is used to read data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(Ipathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String data = cell.toString();
		return data;
	}
	/**
	 * this method is used to write data into excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo, String value) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(Ipathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);
		FileOutputStream fout = new FileOutputStream(Ipathconstants.excelPath);
		wb.write(fout);
		wb.close();
	}
	/**
	 * this method is used to fetch row count from the excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(Ipathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;	
	}
	public HashMap<String, String> getMultipleDataFromExcel(String sheetName, int keyColumn, int valueColumn, WebDriver driver) throws Throwable {
		//to fetch data from excel
		FileInputStream fis=new FileInputStream(Ipathconstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();


		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <=count; i++) {
			String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value=sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);

		}
		for(Entry<String, String> s:map.entrySet()) {
			if(s.getKey().equals("//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='Phone Number']") || s.getKey().equals("//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='First Name']") || s.getKey().equals("phonenumber") || s.getKey().equals("companyname"))
				driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue()+getRandomnumber());
			else
				driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
		}
		return map;
	}
	
	public HashMap<String, String> getDataFromExcel(String sheetName, int keyColumn, int valueColumn, WebDriver driver) throws Throwable {
		//to fetch data from excel
		FileInputStream fis=new FileInputStream(Ipathconstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();


		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <=count; i++) {
			String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value=sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}

	public HashMap<String, String> getMultipleDataFromExcelByName(String sheetName, int keyColumn, int valueColumn, WebDriver driver) throws Throwable {
		//to fetch data from excel
		FileInputStream fis=new FileInputStream(Ipathconstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();

		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <=count; i++) {
			String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value=sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);

		}
		for(Entry<String, String> s:map.entrySet()) {
			if(s.getKey().equals("phonenumber") || s.getKey().equals("companyname"))
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+getRandomnumber());
			else
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}

		return map;
	}

	public HashMap<String, String> getMultipleDataFromExcelById(String sheetName, int keyColumn, int valueColumn, WebDriver driver) throws Throwable {
		//to fetch data from excel
		FileInputStream fis=new FileInputStream(Ipathconstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();


		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <=count; i++) {
			String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value=sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);

		}
		for(Entry<String, String> s:map.entrySet()) {
			if(s.getKey().equals("phonenumber") || s.getKey().equals("companyname"))
				driver.findElement(By.id(s.getKey())).sendKeys(s.getValue()+getRandomnumber());
			else
				driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
		}

		return map;
	}
	public Object[][] getMultipleSetOfData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(Ipathconstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
	    int lastCell = sheet.getRow(0).getLastCellNum();
	
	    Object[][] obj = new Object[lastRow][lastCell];
	    for (int i = 0; i < lastRow; i++) {
	    	for (int j = 0; j < lastCell; j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
	    return obj;
	   
	}


}
