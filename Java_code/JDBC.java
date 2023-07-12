/**
 * 
 */
package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




/**
 * @author panyihong
 *
 */
public class JDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean weight = true;
	      String airLine = "QR";
	      String take_off = "LHR";
	      String arrival = "DOH";
	      ArrayList<Integer> Price=Interface.getPrice(weight, airLine, take_off, arrival);
	      for(int i=0;i<Price.size();i++){
	             System.out.println(Price.get(i));
	      }

//
	}
	public static String getCountry(String IATA) {
		final String SQL_SEARCH_COUNTRY = "Select country_name from data where IATA=?";
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_COUNTRY);
			prepareStatement.setString(1, IATA);
			ResultSet result  = prepareStatement.executeQuery();
			while (result.next()) {
				String country = result.getString("country_name");
				return country;
			}
			JDBCUtils.close(conn,prepareStatement,result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

    
	
	
}
