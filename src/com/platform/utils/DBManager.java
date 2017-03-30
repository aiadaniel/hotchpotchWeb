package com.platform.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBManager {
	
	public static Connection getConnection() throws SQLException {
		return getConnection("hotchpotch", "root", "123456");
	}
	
	public static Connection getConnection(String dbname,String uname,String pw) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/" + dbname + "?characterEncoding=UTF-8";
		DriverManager.registerDriver(new Driver());//use mysql driver
		return DriverManager.getConnection(url, uname, pw);
	}

}
