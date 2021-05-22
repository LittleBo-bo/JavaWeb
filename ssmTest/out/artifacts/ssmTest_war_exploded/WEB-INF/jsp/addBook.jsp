<%--
  Created by IntelliJ IDEA.
  User: Canic
  Date: 2021/5/11
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加书籍</title>

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

            <form class="form-horizontal" role="form" method="post" action="/book/addBook">
                <div class="form-group">
                    <label class="col-sm-2 control-label">书名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="bookName"  required/>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">书籍数量</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="bookCounts" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">描述</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="detail" required/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
