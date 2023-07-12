<%--
  Created by IntelliJ IDEA.
  User: yuanxuteng
  Date: 01/05/2021
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>E-mail subscribe</title>
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
        <b>
          <li><a href="route.html"><span class="glyphicon glyphicon-cutlery" aria-hidden="true"></span>Route</a></li>
          <li><a href="index.html"><span class="glyphicon glyphicon-camera" aria-hidden="true"></span>HOME</a></li>
        </b>
      </ul>
    </nav>
    <div class="banner"></div>
    <div class="cp">
      <form action="login" method="post" id="loginForm">
        <h3>Thanks for your subscribe</h3><br/>
        <h5>We will send a confirmation e-mail to you. Do not test via virtual address.</h5>
        <input type="text" name="email" id="email" value="${messageModel.object.email}" placeholder="Your e-mail"> <br>
        <span class="msg" style="font-size: 12px;color:red">${messageModel.msg}</span><br>
        <button type="button" id ="loginBtn">Submit</button>
      </form>
    </div>
    <div class="banner"></div>
  </div>
</div>
<div class="footer">
  <div class="text footer">FlywithLuggage.Copyright ©2021 | COMP 208---Group 36<br>
  </div>
</div>
</body>
<script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
<script>
  $("#loginBtn").click(function () {
    var email = $("#email").val();
    if(isEmpty(email)){
     alert("input cannot be empty")
      return;
    }

    var emailText = $("#email").val();
    var emailPatt = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if(!emailPatt.test(emailText)){
      alert("invalid input");
      return;
    }

    $("#loginForm").submit();
  });


  function isEmpty(str){
    if(str == null || str.trim()==""){
      return true;
    }
    return false;
  }
</script>
</html>
