package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AA {
	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_AA where country=?";
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
		final String SQL_SEARCH_Price = "Select Weight1,Weight2 from Price_for_AA where Zone=?";
		final String SQL_SEARCH_Piece = "Select Piece from Price_for_AA where Zone=?";
		if (weight == true) {
			if(take_off.equals("AA") || arrival.equals("AA")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Price);
					prepareStatement.setString(1,"AA");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Weight1");
						Price.add(price1);
						int price2 = result.getInt("Weight2");
						Price.add(price2);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (take_off.equals("AB")||arrival.equals("AB")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Price);
					prepareStatement.setString(1,"AB");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Weight1");
						Price.add(price1);
						int price2 = result.getInt("Weight2");
						Price.add(price2);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (take_off.equals("AC")||arrival.equals("AC")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Price);
					prepareStatement.setString(1,"AC");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Weight1");
						Price.add(price1);
						int price2 = result.getInt("Weight2");
						Price.add(price2);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (take_off.equals("AD")||arrival.equals("AD")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Price);
					prepareStatement.setString(1,"AD");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Weight1");
						Price.add(price1);
						int price2 = result.getInt("Weight2");
						Price.add(price2);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (take_off.equals("EU")||arrival.equals("EU")) {
				try {
					Connection conn = JDBCUtils.getConnection();
					PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Price);
					prepareStatement.setString(1,"EU");
					ResultSet result  = prepareStatement.executeQuery();
					while (result.next()) {
						int price1 = result.getInt("Weight1");
						Price.add(price1);
						int price2 = result.getInt("Weight2");
						Price.add(price2);
					}
					JDBCUtils.close(conn,prepareStatement,result);
					return Price;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				int price1 = 100;
				int price2 = 200;
				Price.add(price1);
				Price.add(price2);
				return Price;
			}
		}
		else {
			  if (take_off.equals("AA")||take_off.equals("AB")||take_off.equals("AD")) {
				int price =200;
				Price.add(price);
				return Price;
			  }
			  else {
				  int price =150;
				  Price.add(price);
				  return Price;
			  }
		}


		return null;
		
	}

}
