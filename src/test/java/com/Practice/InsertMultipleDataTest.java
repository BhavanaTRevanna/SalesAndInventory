package com.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertMultipleDataTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Scanner sc=new Scanner(System.in);
		Workbook wb = WorkbookFactory.create(fis);
		//System.out.println("Enter the details ");
		String details;
		Sheet sh = wb.getSheet("Sheet1");
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(1).getLastCellNum();
		
		for (int i =lastRow; i <lastRow+2; i++) {
			for (int j = 0; j <lastCell; j++) {
				if(j==0) {
					System.out.println("Enter the customer name");
					details=sc.nextLine();
				sh.createRow(i).createCell(j).setCellValue(details);
			}
			else if (j==1) {
				System.out.println("Enter the customer location");
				details=sc.nextLine();
				sh.getRow(i).createCell(j).setCellValue(details);
				
			} 
			else
			{
				System.out.println("Enter the customer contact details");
				details=sc.nextLine();
				sh.getRow(i).createCell(j).setCellValue(details);
			}
			System.out.println();
		}
			System.out.println("Data entered successfully");
		FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);

	}
	}
}
