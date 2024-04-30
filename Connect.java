package com.TTM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect{
	
	Connection c;
	Statement s;
	Connect()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql:///TTMANAGEMENT","root","installer");
		s = c.createStatement();
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
