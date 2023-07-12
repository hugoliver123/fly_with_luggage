<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2021/4/28
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.search.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8"><!--显示使用的是中文文字-->
    <title>show price</title>
    <link rel="stylesheet" type="text/css" href="static/css/price_test.css"><!--引用的外部信息的地址-->
</head>
<body>
<div id="dd">
    <!-- 导航栏 -->
    <div class="header">
        <nav>
            <img src="img/logo.jpg" width="258" height="82" style = "float:left;">
            <ul class="nav_ul clear_fix">
                <li class="one"></li>
                <font face="黑体" size=4px >
                    <b><li><a href="e_mail.jsp"><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>Subscribe</a></li>
                        <li><a href="route.html"><span class="glyphicon glyphicon-cutlery" aria-hidden="true"></span>Route</a></li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-camera" aria-hidden="true"></span>HOME</a></li>
                    </b></font>
            </ul>
        </nav>
        <div class="banner"></div>
<%
    ArrayList<TicketDetail> s = (ArrayList<TicketDetail>) request.getAttribute("tickets");
    for(TicketDetail s1:s){
        if(s1.isErr() == true){
            s1.setOverweight_fee(-1);
        }
    }
    String dep = (String) request.getAttribute("dep");
    String des = (String) request.getAttribute("des");
    String date = (String) request.getAttribute("day");
    String currency = (String) request.getAttribute("currency");
    request.setAttribute("tickets",s);
    request.setAttribute("c",currency);

%>
        <%
            String info1 = (String) request.getAttribute("dep");
            String info2 = (String) request.getAttribute("des");
            String info3 = (String) request.getAttribute("day");
            String action = "https://www.skyscanner.net/transport/flights/" + info1 + "/" + info2 + "/" + info3.substring(2,4) + info3.substring(5,7) + info3.substring(8);
        %>
        <div class="cp">
        <h1><%=dep%> to <%=des%> on <%=date%></h1>
        <h4>The flight do not have a clear standard of extra luggage, when the luggage fee shows -1.However, the allowance is still available. Please contact airway service for detail information.</h4>
<c:forEach items="${tickets}"  var="t">
    <div class="flight-box"> <!-- the whole box used  -->
        <div class="flight-row"><!-- 分为两部分，第一部分是机票的信息包括起飞时间，航空公司 “row” 另外一部分是价格 “operate” -->
            <div class="flight-airline"> <!-- 航空公司名称，航班号 -->
                <!-- 		             <img class="airline-logo" src="//pic.c-ctrip.com/flight_intl/airline_logo/40x35/HO.png"><!~~ logo的图片 ~~> -->
                <div class="airline-name"><span id="airlineName" class="">${t.getAirwayFull()}</span></div><!-- 名称 -->
            </div>
            <div class="flight-detail"><!-- 起飞降落信息 -->
                <div class="depart-box"><!-- 起飞 -->
                    <div class="time">${t.getdepTime()}</div><!-- 起飞时间 -->
                </div>
                <div class="arrow-box">
                    <div class="arrow"><img src ="img/arrow.png" width=200px height=30px></div>
                    <div class="transfer">
                        <span class="name">${t.getTransit()}</span>
                    </div>
                </div>
                <div class="arrive-box"><!-- 降落 -->
                    <div class="time">${t.getdesTime()}<span class="day">${t.getDay()}</span></div><!-- 降落时间 后面应该是加的是否加一即第二天 -->
                </div>
            </div>
        </div>
        <div class="flight-operate"> <!-- 第二部分票价的展示和链接即官网的地址 -->
            <div class="flight-price"><!-- 票价的展示 票价+舱位-->
                <div class="price over-size "><span class="price"><dfn>${c}</dfn> ${t.getPrice()}(face price) + ${t.getOverweight_fee()}(luggage with ${t.getLuggage_allowance()}KG free) = ${t.getTotalfee()}(total)</span></div><!-- 票价 -->
                <div class="sub-price-detail"><div class="sub-price-item">${t.getCabin()}</div></div><!-- 舱位 -->
            </div>
            <div class="flight-action"><!-- 订票的按钮 -->
                <div class="btn btn-book"><a href = ${t.getLink()}>BOOK</a></div>
            </div>
        </div>
    </div><!-- 关闭盒子 -->
</c:forEach>
            <h2>Not satisfied with the result ？</h2>
            <h2>OR not found ticket</h2>
            <form action=<%out.print(action);%> method="get">
                <input type="submit" value="continue with Skyscanner">
            </form>
        </div>
<div class="banner"></div>
</div>
</div>
<div class="footer">
    <div class="text footer">FlywithLuggage.Copyright ©2021 | COMP 208---Group 36<br>
        Excess baggage charges are charged in USD, which may cause error
    </div>
</div>
</body>
</html>
