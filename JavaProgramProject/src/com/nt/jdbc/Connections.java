//Java Program to check connection is establish or not.
package com.nt.jdbc;

import java.sql.*;
public class Connections {

	public static void main(String[] args) throws Exception {
		
		//Load the jdbc driver class
//		oracle.jdbc.driver.OracleDriver obj = new oracle.jdbc.driver.OracleDriver();
//		DriverManager.registerDriver(obj);
		
		/* another way to crate connection*/
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//establish the connection with oracle Database
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		//establish the connection with mysql database
		Connection mcon=DriverManager.getConnection("jdbc:mysql:///sms","root","root");
		if(con!=null) {
			System.out.println("Connection Establish Succesfully");
		}
		else {
			System.out.println("Error In Connection");
		}
		
		if(mcon!=null)
			System.out.println("Connection Establish With Mysql");
		else
			System.out.println("Error In Connection");

	}

}
