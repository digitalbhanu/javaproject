//jdbc program to find nth highest salary of employees
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest7 {

	public static void main(String[] args) {

		Scanner sc=null;
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			sc=new Scanner(System.in);
			int no=0;
			if(sc!=null) {
				System.out.println("Enter POSITION OF EMPLOYEE SALARY");
				no=sc.nextInt();
			}
			//establish the connection with database
			con=DriverManager.getConnection("jdbc:mysql:///sms","root","root");
			//create the statement
			if(con!=null)
				st=con.createStatement();
			//prepare sqlquery
			String SqlQuery="SELECT empno,ename,saL FROM emp E1 WHERE "+no+"-1 =(SELECT COUNT(DISTINCT sal) FROM emp E2 WHERE E2.sal > E1.sal)";
			System.out.println(SqlQuery);
			if(st!=null)
				rs=st.executeQuery(SqlQuery);
			if(rs!=null) {
				boolean flag=false;
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
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
