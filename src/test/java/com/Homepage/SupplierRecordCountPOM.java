package com.Homepage;


import java.util.HashMap;



import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.Sales.ObjectRepo.CreateSupplierPage;
import com.Sales.ObjectRepo.HomePage;

import com.SalesAndInventory.genericUtils.BaseClass;


public class SupplierRecordCountPOM extends BaseClass{
	@Test
	public  void supplierRecordCountPOM() throws Throwable {

		//String sheetName="data";

		//String custName=eLib.readDataFromExcelSheet(sheetName, 10, 1);

	

		HomePage hp=new HomePage(driver);
		CreateSupplierPage cs=new CreateSupplierPage(driver);

		String count = hp.getSupplierRecordCount();

		HashMap<String, String> map = eLib.getDataFromExcel("supplierCount", 0, 1, driver);
		cs.createSupplier(map, driver, "Bohol");

		hp.getHomeBtn().click();

		String ecount = hp.getSupplierRecordCount();

		assertNotSame(count, ecount, "supplier count is changing");
		/*if (count.equals(ecount)) {
			System.out.println("supplier count is not changing");
		}
		else
			System.out.println("supplier count is changing");

*/
	}

}
