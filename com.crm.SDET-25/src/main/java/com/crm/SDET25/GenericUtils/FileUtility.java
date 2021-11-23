package com.crm.SDET25.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic methods for reading data from proprty File
 * @author Chaitra M
 *
 */
public class FileUtility {
	

	/**
	 * This method will return the value from property file when key is passed
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		
		return value;
		
	}

}
