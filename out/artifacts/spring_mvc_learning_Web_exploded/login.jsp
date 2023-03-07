<%--
  Created by IntelliJ IDEA.
  User: 落尘
  Date: 2023/3/7
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setAttribute("path", request.getContextPath());
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="${path}/login/p" method="post">
        <%--@declare id="username"--%><label for="username">Username:</label>><input type="text" name="username"><br>
            <%--@declare id="password"--%> <label for="password">Password:</label>><input type="password" name="password"><br>
        <input type="submit" name="submit">
    </form>
</body>
</html>
