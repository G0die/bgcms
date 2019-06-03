<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>众筹列表</title>
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
                    <h5>众筹列表</h5>
                </div>
                <div class="ibox-content">
                    <table id="listTabel" class="table">

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
            $.post("/boardGame/crowdFundingBg", function (data) {
                if (data.status == 1) {
                    var html = '<thead><tr> <th>桌游名称</th><th>类型</th><th>目标金额</th><th>状态</th><th>创建时间</th><th>评分</th><th>关注数</th><th>浏览次数</th></tr></thead>';
                    html += '<tbody>';
                    var res = data.data;
                    for (var i = 0; i < res.length; i++) {
                        html += '<tr onclick="toCrowdFundingDetail(\'' + res[i].uuid + '\')">' +
                            '<td>' + res[i].name + '</td>' +
                            '<td>' + res[i].type + '</td>' +
                            '<td>' + res[i].money + '</td>' +
                            '<td>' + res[i].status + '</td>'+
                            '<td>' + res[i].applicantiontime + '</td>'+
                            '<td>' + res[i].rating + '</td>'+
                            '<td>' + res[i].stars + '</td>'+
                            '<td>' + res[i].views + '</td>';
                        html += '</tr>';

                    }
                    html += '</tbody>';
                    $("#listTabel").empty();
                    $("#listTabel").html(html)

                }else {
                    layer.msg(data.msg);
                }
            })
        }
        function toCrowdFundingDetail(bgId) {
            var dataUrl = "/crowdFunding/crowdFundingDetailView?bgId=" + bgId;
            parent.addMenuTab(dataUrl, "众筹详情表", dataUrl);
        }
        $(function () {
            initList()
        })
    </script>
</body>
</html>
