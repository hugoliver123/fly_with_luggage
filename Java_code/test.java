package com.search;

public class test {
    public static void main(String[] args){
        String time = "11:46-12:78";
        String [] times = time.split("-");
        for (int i = 0; i < 2; i++) {
            System.out.println(times[i]);
        }
        String y = "9min";
        String [] ys = y.split("h");
        for (int i = 0; i < 1; i++) {
            System.out.println(ys[i]);
        }
        try {
            Integer.parseInt(ys[0]);
        } catch(Exception e){
        }

    }
}
