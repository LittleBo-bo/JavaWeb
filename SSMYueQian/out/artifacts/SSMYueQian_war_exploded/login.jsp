<%--
  Created by IntelliJ IDEA.
  User: Canic
  Date: 2021/5/17
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
<script>
    function doSubmit() {
        var _account = $("#account").val();
        var _password = $("#password").val();
        $.ajax(
            {
                url:"${pageContext.request.contextPath}/Customer/login",
                type:"post",
                data:{account:_account,password:_password},
                dataType:"json",
                success:function (resp) {
                    console.log(resp);
                }
            }
        )
    }
</script>
</head>
<body>
<link rel="stylesheet" href="css/login.css" />
<div id="row1">
    <div id="titleBlk">
        <div id="logo">佳美商城</div>
        <div id="text">欢迎登录</div>
    </div>
</div>
<div id="row2">
    <div id="priBlk">
        请注意您的帐号安全, 在登录时尽量使用手机号验证,
        以保证你个人的帐号正常的使用, 详情请见
        《<a href="privacy">帐号使用安全细则</a>》。
    </div>
</div>
<div id="row3">
    <div id="loginBlk">
        <div id="loginBox">
            <div id="d1">
                注意不要相信任何要求你转账与汇款的事情, 谨防诈骗。
            </div>
            <div id="d2">
                用户登录
            </div>

            <div id="d3">
                <div style="height:20px;"></div>
                <div class="iptBox">
                    <div>
                        <img src="images/login/user_icon.png" />
                    </div>
                    <input type="text" id="account" placeholder="请输入帐号" >
                </div>
                <div class="iptBox">
                    <div>
                        <img src="images/login/pass_icon.png" />
                    </div>
                    <input type="text" id="password" placeholder="请输入密码">
                </div>

                <div class="btnLogin" onclick="doSubmit()">
                    确认登录
                </div>
            </div>

            <div id="d4">
            </div>
        </div>
    </div>
</div>
<div id="row4"></div>
</body>
</html>
