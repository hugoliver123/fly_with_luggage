package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UL {
	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_UL where country=?";
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
		final String SQL_SEARCH_Piece = "Select price from Price_for_UL where orignal=? and destination=?";
		if(weight==true) {
			try {
				Connection conn = JDBCUtils.getConnection();
				PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
				prepareStatement.setString(1,take_off);
				prepareStatement.setString(2,arrival);
				ResultSet result  = prepareStatement.executeQuery();
				while (result.next()) {
					int price1 = result.getInt("price");
					Price.add(price1);
				}
				JDBCUtils.close(conn,prepareStatement,result);
				return Price;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			int price=0;
			Price.add(price);
			return Price;
		}
		return null;
		}
}
