package TestNG;

import org.testng.annotations.Test;

public class DPExecutionTest {
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataFromExcel")
	public void getData(String prodName, String price, String size) {
		System.out.println(prodName+"==>"+price+"==>"+size);
	}
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "mobile")
	public void getData(String prodName, int price) {
		System.out.println(prodName+"===>"+price);
	}

}
