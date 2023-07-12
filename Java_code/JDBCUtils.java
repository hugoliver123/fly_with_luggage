package com.tjl.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static {
		InputStream IS = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties P = new Properties();
		try {
			P.load(IS);
			 driver = P.getProperty("driver");
			 url = P.getProperty("url");
			 username = P.getProperty("username");
			 password = P.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static Connection getConnection() {
	try {
		return DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
  }

public static void close(Connection conn, Statement statement, ResultSet result) {
	try {
	      if(result != null) {
			result.close();
			result = null;
	      }
	      if(statement != null) {
				statement.close();
				statement = null;
		      }
	      if(conn != null) {
				conn.close();
				conn = null;
		      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  }

