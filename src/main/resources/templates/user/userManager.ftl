<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我的申请</title>
    <link rel="/shortcut icon" href="/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/css/plugins/footable/footable.core.css" rel="stylesheet">

    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<style type="text/css">
</style>
<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>用户管理</h5>
                </div>
                <div class="ibox-content">
                    <table id="listTable" class="table">

                    </table>

                </div>
            </div>
        </div>
    </div>
    <!-- 全局js -->
    <script src="/js/jquery.min.js?v=2.1.4"></script>
    <script src="/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="/js/plugins/footable/footable.all.min.js"></script>
    <!-- layer javascript -->
    <script src="/js/plugins/layer/layer.min.js"></script>
    <script src="/js/plugins/layer/laydate/laydate.js"></script>

    <!-- 自定义js -->
    <script src="/js/content.js?v=1.0.0"></script>

    <!-- Page-Level Scripts -->
    <script>
        <#--var bf = ${bf!''};-->
        <#--var uuid = "${uuid!''}";-->

        function initList() {
            $.post("/user/getList", function (res) {
                var html = '<thead><tr> <th>学号</th><th>姓名</th><th>性别</th><th>学院</th><th>专业</th><th>年级</th><th>操作</th></tr></thead>';
                html += '<tbody>';
                for (var i = 0; i < res.length; i++) {
                    // html += '<tr onclick="toFormDetail(\'' + res[i].account + '\')">' +
                    html += '<td>' + res[i].account + '</td>' +
                        '<td>' + res[i].username + '</td>' +
                        '<td>' + res[i].gender + '</td>' +
                        '<td>' + res[i].college + '</td>' +
                        '<td>' + res[i].major + '</td>' +
                        '<td>' + res[i].year + '</td>' +
                        '<td><a onclick="denyLogin(\'' + res[i].uuid + '\')">禁止登陆</a>&nbsp;|&nbsp;<a onclick="initPwd(\'' + res[i].uuid + '\')">重置密码</a>&nbsp;|&nbsp;<a onclick="roleManager(\'' + res[i].uuid + '\')">角色管理</a></td>' +
                        '</tr>'

                }
                html += '</tbody>';
                $("#listTable").empty();
                $("#listTable").html(html)
            })
        }

        function denyLogin(userId) {
            $.post("/user/denyLogin", {userId: userId}, function (data) {
                layer.msg(data.msg);
                if (data.status == 1) {
                    initList()
                }
            })
        }

        function initPwd(userId) {
            $.post("/user/initPwd", {userId: userId}, function (data) {
                layer.msg(data.msg);
                if (data.status == 1) {
                    initList()
                }
            })
        }

        function roleManager(userId) {
            var dataUrl = "/permission/personRole?userId=" + userId;
            parent.addMenuTab(dataUrl, "用户角色管理", dataUrl);
        }

        $(function () {
            initList()
        })


    </script>
</body>
</html>
