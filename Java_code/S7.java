package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class S7 {
	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_S7 where country=?";

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
		if(weight==true) {
			if(take_off.equals("EE")&&arrival.equals("EE")) {
				int price1=42;
				int price2=84;
				Price.add(price1);
				Price.add(price2);
				return Price;
			}
			else {
				int price1=60;
				int price2=120;
				Price.add(price1);
				Price.add(price2);
				return Price;
			}
		}
		else{
			if(take_off.equals("EE")&&arrival.equals("EE")) {
				int price1=42;
				int price2=126;
				Price.add(price1);
				Price.add(price1);
				Price.add(price2);
				return Price;
			}
			else {
				int price1=60;
				int price2=180;
				Price.add(price1);
				Price.add(price1);
				Price.add(price2);
				return Price;
			}
		}
	}
}
