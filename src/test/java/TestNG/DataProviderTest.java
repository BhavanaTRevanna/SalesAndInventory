package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.Ipathconstants;

public class DataProviderTest {


	@DataProvider
	public Object[][] mobile() {
		Object[][] obj = new Object[2][2];

		obj[0][0]="Samsung";
		obj[0][1]= 15000;

		obj[1][0]="Redmi";
		obj[1][1]=20000;

		return obj;
	}

	@DataProvider
	public Object[][] tv() {
		Object[][] obj = new Object[3][3];

		obj[0][0]="LG";
		obj[0][1]=25000;
		obj[0][2]="42 inch";

		obj[1][0]="Sony";
		obj[1][1]=20000;
		obj[1][2]="32 inch";

		obj[2][0]="TCL";
		obj[2][1]=19000;
		obj[2][2]="52 inch";

		return obj;
	}

	@DataProvider
	public Object[][] dataFromExcel() throws Throwable, Throwable {
		ExcelUtility eLib=new ExcelUtility();
		Object[][] value = eLib.getMultipleSetOfData("tv");
		return value;
	}
}
