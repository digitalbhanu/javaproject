//jdbc programto find emp details between based on their 3job role
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest4 {

	public static void main(String[] args) {

		Scanner sc= null;
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//read input from enduser
			sc=new Scanner(System.in);
			String role1=null,role2=null,role3=null;
			if(sc!=null) {
				System.out.println("Enetr Job Role1 ::");
				role1=sc.next().toUpperCase();
				System.out.println("Enetr Job Role2 ::");
				role2=sc.next().toUpperCase();
				System.out.println("Enetr Job Role3 ::");
				role3=sc.next().toUpperCase();
				
			}
			//establish the connection with database
			con=DriverManager.getConnection("jdbc:mysql:///sms","root","root");
			//create the statement
			if(con!=null)
				st=con.createStatement();
			//prepare sqlquery
			String SqlQuery="select empno,ename,job,sal from emp where job in('"+role1+"','"+role2+"','"+role3+"') ORDER BY JOB ";
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
