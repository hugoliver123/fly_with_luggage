package com.search;

import com.tjl.jdbc.Interface;

import java.util.ArrayList;

public class GetLuggageFee {
    public static ArrayList<Integer> GetLuggageFee(String dep, String des){
    /* Call pyh's interface to GET price */
    boolean isWeight = true;
    String airLine ="QR";
    ArrayList<Integer> price= Interface.getPrice(isWeight, airLine, dep, des);
        for(int i=0;i<price.size();i++) {
            System.out.println(price.get(i));
        }
    return price;
    }
}

