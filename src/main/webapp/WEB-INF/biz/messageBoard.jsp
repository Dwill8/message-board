<%@ page import="com.jdbc.test.dao.MessageDao" %>
<%@ page import="com.jdbc.test.servlet.MessageBoardServlet" %>
<%--
  Created by IntelliJ IDEA.
  User: liziheng
  Date: 12/04/2021
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>留言板主界面</title>
</head>

<body>
<div id="container" style="width: 1200px">
    <div id="header" style="background-color:#FFA500">
        <h1>留言查看</h1></div></div>
<hr />
<form action="/message/list.do" method="post">
    <table border="1"></table>
    <tr>
        <th>留言账号</th>
        <th>留言时间</th>
        <th>留言主题</th>
        <th>留言内容</th>
    </tr>
    <tr>
        <td>${messages}</td>
    </tr>
    <nav aria-label="Page navigation">
        <ul class="pagination-lg">
            <form id="messageForm" action="/message/list.do" method="post">
                <input type="hidden" id="page" name="page" value="${page}">
                <input type="hidden" id="last" name="last" value="${last}">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="javascript:void(0)" oneclick="submitMessageForm('first')">首页</a></li>
                <li><a href="javascript:void(0)" oneclick="submitMessageForm('pre')">上一页</a></li>
                <li><a href="javascript:void(0)" >当前第${page}页</a></li>
                <li><a href="javascript:void(0)" oneclick="submitMessageForm('next')">下一页</a></li>
                <li><a href="javascript:void(0)" oneclick="submitMessageForm('last')">尾页</a></li>
            </form>
        </ul>
    </nav>
</form>
<%} if (null != request.getSession().getAttribute("user")) {%>
<a href="/leaveMessagePrompt.do"><button>创建留言</button></a>
<%} else { %>
<a href="/login.do"><button>登录</button></a>后留言
<% } %>


</body>
</html>
