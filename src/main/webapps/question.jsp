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
    <title>调查问卷</title>
</head>
<style>
  body {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 auto;
    height: 100vh;
    background-color: #f1f1f1;
  }

  input {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 auto;
  }

  body {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 auto;
    height: 100vh;
    background-color: #f1f1f1;
  }

  input {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 auto;
  }

  label {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 auto;
  }

  select {
    margin-bottom: 10px;
    margin-top: 10px;
  }
</style>
<body>
    <form action="${path}/login/p1">
      <label for="name">您的姓名:</label>
      <input type="text" name="name" id="name"><br>
      <label for="lang">您正在学习的技术方向:</label>
      <select name="direction" id="lang">
        <option value="javascript">JavaScript</option>
        <option value="php">PHP</option>
        <option value="java">Java</option>
        <option value="golang">Golang</option>
        <option value="python">Python</option>
        <option value="c#">C#</option>
        <option value="C++">C++</option>
        <option value="erlang">Erlang</option>
    </select>
      <fieldset>
        <legend>您学习的目的</legend>
        <div>
          <input type="checkbox" id="box1" value="就业找工作" name="goal"><label for="box1">就业找工作</label>

          <input type="checkbox" id="box2" value="工作要求" name="goal">  <label for="box1">工作要求</label>

          <input type="checkbox" id="box3" value="兴趣爱好" name="goal"> <label for="box1">兴趣爱好</label>

          <input type="checkbox" value="其他" id="box4" name="goal">  <label for="box1">其他</label>

        </div>
      </fieldset>
      <input type="submit" name="submit">
    </form>
</body>
</html>
