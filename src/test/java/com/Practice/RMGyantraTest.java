package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGyantraTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//Thread.sleep(10);	
		driver.get("http://rmgtestingserver:8084");
	//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String expectedData = "Prathi_Sala_Cup_Namdhe";
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[contains(.,'Sign in')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(.,'Projects')]")).click();
		
		driver.findElement(By.xpath("//span[contains(.,'Create Project')]")).click();
		driver.findElement(By.name("projectName")).sendKeys(expectedData);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Deepak");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sel=new Select(ele);
		sel.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		
		Connection con=null;
		String actual=null;
		boolean flag = false;
		try {
			
		Driver	driver1=new Driver();
		DriverManager.registerDriver(driver1);
		con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	    Statement state = con.createStatement();
	    String query = "select * from project;";
	    ResultSet result = state.executeQuery(query);
	    
	    while (result.next()) {
			actual=result.getString(4);
			if (actual.equalsIgnoreCase(expectedData)) {
				flag=true;
				break;
			}
		}
	    if (flag) {
			System.out.println("Project created");
		}
	    else
	    	System.out.println("Project not created");
	    
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
		

	}

}
