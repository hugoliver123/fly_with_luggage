<%--
  Created by IntelliJ IDEA.
  User: yuanxuteng
  Date: 01/05/2021
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.search.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Unavailable Link</title>
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
        <%
            String action = request.getContextPath() + "/index.html";
        %>
        <div class="banner"></div>
        <div class="cp">
            <h1>404 oops!</h1>
            <h1>Page Not Found</h1>
            <form action=<%=action%> method="get">
                <input type="submit" value="Back HOME">
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
