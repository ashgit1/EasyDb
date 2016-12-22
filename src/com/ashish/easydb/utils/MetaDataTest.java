package com.ashish.easydb.utils;

import java.sql.*;  

public class MetaDataTest {

	public static void main(String[] args) {
		
		try{  
			
			// Mysql
			/*Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mb", "root", "Root@123");*/
			
			// Derby
			Class.forName("org.apache.derby.jdbc.ClientDriver");  
			Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/testdb", "sa", "sa@123");
			
			// Oracle
			/*Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");*/
			
			DatabaseMetaData dbmd=con.getMetaData();  
			
			String table[] = {"TABLE"};
			  
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			
			System.out.println("Tables in Database: ");
			ResultSet rs = dbmd.getTables(null, null, null, table);
			while(rs.next()){
				System.out.println(rs.getString(3));
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  
		
	}
