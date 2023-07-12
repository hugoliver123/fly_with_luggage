<%--
  Only for test !!!!!!
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div style="text-align:center"/>
<form action="login" method="post" id="loginForm">
    邮箱：<input type="text" name="email" id="email" value="${messageModel.object.email}"> <br>
    <span class="msg" style="font-size: 12px;color:red">${messageModel.msg}</span><br>
    <button type="button" id ="loginBtn">登记</button>
</form>
</body>
<script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
<script>
    $("#loginBtn").click(function () {
        var email = $("#email").val();
        if(isEmpty(email)){
            $("#msg").html("用户姓名不能为空");
            return;
        }

        var emailText = $("#email").val();
        var emailPatt = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        if(!emailPatt.test(emailText)){
            $("#msg").html("invalid input");
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
