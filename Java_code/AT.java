package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AT {
	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_AT where country=?";
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
		final String SQL_SEARCH_Piece = "Select Piece1,Piece2,Piece3 from Price_for_AT where Zone=?";
		final String SQL_SEARCH_Weight = "Select Weight from Price_for_AT where Zone=?";

		if(weight==false){
			if(take_off.equals("AF")||arrival.equals("AF")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z8");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece1");
						Price.add(price1);
						int price2 = result.getInt("Piece2");
						Price.add(price2);
						int price3 = result.getInt("Piece3");
						Price.add(price3);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((take_off.equals("ME")||take_off.equals("US"))&&(arrival.equals("US")||arrival.equals("AS"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z14");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece1");
						Price.add(price1);
						int price2 = result.getInt("Piece2");
						Price.add(price2);
						int price3 = result.getInt("Piece3");
						Price.add(price3);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(take_off.equals("EU")&&(arrival.equals("AS")||arrival.equals("US"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z6");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece1");
						Price.add(price1);
						int price2 = result.getInt("Piece2");
						Price.add(price2);
						int price3 = result.getInt("Piece3");
						Price.add(price3);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(take_off.equals("EU")||arrival.equals("ME")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z5");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece1");
						Price.add(price1);
						int price2 = result.getInt("Piece2");
						Price.add(price2);
						int price3 = result.getInt("Piece3");
						Price.add(price3);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z3");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece1");
						Price.add(price1);
						int price2 = result.getInt("Piece2");
						Price.add(price2);
						int price3 = result.getInt("Piece3");
						Price.add(price3);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else {
			if(take_off.equals("AF")||take_off.equals("EU")||take_off.equals("ME")) {
				int price = 156;
				Price.add(price);
			}
			else {
				int price = 230;
				Price.add(price);
			}
		}
		return null;
		
	}
}
