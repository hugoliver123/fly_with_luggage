package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MH {
	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_MH where country=?";

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
		final String SQL_SEARCH_Piece = "Select Weight from Price_for_MH where Zone=?";
		final String SQL_SEARCH_Weight = "Select Weight from Price_for_MH where Zone=?";
		if(weight==true) {
			try {
				Connection conn = JDBCUtils.getConnection();
				PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
				prepareStatement.setString(1,take_off);
				ResultSet result  = prepareStatement.executeQuery();
				while (result.next()) {
					int price1 = result.getInt("Weight");
					Price.add(price1);
				}
				JDBCUtils.close(conn,prepareStatement,result);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Connection conn = JDBCUtils.getConnection();
				PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
				prepareStatement.setString(1,arrival);
				ResultSet result2  = prepareStatement.executeQuery();
				while (result2.next()) {
					int price2 = result2.getInt("Weight");
					Price.add(price2);
				}
				JDBCUtils.close(conn,prepareStatement,result2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int newtotal = Price.get(0)+Price.get(1);
			ArrayList<Integer> Total=new ArrayList<Integer>();
			Total.add(newtotal);
			return Total;
		}
		return null;
	}
}
