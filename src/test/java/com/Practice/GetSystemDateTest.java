package com.Practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetSystemDateTest {

public static void main(String[] args) {
	

		/*Date dateTime = new Date();
		System.out.println(dateTime);
        String[] d = dateTime.toString().split(" ");	
        
        String day = d[0];
        String month = d[1];
        String date = d[2];
        String year = d[5];
        
        String finalFormat = day+" "+month+" "+date+" "+year;

        System.out.println(finalFormat);
*/
	Date date = new Date();
    SimpleDateFormat dateFormat= new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
    String systemDateInFormat = dateFormat.format(date);
   System.out.println(systemDateInFormat);
}}
