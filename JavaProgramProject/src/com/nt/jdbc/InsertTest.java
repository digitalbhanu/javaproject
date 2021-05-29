//jdbc program to insert student data in database
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		Scanner sc= null;

		Connection con =null;
		Statement st=null;

		try {
			//read input from user 
			sc=new  Scanner(System.in);
			int sno=0;
			String sname=null,sadd=null;
			float avg=0.0f;
			if(sc!=null) {
			System.out.println("Enter Student Number::");
			sno=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Student Name::");
			sname=sc.nextLine().toUpperCase();
			System.out.println("Enter Student Address::");
			sadd=sc.next().toUpperCase();
			System.out.println("Enter Avarage Of Student::");
			avg=sc.nextFloat();
			}
			//establish the connection with data
//			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			con =DriverManager.getConnection("jdbc:mysql:///sms","root","root");
			//craete the statement objects
			if(con!=null)
				st=con.createStatement();
			//sqlQuer
			String Query="INSERT INTO STUDENT VALUES("+sno+",'"+sname+"','"+sadd+"',"+avg+")";
			System.out.println(Query);
			//send and execute the sqlquery
			boolean flag=false;
			if(st!=null) {
				flag=true;
				st.executeUpdate(Query);
				System.out.println("Data Inserted ");
			}
			else {
				flag=false;
				System.out.println("No Data inserted ::");
			}
		}
		catch(SQLException se) {
		//to handle known exception
			se.printStackTrace();
		}
		catch(Exception e) {
			//to handle unknown exception
			e.printStackTrace();
		}
		finally {
			//close all jdbc objs and stream objs
			
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//end of finally
		
	}//main

}//class
