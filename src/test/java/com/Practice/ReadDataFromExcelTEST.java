package com.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTEST {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("Sheet1");


		int lastRow = sh.getLastRowNum();
		short lastCell = sh.getRow(1).getLastCellNum();
		for (int i = 0; i <=lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+"  ");

			}
			System.out.println();

		}
	}
}
