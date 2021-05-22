<%--
  Created by IntelliJ IDEA.
  User: Canic
  Date: 2021/5/15
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>
               请登录：
            </h3>
            <form class="form-horizontal" role="form" action="" method="post">
                <div class="form-group">
                    <label  class="col-sm-2 control-label">账号名：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="username" />
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox" />Remember me</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">登录</button>
                        <button type="reset" class="btn btn-default">重置</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>
