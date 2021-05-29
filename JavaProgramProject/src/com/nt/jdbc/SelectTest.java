//jdbc programto find student details between startavg and endavg rang 
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest {

	public static void main(String[] args) {

		Scanner sc= null;
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//read input from enduser
			sc=new Scanner(System.in);
			float startavg=0.0f,endavg=0.0f;
			if(sc!=null) {
				System.out.println("Enetr Starting Avg::");
				startavg=sc.nextFloat();
				System.out.println("Enetr Ending Avg::");
				endavg=sc.nextFloat();
			}
			//establish the connection with database
			con=DriverManager.getConnection("jdbc:mysql:///sms","root","root");
			//create the statement
			if(con!=null)
				st=con.createStatement();
			//prepare sqlquery
			String SqlQuery="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE AVG >="+startavg+" AND AVG <="+endavg+" ";
			System.out.println(SqlQuery);
			if(st!=null)
				rs=st.executeQuery(SqlQuery);
			if(rs!=null) {
				boolean flag=false;
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4));
				}
				if(flag==false)
					System.out.println("No Record Found");
			}

		}
		catch(SQLException se) {
			se.printStackTrace();	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
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
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
