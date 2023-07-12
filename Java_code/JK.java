package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JK {
	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_JK where country=?";
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_ZONE);
			prepareStatement.setString(1, country);
			ResultSet result  = prepareStatement.executeQuery();
			while (result.next()) {
				String zone = result.getString("zone");
				return zone;
			}
			JDBCUtils.close(conn,prepareStatement,result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	public static ArrayList<Integer> getPrice(boolean weight, String take_off, String arrival){
		ArrayList<Integer> Price = new ArrayList<>();
		final String SQL_SEARCH_Piece = "Select Piece from Price_for_JK where Zone=?";
		final String SQL_SEARCH_Weight = "Select Weight from Price_for_JK where Zone=?";
		if(weight==true) {
			if(take_off.equals("US")||arrival.equals("US")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"US");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Weight");
						Price.add(price1);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(take_off.equals("AS")||take_off.equals("AA")||take_off.equals("AAF")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"UU");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Weight");
						Price.add(price1);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(take_off.equals("EU")||take_off.equals("ME")||take_off.equals("AF")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"UD");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Weight");
						Price.add(price1);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
		}
}
