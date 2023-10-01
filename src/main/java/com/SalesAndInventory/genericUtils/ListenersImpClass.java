package com.SalesAndInventory.genericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImpClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test= report.createTest(methodName);
		Reporter.log(methodName+"--->ExecutionStarts", true);
	}	
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"--->Passed");
		Reporter.log(methodName+"---> Testscript executed successfully", true);
	}
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" has got failed");
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.takesScreenshot(BaseClass.sdriver, methodName);
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, methodName+"--->Failed");
		Reporter.log(methodName+"--->Failed", true);
	}
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methodName+"---->Skipped");
		Reporter.log(methodName+"--> Skipped", true);
	}
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport/report.html");		
		htmlreport.config().setDocumentTitle("SalesAndInventory");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("SalesAndInventory");

		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		report.setSystemInfo("Reporter-Name", "Bhavana");
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
