<%--
  Created by IntelliJ IDEA.
  User: Canic
  Date: 2021/5/2
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--这里提交的路径需要寻找到项目的路径
  ${pageContext.request.contextPath} 代表当前的项目--%>
  <form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">
  </form>

  </body>
</html>
