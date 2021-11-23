package com.crm.SDET25.BasicTestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.FileUtility;

public class CreateOrganization {
	
	@Test
	public void createOrganization() throws Throwable
	{
		WebDriver driver = null;
		
		//read the common data from property file
	    FileUtility fLib = new FileUtility();
	    
	    String BROWSER = fLib.readDataFromPropertyFile("browser");
	    String URL = fLib.readDataFromPropertyFile("url");
	    String USERNAME = fLib.readDataFromPropertyFile("username");
	    String PASSWORD = fLib.readDataFromPropertyFile("password");

		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			 driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			 driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		//navigate to url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organizations
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//enter the mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("TYSS1");
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
