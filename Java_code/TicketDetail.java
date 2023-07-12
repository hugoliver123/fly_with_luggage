package com.search;

public class TicketDetail implements Comparable<TicketDetail> {
    private String time;            //起飞到达时间
    private String airway;          //航空公司， 调用get 方法返回IATA 二子码
    private String during;          //飞行时间，是否中转以及中转地
    private String transit = "   ";         //中转地点，中转时间(可能没有)， 因此有两个构造器。
    private int price;              //价格 英镑
    private String cabin;           //仓位
    private int luggage_allowance;  //免费行李额
    private boolean isWeight;       //是否Weight based。 ture 表示记重
    private int overweight_fee;     //超重费， 在后面调用set 写入， 构造器里面没有。

    public int getOverweight_fee() {
        return overweight_fee;
    }
    public int getTotalfee() {
        int total = overweight_fee+price;
        return total;
    }
    public void setOverweight_fee(int overweight_fee) {
        this.overweight_fee = overweight_fee;
    }

    public String getTime() {
        return time;
    }
    public String getdepTime() {
        String [] times = time.split("-");
        return times[0];
    }
    public String getdesTime() {
        String [] times = time.split("-");
        return times[1];
    }
    public String getDay(){
        String day= "  ";
        String [] days = during.split("h");
        try {
            int d = Integer.parseInt(days[0]);
            d=d/24;
            if(d>0){
                day = "+"+d+"day";
            }
            return day;
        } catch(Exception e){
            return day;
        }
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirwayFull() {
        return this.airway;

    }
    public String getAirway() {
        switch (airway)
        {
            case "Finnair" : return "AY";
            case "Qatar Airways" : return "QR";
            case "Cathay Pacific" : return "CX";
            case "American Airlines" : return "AA";
            case "British Airways" : return "BA";
            case "Iberia" : return "IB";
            case "Japan Airlines" : return "JL";
            case "Royal Jordanian" : return "RJ";
            case "SriLankan Airlines" : return "UL";
            case "Royal Air Maroc" : return "AT";
            case "Qantas Airways" : return "QF";
            case "Malaysia Airlines" : return "MH";
            case "S7 Airlines" : return  "S7";
        }
        return airway;
    }
    public String getLink() { //返回航司官方網站
        switch (airway)
        {
            case "Finnair" : return "https://www.finnair.com";
            case "Qatar Airways" : return "https://www.qatarairways.com/en/homepage.html";
            case "Cathay Pacific" : return "https://www.cathaypacific.com/cx/en_GB.html";
            case "American Airlines" : return "https://www.americanairlines.co.uk/homePage.do?locale=en_GB";
            case "British Airways" : return "https://www.britishairways.com/travel/home/public/en_gb?forceredirect=true/";
            case "Iberia" : return "https://www.iberia.com/us/";
            case "Japan Airlines" : return "https://www.jal.com/index.html";
            case "Royal Jordanian" : return "https://rj.com";
            case "SriLankan Airlines" : return "https://www.srilankan.com";
            case "Royal Air Maroc" : return "https://www.royalairmaroc.com/uk-en";
            case "Qantas Airways" : return "https://www.qantas.com/us/en.html";
            case "Malaysia Airlines" : return "https://www.malaysiaairlines.com/uk/en.html";
            case "S7 Airlines" : return  "https://www.s7.ru/en/";
        }
        return airway;
    }

    public String getDuring() {
        return during;
    }

    public String getTransit() {
        return transit;
    }

    public int getPrice() {
        return price;
    }

    public String getCabin() {
        return cabin;
    }

    public int getLuggage_allowance() {
        return luggage_allowance;
    }

    public boolean getIsWeight() {
        return isWeight;
    }

    @Override
    public int compareTo(TicketDetail o) {
        return new Integer(this.getTotalfee()).compareTo(o.getTotalfee());
    }
    @Override
    public String toString() {
        return "TicketDetail{" +
                "time='" + time + '\'' +
                ", airway='" + airway + '\'' +
                ", during='" + during + '\'' +
                ", transit='" + transit + '\'' +
                ", price=" + price +
                ", cabin='" + cabin + '\'' +
                ", luggage_allowance=" + luggage_allowance +
                ", isWeight=" + isWeight +
                ", Over weight fee=" + overweight_fee +
                '}';
    }
    //有中转构造器
    public TicketDetail(String time, String airway, String during, String transit, int price, String cabin, int luggage_allowance) {
        this.time = time;
        this.airway = airway;
        this.during = during;
        this.transit = transit;
        this.price = price;
        this.cabin = cabin;
        this.luggage_allowance = luggage_allowance;
        if(luggage_allowance==23 || luggage_allowance==32 || luggage_allowance==46 || luggage_allowance==64 || luggage_allowance==69 || luggage_allowance==96){
            this.isWeight = false;
        }
        else {
            this.isWeight = true;
        }
    }
    //直飞构造器
    public TicketDetail(String time, String airway, String during, int price, String cabin, int luggage_allowance) {
        this.time = time;
        this.airway = airway;
        this.during = during;
        this.price = price;
        this.cabin = cabin;
        this.luggage_allowance = luggage_allowance;
        if(luggage_allowance==23 || luggage_allowance==32 || luggage_allowance==46 || luggage_allowance==64 || luggage_allowance==69 || luggage_allowance==96){
            this.isWeight = false;
        }
        else {
            this.isWeight = true;
        }
    }
}
