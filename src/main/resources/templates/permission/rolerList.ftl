<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>权限管理</title>
    <link rel="/shortcut icon" href="/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/css/plugins/footable/footable.core.css" rel="stylesheet">

    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>权限管理</h5>
                </div>


                <div class="col-sm-6">
                    <div class="ibox-content">
                        <div class="jqGrid_wrapper">
                            <table id="rolerTable" class="table">
                            </table>
                        </div>
                        <button type="button" class="btn btn-w-m btn-white" style="margin-left: 15px;"
                                onclick="toRoleAdd()">
                            <span class="glyphicon glyphicon-plus"> 添加角色
                        </button>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="ibox-content">
                        <div class="jqGrid_wrapper">
                            <table id="permissionTable" class="table">
                            </table>
                        </div>
                        <button type="button" class="btn btn-w-m btn-white" style="margin-left: 15px;"
                                onclick="toPermissionAdd()">
                            <span class="glyphicon glyphicon-plus"> 添加权限
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-sm-12">

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
        var curSelectRole = '';

        function toPermissionAdd() {
           initPermissionSelect();
            layer.open({
                type: 1//Page层类型
                ,area: ['700px', '300px']
                ,title: '添加账单'
                ,shade: 0.6 //遮罩透明度
                ,maxmin: true //允许全屏最小化
                ,anim: 1 //0-6的动画形式，-1不开启
                ,content: $('#alertAddPermission')
            });
        }

        function toRoleAdd() {
            layer.open({
                type: 1//Page层类型
                , area: ['700px', '300px']
                , title: '添加角色'
                , shade: 0.6 //遮罩透明度
                , maxmin: true //允许全屏最小化
                , anim: 1 //0-6的动画形式，-1不开启
                , content: $('#alertAddRole')
            });
        }


        function initPermissionSelect() {
            $('#curRoleInput').val(curSelectRole);
            $.post("/permission/getAllPermissionList", function (data) {
                var html = '';
                for (var i = 0; i < data.length; i++) {
                    html += '<option value="' + data[i].id + '">' + data[i].permission + '</option>';
                }
                $('#permissionSelect').empty()
                $('#permissionSelect').html(html);
            })
        }

        function initTable() {
            $.post("/permission/getRoleList", function (data) {

                if (data.status == 1) {
                    var html = '<thead><tr> <th>ID</th><th>角色</th><th>操作</th></tr></thead>';
                    html += '<tbody>';
                    var res = data.data;
                    for (var i = 0; i < res.length; i++) {
                        html += '<tr onclick="showPermission(\'' + res[i].id + '\')">' +
                            '<td>' + res[i].id + '</td>' +
                            '<td>' + res[i].role + '</td>' +
                            '<td><a onclick="delRole(\''+res[i].id+'\')">删除</a></td>' +
                            '</tr>'
                    }
                    curSelectRole = curSelectRole == '' ? res[0].id : curSelectRole;
                    showPermission(curSelectRole)
                    html += '</tbody>';
                    $('#rolerTable').empty();
                    $('#rolerTable').html(html)
                }else{
                    layer.msg(data.msg);
                }
            })
        }

        $(document).ready(function () {
            initTable();

        });

        function showPermission(roleId) {
            curSelectRole = roleId;
            $.post("/permission/getPermissionListByRole", {roleId: roleId}, function (data) {

                if (data.status == 1) {
                    var html = '<thead><tr> <th>rpID</th><th>权限</th><th>操作</th></tr></thead>';
                    html += '<tbody>';
                    var res = data.data;
                    for (var i = 0; i < res.length; i++) {
                        html += '<tr>' +
                            '<td>' + res[i].id + '</td>' +
                            '<td>' + res[i].permission + '</td>' +
                            '<td><a onclick="delRP(\''+res[i].id+'\')">删除</a></td>' +
                            '</tr>'
                    }
                    html += '</tbody>';
                    $('#permissionTable').empty()
                    $('#permissionTable').html(html)
                }else {
                    layer.msg(data.msg);
                }
            })
        }

        function delRole(roleId) {
            $.post("/permission/delRole", {roleId:roleId}, function (data) {
                layer.msg(data.msg);
                if (data.status == 1) {
                    initTable()
                }
            })
        }

        function delRP(rpId) {
            $.post("/permission/delRP", {rpId:rpId}, function (data) {
                layer.msg(data.msg);
                if (data.status == 1) {
                    showPermission(curSelectRole);
                }
            })
        }
        function addPermission() {
            $.post("/permission/addRP", $('#addPermissionForm').serialize(), function (data) {
                layer.msg(data.msg);
                if (data.status == 1) {
                    layer.closeAll();
                    showPermission(curSelectRole);
                }
            })
        }

        function addRole() {
            $.post("/permission/addRole", $('#addRoleForm').serialize(), function (data) {
                layer.msg(data.msg);
                if (data.status == 1) {
                    layer.closeAll();
                    initTable();
                }
            })
        }
    </script>
</body>
<div class="col-md-12" id="alertAddPermission" style="display: none">
    <div class="form-group">
        <label class="col-sm-3 control-label">权限名字：</label>
        <div class="col-sm-9">
            <form id="addPermissionForm">
                <select id="permissionSelect" name="permissionId" class="form-control">
                </select>
                <span class="help-block m-b-none"> </span>
                <input type="hidden" name="roleId" id="curRoleInput">
            </form>
        </div>
    </div>
    <div style="float: right;margin-right: 15px; margin-top: 5px;">
        <button class="btn btn-primary" onclick="addPermission()" style="width: 82px;">添加</button>
    </div>
</div>

<div class="col-md-12" id="alertAddRole" style="display: none">
    <div class="form-group">
        <form id="addRoleForm">
            <label class="col-sm-3 control-label">权限名字：</label>
            <div class="col-sm-9">
                <input type="text" name="role" class="form-control" id="roleNameInput" placeholder="请输入名字">
                <span class="help-block m-b-none"> </span>
            </div>
        </form>
    </div>
    <div style="float: right;margin-right: 15px; margin-top: 5px;">
        <button class="btn btn-primary" onclick="addRole()" style="width: 82px;">添加</button>
    </div>
</div>
</html>
