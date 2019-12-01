<%--
  Created by IntelliJ IDEA.
  User: MrNPC
  Date: 2019/10/4
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="../resources/lib/kitadmin/css/layui.css">
    <link rel="stylesheet" href="../resources/lib/kitadmin/css/login.css">
</head>

<body>
<div class="kit-login">
    <div class="kit-login-bg"></div>
    <div class="kit-login-wapper">
        <h2 class="kit-login-slogan">欢迎使用 <br> npc.pub</h2>
        <div class="kit-login-form">
            <h4 class="kit-login-title">登录</h4>
            <form class="layui-form">
                <div class="kit-login-row">
                    <div class="kit-login-col">
                        <i class="layui-icon">&#xe612;</i>
                        <span class="kit-login-input">
                <input type="text" name="name" lay-verify="required" placeholder="用户名/邮箱/手机号" />
              </span>
                    </div>
                    <div class="kit-login-col"></div>
                </div>
                <div class="kit-login-row">
                    <div class="kit-login-col">
                        <i class="layui-icon">&#xe64c;</i>
                        <span class="kit-login-input">
                <input type="password" name="password" lay-verify="required" placeholder="密码" />
              </span>
                    </div>
                    <div class="kit-login-col"></div>
                </div>
                <div class="kit-login-row">
                    <div class="kit-login-col">
                        <input type="checkbox" name="rememberMe" title="记住帐号" lay-skin="primary">
                    </div>
                </div>
                <div class="kit-login-row">
                    <button class="layui-btn kit-login-btn"  lay-submit="submit" lay-filter="login">登录</button>
                </div>
                <div class="kit-login-row" style="margin-bottom:0;">
                    <a href="javascript:;" style="color: rgb(153, 153, 153); text-decoration: none; font-size: 13px;" id="forgot">忘记密码</a>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="../resources/lib/kitadmin/polyfill.min.js"></script>
<script src="../resources/lib/layui/layui.js"></script>
<script src="../resources/static/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
    layui.use(['form','layer','jquery'], function () {

        // 操作对象
        var form = layui.form;
        var $ = layui.jquery;
        form.on('submit(login)',function (data) {
            // console.log(data.field);
            $.ajax({
                url:'login',
                data:data.field,
                dataType:'json',
                type:'post',
                success:function (data) {
                    if (data.type == 'success'){
                        layer.msg('登录成功', {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            //do something
                            location.href = "index";
                        });


                    }else{

                        layer.msg('登录名或密码错误');
                    }
                }
            })
            return false;
        })

    });
</script>

</body>
</html>