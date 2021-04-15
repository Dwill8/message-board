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
    <title>留言界面</title>
</head>
<body>
<div id="container" style="width: 1200px">
    <div id="header" style="background-color:#FFA500">
        <h1>请留言</h1></div></div>
<hr />
<form action="/leaveMessage.do" method="post">
    <table style="margin-left: 40%" border="1">
        <caption>填写留言</caption>
        <tr>
            <th>留言主题</th>
            <th><input type="text" name="title"></th>
        </tr>
        <tr>
            <th>留言内容</th>
            <th><textarea name="content" rows="8" cols="35"></textarea></th>
        </tr>
    </table>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />

</form>
<a href="/message/list.do">返回查看留言</a>

</body>
</html>
