package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RJ {
	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_RJ where country=?";

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
		final String SQL_SEARCH_Piece = "Select Piece from Price_for_RJ where Zone=?";
		final String SQL_SEARCH_Weight = "Select Weight from Price_for_RJ where Zone=?";
		if(weight==false) {
			if(take_off.equals("EU")||arrival.equals("EU")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z1");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece");
						Price.add(price1);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((take_off.equals("ME")&&arrival.equals("ME"))||(take_off.equals("ME")&&arrival.equals("AS"))||(arrival.equals("ME")&&take_off.equals("AS"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z2");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece");
						Price.add(price1);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(take_off.equals("AS")&&arrival.equals("AS")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z3");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece");
						Price.add(price1);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(take_off.equals("LD")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z5");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece");
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
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Piece);
					prepareStatement.setString(1,"Z6");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Piece");
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
		else {
			int price=60;
			Price.add(price);
			return Price;
		}
		return null;
	}
}
