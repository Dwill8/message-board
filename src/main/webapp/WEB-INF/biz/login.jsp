<%--
  Created by IntelliJ IDEA.
  User: liziheng
  Date: 13/04/2021
  Time: 02:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
</head>
<body>
<div id="container" style="width: 1200px">
    <div id="header" style="background-color:#FFA500">
        <h1>登录</h1></div></div>
<hr />

<form action="/login.do" method="post" class="navbar-form navbar-left" role="submit">
    <div class="form-group">
        <input type="username" name="username" class="form-control" placeholder="账号"><br>
        <input type="password" name="password" class="form-control" placeholder="密码">
    </div>
    <button type="submit" value="Submit" class="btn btn-default">登录</button>
</form>
<br> <a href="/register.do">没有账号？注册一个</a>
</body>
</html>
