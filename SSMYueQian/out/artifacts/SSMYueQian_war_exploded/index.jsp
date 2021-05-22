<%--
  Created by IntelliJ IDEA.
  User: Canic
  Date: 2021/5/15
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
    <%--BootStrap美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  <div class="container">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="jumbotron">
          <h1>
            Hello, guys!
          </h1>
          <p>
            欢迎来到本商场
          </p>
          <p>
            <a class="btn btn-primary btn-large" href="${pageContext.request.contextPath}/user/getUser">进入商场</a>
          </p>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
