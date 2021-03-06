<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>登录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
   
    <link href="css/bootstrap.min.css" rel="stylesheet"  type="text/css">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet" type="text/css">
    <link href="css/animate.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>
<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>[桌游社综合管理系统]</h1>
                </div>
                <div class="m-b"></div>
                <h4>欢迎使用 <strong>桌游社综合管理系统</strong></h4>
                <ul class="m-b">
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一 更高</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二 更快</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三 更强</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四 </li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                </ul>
                <strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>
            </div>
        </div>
        <div class="col-sm-5">
            <form method="post" id="loginFm">
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">登录到桌游社综合管理系统</p>
                <input type="text" name="account" id="account" class="form-control uname" placeholder="用户名" value="admin" />
                <input type="password" name="pwd" id="pwd" class="form-control pword m-b" placeholder="密码" value="admin" />
                <a href="">忘记密码了？</a>
            </form>
            <button class="btn btn-success btn-block" onclick="login()">登录</button>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 中原工学院 桌游社
        </div>
    </div>
</div>
</body>
<script src="js/jquery/jquery-1.8.3.js"></script>
<!-- Toastr script -->
<script src="js/plugins/toastr/toastr.min.js"></script>
<script>
    function login() {
        console.log("aaa");
        $.post("/checkLogin", $("#loginFm").serialize(), function (data) {

            console.log(data);
            if (data == 1) {
                window.location.href="/index";
            }
            if(data == -1) {
                alert("账号密码错误");
            }
            if(data == 0) {
                alert("用户名不存在");
            }
        })

    }
</script>
</html>
