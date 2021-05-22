<%--
  Created by IntelliJ IDEA.
  User: Canic
  Date: 2021/5/16
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>数据</th>
                    <th>内容</th>

                </tr>
                </thead>
                <tbody>
                <tr class="error">
                    <td>学号</td>
                    <td>${user.password}</td>

                </tr>
                <tr class="success">
                    <td>姓名</td>
                    <td>${user.username}</td>

                </tr>
                <tr class="error">
                    <td>邮件</td>
                    <td>${user.email}</td>
                </tr>
                <tr class="success">
                    <td>年龄</td>
                    <td>${user.age}</td>
                </tr>

                <tr class="error">
                    <td>id</td>
                    <td>${user.id}</td>
                </tr>
                <tr class="success">
                    <td>班级</td>
                    <td>${user.squadName}</td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
