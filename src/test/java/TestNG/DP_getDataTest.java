package TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SalesAndInventory.genericUtils.ExcelUtility;

public class DP_getDataTest {
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataFromExcel")
	public void getData(String prodName, String price, String size) {
		System.out.println(prodName+"==>"+price+"==>"+size);
	}
	
}
