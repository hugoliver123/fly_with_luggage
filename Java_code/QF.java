package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QF {
	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_QF where country=?";
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
		final String SQL_SEARCH_Piece = "Select Piece from Price_for_MH where Zone=?";
		final String SQL_SEARCH_Weight = "Select Weight from Price_for_MH where Zone=?";
		if(weight==true) {
			if(take_off.equals("NewZeland")||take_off.equals("Papua New Guinea")||arrival.equals("NewZeland")||arrival.equals("Papua New Guinea")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z1");
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
			else if(take_off.equals("Australia")&&arrival.equals("Australia")) {
				int price1=39;
				Price.add(price1);
				return Price;
			}
			else if(take_off.equals("New Caledonia")||arrival.equals("New Caledonia")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z2");
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
			else if((take_off.equals("AS")&&arrival.equals("OC"))||(arrival.equals("AS")&&take_off.equals("OC"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z3");
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
			else if((take_off.equals("AS")&&arrival.equals("LD"))||(arrival.equals("AS")&&take_off.equals("LD"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z4");
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
			else if(take_off.equals("AF")||take_off.equals("EU")||arrival.equals("AF")||arrival.equals("EU")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z5");
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
			else {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z7");
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
		else {
			if(arrival.equals("AA")) {
				int price1 = 200;
				Price.add(price1);
				return Price;
			}
			else if(take_off.equals("AA")) {
				int price1 = 185;
				Price.add(price1);
				return Price;
			}
			else if(take_off.equals("Australia")&&arrival.equals("Australia")) {
				int price1 =200;
				Price.add(price1);
				return Price;
			}
			else {
				int price1 = 100;
				Price.add(price1);
				return Price;
			}
		}
		return null;
	}
}
