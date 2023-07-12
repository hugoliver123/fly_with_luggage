package com.search;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CurrencyConvert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<TicketDetail> s = (ArrayList<TicketDetail>) req.getAttribute("tickets");
        String curr = (String) req.getAttribute("currency");

        double gbp_rate = 1;
        double usd_rate = 1;
        System.out.println("__________________"+ curr +"________________________");
        try {
            if(!curr.equals("GBP")) gbp_rate = getRateFromWeb("GBP",curr);
            System.out.println(gbp_rate);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            if(!curr.equals("USD")) usd_rate = getRateFromWeb("USD",curr);
            System.out.println(usd_rate);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("____________" + curr);
        for (TicketDetail s1 : s){
            double price_new = (double) s1.getPrice() * gbp_rate;
            s1.setPrice((int) price_new);
            price_new = (double) s1.getOverweight_fee() * usd_rate;
            s1.setOverweight_fee((int) price_new);
            System.out.println(s1.toString());
        }
        req.setAttribute("tickets",s);
        req.setAttribute("currency", curr);
        req.getRequestDispatcher("ticket.jsp").forward(req,resp);
    }


    public static double getRateFromWeb(String from_curr, String to_curr) throws IOException, InterruptedException {
        double rate=0;
        String[] arguments = new String[]{"python3", "/Users/yuanxuteng/Desktop/fly/web/WEB-INF/crewler/currency_convert.py", from_curr, to_curr};
        ArrayList<String> rate1 = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                rate1.add(line);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        rate = Double.parseDouble(rate1.get(1));
        return rate;
    }
}