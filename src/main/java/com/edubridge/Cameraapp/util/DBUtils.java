package com.edubridge.Cameraapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getConnection() {
		Connection con=null;
		String driver,url,user,password;
		driver="com.mysql.cj.jdbc.Driver";//"com.mysql.cj.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/edb12492";
		user="root";
		password="Tharun@123";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	} 

}