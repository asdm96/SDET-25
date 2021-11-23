package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFileDemo {
	
	@Test
	public void propertyFileDemo() throws Throwable
	{
		FileInputStream fis = new FileInputStream("./CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROSWER = p.getProperty("browser");
		String URL = p.getProperty("url");
		
		System.out.println(BROSWER);
		System.out.println(URL);
	}

}
