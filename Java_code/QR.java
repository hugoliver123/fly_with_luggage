package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QR {

	public static String getZone(String country) {
		final String SQL_SEARCH_ZONE = "Select zone from Define_for_QR where country=?";
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
		final String SQL_SEARCH_Weight = "Select " + arrival + " from Price_for_QR where country=?";
		if((take_off.equals("AF")&&arrival.equals("Qatar"))||((take_off.equals("Qatar")&&arrival.equals("AF")))) {
			Price.add(100);// 卡塔尔和非洲之间的航班，每件额外的费率是100美元
		}
		else if(take_off.equals("AA")||take_off.equals("AF")||arrival.equals("AA")||arrival.equals("AF")) {
			Price.add(200); //非洲，阿根廷，巴西，加拿大，美国出发/到大的航班 之后的每件额外行李200美元
			Price.add(52); //超重件52美元
		}
		else {
			try { Connection conn = JDBCUtils.getConnection();
			PreparedStatement prepareStatement = conn.prepareStatement(SQL_SEARCH_Weight);
			prepareStatement.setString(1,take_off);
			ResultSet result  = prepareStatement.executeQuery();
			while (result.next()) {
				int p = result.getInt(arrival);
				Price.add(p);
			}
			JDBCUtils.close(conn,prepareStatement,result);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return Price;
		
	}
		

}
