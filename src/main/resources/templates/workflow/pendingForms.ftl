<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>待我审批</title>
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
                    <h5>待我审批</h5>
                </div>
                <div class="ibox-content">
                    <table id="pendingFormsTabel" class="table">

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
        $.post("/workflow/getPendingForms", function (data) {

            if (data.status == 1) {
                var html = '<thead><tr> <th>桌游</th><th>申请人</th><th>当前步骤</th><th>申请时间</th></tr></thead>';
                html += '<tbody>';
                var res = data.data;
                for (var i = 0; i < res.length; i++) {
                    html += '<tr onclick="toFormDetail(\'' + res[i].uuid + '\')">' +
                        '<td>' + res[i].bgName + '</td>' +
                        '<td>' + res[i].applicantName + '</td>' ;
                    if(res[i].curStep=0){
                        html +='<td>等待' + res[i].curUserName + '审核</td>' ;
                    }
                    if(res[i].curStep=1){
                        html +='<td>等待' + res[i].applicantName + '审核</td>' ;
                    }
                    if(res[i].curStep>1){
                        html +='<td>完成</td>' ;
                    }
                    html += '<td>' + res[i].createTime + '</td>' +
                        // '<td><a onclick="delRole(\''+res[i].id+'\')">删除</a></td>' +
                        '</tr>'

                }
                html += '</tbody>';
                $("#pendingFormsTabel").empty();
                $("#pendingFormsTabel").html(html)

            }else {
                layer.msg(data.msg);
            }
        })
    }

    function toFormDetail(formId) {
        var dataUrl = "/workflow/toForm?formId=" + formId;
        parent.addMenuTab(dataUrl, "桌游出借申请表", dataUrl);
    }

    $(function () {
        initList()
    })



</script>
</body>
</html>
