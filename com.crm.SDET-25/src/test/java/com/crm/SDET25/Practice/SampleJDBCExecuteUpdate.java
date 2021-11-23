package com.crm.SDET25.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	@Test
	public void sampleJDBCExecuteUpdate() throws Throwable
	{
		//Step 1
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
		
		//Step 3
		Statement stat = con.createStatement();
		
		//Step 4
		int result = stat.executeUpdate("insert into studentinfo values('Sandya',15,'USA');");
		
		if (result==1) {
			System.out.println("data created");
		}
		
		else {
			System.out.println("data creation failed");
		}
		
		//Step 5
		con.close();
		
	}

}
