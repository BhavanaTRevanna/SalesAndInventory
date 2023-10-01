package com.SalesAndInventory.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Bhavana
 *
 */
public class FileUtility {
	/**
	 * this method is used to fetch data from commonData Property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis= new FileInputStream(Ipathconstants.propertyFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
