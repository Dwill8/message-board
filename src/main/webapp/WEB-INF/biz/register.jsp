<%--
  Created by IntelliJ IDEA.
  User: liziheng
  Date: 13/04/2021
  Time: 02:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>注册界面</title>
</head>
<body>
<div id="container" style="width: 1200px">
    <div id="header" style="background-color:#FFA500">
        <h1>注册</h1>
    </div>
</div>
<hr />

<form action="/register.do" method="post" class="navbar-form navbar-left" role="submit">
    <div class="form-group">
        <input type="text" name="name" class="form-control" placeholder="设置账号"><br>
        <input type="password" name="password" class="form-control" placeholder="设置密码">
    </div>
    <button type="submit" value="提交" class="btn btn-default">提交</button>
    <button type="reset" value="重置" class="btn btn-default">重置</button>
</form>
<br> <a href="/login.do">已有密码？点此登录</a>

</body>
</html>