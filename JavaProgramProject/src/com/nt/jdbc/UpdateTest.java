//jdbc program to insert student data in database
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Scanner sc= null;

		Connection con =null;
		Statement st=null;

		try {
			//read input from user 
			sc=new  Scanner(System.in);
			int sno=0;
			String job1=null,job2=null;
			float percentage=0.0f;
			if(sc!=null) {
			System.out.println("Enter Emp JOb1::");
			job1=sc.nextLine().toUpperCase();
			System.out.println("Enter Emp job2::");
			job2=sc.next().toUpperCase();
			System.out.println("Enter Salary Of emp::");
			percentage=sc.nextFloat();
			}
			//establish the connection with data
//			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			con =DriverManager.getConnection("jdbc:mysql:///sms","root","root");
			//craete the statement objects
			if(con!=null)
				st=con.createStatement();
			//sqlQuer
			String Query="update emp set sal=sal+(sal*"+percentage+"/100) from emp where job in('"+job1+"','"+job2+"')";
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
