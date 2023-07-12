package com.tjl.jdbc;

import java.util.ArrayList;

public class Interface {
	public static ArrayList<Integer> getPrice(boolean weight, String airLine, String take_off_IATA, String arrival_IATA){
		String take_off=JDBC.getCountry(take_off_IATA);
		String arrival=JDBC.getCountry(arrival_IATA);
		ArrayList<Integer> Price=new ArrayList<>();
		if(airLine=="AA") {
			String take_off_zone=AA.getZone(take_off);
			String arrival_zone=AA.getZone(arrival);
			Price=AA.getPrice(weight, take_off_zone, arrival_zone);
			System.out.println("True");
		}
		else if(airLine=="AT") {
			String take_off_zone=AT.getZone(take_off);
			String arrival_zone=AT.getZone(arrival);
			Price=AT.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="AY") {
			String take_off_zone=AY.getZone(take_off);
			String arrival_zone=AY.getZone(arrival);
			Price=AY.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="CX") {
			String take_off_zone=CX.getZone(take_off);
			String arrival_zone=CX.getZone(arrival);
			Price=CX.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="IB") {
			String take_off_zone=JK.getZone(take_off);
			String arrival_zone=JK.getZone(arrival);
			Price=JK.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="JL") {
			String take_off_zone=JL.getZone(take_off);
			String arrival_zone=JL.getZone(arrival);
			Price=JL.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="MH") {
			String take_off_zone=MH.getZone(take_off);
			String arrival_zone=MH.getZone(arrival);
			Price=MH.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="QF") {
			String take_off_zone=QF.getZone(take_off);
			String arrival_zone=QF.getZone(arrival);
			Price=QF.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="QR") {
			System.out.println("True");
			String take_off_zone=QR.getZone(take_off);
			String arrival_zone=QR.getZone(arrival);
			Price=QR.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="RJ") {
			String take_off_zone=RJ.getZone(take_off);
			String arrival_zone=RJ.getZone(arrival);
			Price=RJ.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="S7") {
			String take_off_zone=S7.getZone(take_off);
			String arrival_zone=S7.getZone(arrival);
			Price=S7.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="UL") {
			String take_off_zone=UL.getZone(take_off);
			String arrival_zone=UL.getZone(arrival);
			Price=UL.getPrice(weight, take_off_zone, arrival_zone);
		}
		else if(airLine=="BA") {
			int price=100;
			Price.add(price);
		}
		return Price;

	}
}
