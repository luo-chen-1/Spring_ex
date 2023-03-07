<%--
  Created by IntelliJ IDEA.
  User: 落尘
  Date: 2023/3/7
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>success</title>
</head>
<body>
    <fieldset>
        <legend>登录成功</legend>>
        用户名：${user.username}<br>
        密码：${user.password}
    </fieldset>
</body>
</html>
