package com.SalesAndInventory.genericUtils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Bhavana
 *
 */
public class JavaUtility {
	/**
	 * this method is used to generate random numbers
	 * @return
	 */
	public int getRandomnumber() {
		Random ran=new Random();
		int randNum=ran.nextInt(1000);
		return randNum;
	}
	/**
	 * this method is used to get the system date
	 * @return
	 */
	public String getSystemDate() {
		Date date = new Date();
		return date.toString();
	}
	/**
	 * this method is used to fetch the system date in format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
        String systemDateInFormat = dateFormat.format(date);
        return systemDateInFormat;
	}
}
