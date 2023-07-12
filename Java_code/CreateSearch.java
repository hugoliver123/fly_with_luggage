package com.search;

import com.tjl.jdbc.Interface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.Collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CreateSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dep = req.getParameter("dep"); // get departure
        String des = req.getParameter("des"); // get destination
        req.setAttribute("dep", dep);
        req.setAttribute("des", des);
        String currency =req.getParameter("currency");
        int weight = Integer.parseInt(req.getParameter("howMany")); // get how many check in luggage
        String date = req.getParameter("date"); // format: "YYYY-MM-DD"
        req.setAttribute("day", date);
        String elite =  req.getParameter("elite"); // get status of elite membership

        System.out.println(dep + "  " + des+ " "+ date  + "  " + weight + "  " + elite); // toString
        System.out.println("true");

        ArrayList<TicketDetail> ticketDetails = null;
        try {
            ticketDetails = getTicketFromWeb(dep, des, date);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } //这里全是爬虫， 价格单位是英镑
        System.out.println(ticketDetails.size());

        for(TicketDetail t1:ticketDetails) {
//            System.out.println(t1.toString()); //show detail of this ticket.
            ArrayList<Integer> Price = Interface.getPrice(t1.getIsWeight(), t1.getAirway(), dep, des); // call to get regulation of overweight fee

            int due_weight = weight - t1.getLuggage_allowance(); //计算应缴重量

            if (due_weight <= 0) { //如果没超重， 设置超重费为0.
                t1.setOverweight_fee(0);
            } else { //超重了
                if (t1.getIsWeight() == true) {// 记重, 这个好说， 直接一个乘法就可以了
                    int after_vip = due_weight - VipAllowance(elite); //我是vip
                    if (after_vip <= 0) {
                        t1.setOverweight_fee(0); //够了没超， 免死金牌
                    } else {
                        t1.setOverweight_fee(Price.get(0) * after_vip); //这家伙怎么这么多东西。
                    }
                } else { //记件
                    if (elite.equals("sapphire") || elite.equals("emerald")) { //我是vip
                        due_weight = due_weight - 23;
                    }

                    if (due_weight <= 0) { //是不是vip都得来
                        t1.setOverweight_fee(0); //够了没超， 又活了
                    } else {
                        if (t1.getAirway().equals("QR")) {
                            t1.setOverweight_fee(PieceBasedQatar(due_weight, Price)); //尊贵的卡航爸爸
                        } else {
                            t1.setOverweight_fee(PieceBaseFee(due_weight, Price)); //我得另外写一个方法了， 这人真的来事，带这么多。
                        }
                    }
                }
            }
//            System.out.println(t1.toString());
        }
        Collections.sort(ticketDetails);
        req.setAttribute("tickets",ticketDetails);
        req.setAttribute("currency",currency);
        req.getRequestDispatcher("currencyConvert").forward(req,resp);
    }

    public static ArrayList<TicketDetail> getTicketFromWeb(String dep, String des, String dep_date) throws IOException, InterruptedException {
        String[] arguments = new String[]{"python3", "/Users/yuanxuteng/Desktop/fly/web/WEB-INF/crewler/crawlar.py", dep, des, dep_date};
        ArrayList<String> ticket = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                ticket.add(line);
                System.out.println(line);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<TicketDetail> ticketDetails = new ArrayList<>();
        for(String tmp: ticket){
            String [] temp = tmp.split("', '");

            if(temp.length==6){
                String time = temp[0].substring(2);
                String airway = temp[1];
                String during = temp[2];
                int price = Integer.parseInt(temp[3].substring(1).replace(",",""));
                String cabin = temp[4];
                int luggage_allowance = Integer.parseInt(temp[5].substring(0,temp[5].length()-2));
                if(luggage_allowance < 3) continue;
                ticketDetails.add(new TicketDetail(time,airway,during,price,cabin,luggage_allowance));
            }
            if(temp.length==7){
                String time = temp[0].substring(2);
                String airway = temp[1];
                String during = temp[2];
                String transit = temp[3];
                int price = Integer.parseInt(temp[4].substring(1).replace(",",""));
                String cabin = temp[5];
                int luggage_allowance = Integer.parseInt(temp[6].substring(0,temp[6].length()-2));
                if(luggage_allowance < 3) continue;
                if(airway.equals("Multiple airlines")) continue; // 多个航司没法算， 没有行李最廉价票不划算， 直接忽略
                ticketDetails.add(new TicketDetail(time,airway,during, transit, price,cabin,luggage_allowance));
            }
        }
        return ticketDetails;
    }

    public static int VipAllowance(String level){
        int allowance = 0;
        switch (level){
            case "NO" : allowance = 0;
            case "Ruby" : allowance = 0;
            case "sapphire" : allowance = 15;
            case "emerald" : allowance=20;
        }
        return allowance;
    }

    public static int PieceBaseFee(int due, ArrayList<Integer> price){
        int due_fee = 0;
        int piece_price [] = new int[3];
        if(price.size()==1){
            piece_price[0] = price.get(0);
            piece_price[1] = price.get(0);
            piece_price[2] = price.get(0);
        }
        else{
            piece_price[0] = price.get(0);
            piece_price[1] = price.get(1);
            piece_price[2] = price.get(1);
        }
        due -=  23; //加第一件
        due_fee += piece_price[0]; // 第一件价格
        if(due <= 0) return due_fee;

        due -=  23; //加第二件
        due_fee += piece_price[1]; // 第二件价格
        if(due <= 0) return due_fee;

        due -=  23; //加第三件
        due_fee += piece_price[2]; // 第三件价格
         return due_fee;  //没有第四件了
    }

    public static int PieceBasedQatar(int due, ArrayList<Integer> price){
        int under32 = price.get(1);
        int addition_one = price.get(0);
        int due_fee = 0;

        due -=  9; //补充第0件到32
        due_fee += under32; // 补充32价格
        if(due <= 0) return due_fee;

        due -= 23; //加第一件
        due_fee += addition_one; // 第一件价格
        if(due <= 0) return due_fee;

        due -=  9; //补充第0件到32
        due_fee += under32; // 补充32价格
        if(due <= 0) return due_fee;

        due -= 23; //加第一件
        due_fee += addition_one; // 第一件价格
        if(due <= 0) return due_fee;

        due -=  9; //补充第0件到32
        due_fee += under32; // 补充32价格
        return due_fee;  //不会更多了

    }
}
