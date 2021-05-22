<%--
  Created by IntelliJ IDEA.
  User: Canic
  Date: 2021/5/4
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--通过表单上传文件
     get:上传文件大小有限制
     post:上传文件大小没有限制--%>
<form action="${pageContext.request.contextPath}/upload.do" method="post" enctype="multipart/form-data">
  上传用户：<input type="text" name="username"> <br/>
  <p><input type="file" name="file1"></p>
  <p><input type="file" name="file1"></p>
  <p><input type="submit"> | <input type="reset"> </p>
</form>
  </body>
</html>
