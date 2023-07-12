package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CX {
	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_CX where country=?";
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
		final String SQL_SEARCH_Piece = "Select Piece from Price_for_CX where Zone=?";
		final String SQL_SEARCH_Weight = "Select Weight from Price_for_CX where Zone=?";
		if(weight==true) {
			if(take_off.equals("AS")&&arrival.equals("AS")) {
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
			else if((take_off.equals("ME")&&arrival.equals("ZoneSixS"))||(take_off.equals("ZoneSixS")&&arrival.equals("ME"))) {
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
			else if((take_off.equals("AS")&&arrival.equals("ME"))||(take_off.equals("ME")&&arrival.equals("AS"))) {
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
			else if((take_off.equals("AS")&&arrival.equals("ZoneFour"))||(take_off.equals("ZoneFour")&&arrival.equals("AS"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z8");
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
			else if(take_off.equals("ZoneSixS")&&arrival.equals("ZoneSixS")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z9");
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
			else if((take_off.equals("ZoneSixS")&&arrival.equals("ME"))||(take_off.equals("ME")&&arrival.equals("ZoneSixS"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z10");
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
			else if((take_off.equals("ZoneSixS")&&arrival.equals("ZoneFour"))||(take_off.equals("ZoneFour")&&arrival.equals("ZoneSixS"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z11");
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
			else if((take_off.equals("ME")&&arrival.equals("ME"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z12");
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
			else if((take_off.equals("ME")&&arrival.equals("ZoneFour"))||(take_off.equals("ZoneFour")&&arrival.equals("ME"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z13");
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
			else if((take_off.equals("ZoneFour")&&arrival.equals("ZoneFour"))) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
					prepareStatement.setString(1,"Z14");
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
				int price1 = 25;
				Price.add(price1);
			}
		}
		else {
			if((take_off.equals("AS")||take_off.equals("ME")||take_off.equals("ZoneSixS"))&&(arrival.equals("AS")||arrival.equals("ME")||arrival.equals("ZoneSixS"))) {
				int  price1=30;
				Price.add(price1);
				return Price;
			}
			else if(take_off.equals("ZoneFour")||arrival.equals("ZoneFour")) {
				int price1=60;
				Price.add(price1);
				return Price;
			}
			else {
				int price1=150;
				Price.add(price1);
				return Price;
			}
		}
		return null;
	}
}
