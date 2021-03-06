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
                    <h5>${userName!""}-角色管理</h5>
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
    <!-- Peity -->
    <script src="/js/plugins/peity/jquery.peity.min.js"></script>
    <!-- iCheck -->
    <script src="/js/plugins/iCheck/icheck.min.js"></script>

    <!-- Page-Level Scripts -->
    <script>

        function initList() {
            $.post("/permission/getRoleListByUser", function (data) {
                if (data.status == 1) {
                    var html = '<thead><tr> <th></th><th>角色</th></tr></thead>';
                    html += '<tbody>';
                    var res = data.data;
                    for (var i = 0; i < res.length; i++) {
                        html += '<tr>';
                        if (res[i].flag == -1) {
                            html += '<td><input type="checkbox" class="i-checks" name="input[]" onclick="updUR(\'' + res[i].id + '\',\''+res[i].flag+'\')"></td>';
                        } else {
                            html += '<td><input type="checkbox" checked class="i-checks" name="input[]" onclick="updUR(\'' + res[i].id + '\',\''+res[i].flag+'\')"></td>';
                        }
                        html += '<td>' + res[i].role + '</td>' +
                            '</tr>'
                    }
                    html += '</tbody>';
                    $("#listTable").empty();
                    $("#listTable").html(html)

                } else {
                    layer.msg(data.msg);
                }
            })
        }

        function updUR(roleId,flag) {
            $.post("/permission/updUR", {roleId:roleId,flag:flag}, function (data) {
                layer.msg(data.msg);
                if (data.status == 1) {
                    initTable()
                }
            })
        }

        function toFormDetail(formId) {
            var dataUrl = "/workflow/toForm?formId=" + formId;
            parent.addMenuTab(dataUrl, "桌游出借申请表", dataUrl);
        }

        $(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
            initList()
        })


    </script>
</body>
</html>
