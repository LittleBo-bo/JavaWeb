<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Canic
  Date: 2021/5/11
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>
    <%--BootStrap美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                查看书籍全部信息
            </h3>
            <nav class="navbar navbar-default" role="navigation">

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="${pageContext.request.contextPath}/book/allBook">查看全部信息</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/book/toAddBook">添加书籍</a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search" action="${pageContext.request.contextPath}/book/queryMoHu" method="post">
                        <div class="form-group" >
                            <input type="text" class="form-control" name="bookName"/>
                        </div> <button type="submit" class="btn btn-default">查询</button>
                        <span style="color: red; font-weight: bold">${error}</span>
                    </form>

                </div>

            </nav>
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>书名</th>
                    <th>数量</th>
                    <th>描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdate?id=${book.bookID}">修改</a>
                            &nbsp; | &nbsp;
                            <a href="${pageContext.request.contextPath}/book/deleteBook?id=${book.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
