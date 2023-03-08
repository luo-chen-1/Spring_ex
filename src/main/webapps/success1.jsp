<%--
  Created by IntelliJ IDEA.
  User: 落尘
  Date: 2023/3/8
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("path",request.getContextPath());
%>
<html>
<head>
    <title>调查成功</title>
</head>
<body>
<fieldset>
    <legend>登录成功</legend>>
    姓名：${student1.name }<br>
    方向：${student1.direction }<br>
    目标：${student1.goal }<br>
</fieldset>
</body>
</html>
