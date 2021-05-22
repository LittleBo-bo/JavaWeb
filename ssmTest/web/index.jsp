<%--
  Created by IntelliJ IDEA.
  User: Canic
  Date: 2021/5/13
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <head>
      <title>进入书籍展示页面</title>
      <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    </head>
  </head>
  <body>


            <div class="container">
              <div class="row clearfix">
                <div class="col-md-12 column">
                  <div class="jumbotron">
                    <h1>
                      Hello, my friends!
                    </h1>
                    <p>
                     欢迎来到书籍管理系统
                    </p>
                    <p>
                      <a class="btn btn-primary btn-large" href="${pageContext.request.contextPath}/book/allBook">进入书籍页面</a>
                      <a class="btn btn-primary btn-large" href="${pageContext.request.contextPath}/book/SystemIn">进入登录页面</a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
  </body>
</html>
