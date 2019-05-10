<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - FooTable</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/css/plugins/footable/footable.core.css" rel="stylesheet">

    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title" style="height: 70px">
                    <div class="col-xs-4 text-left">
                        <h2 class="font-bold">社费公示</h2>
                    </div>
                    <div class="col-xs-8 text-right">
                        <span >  </span>
                        <h2 class="font-bold">当前余额 &nbsp;:&nbsp; ¥ 4,232</h2>
                    </div>

                </div>
                <div class="ibox-content">

                    <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="8">
                        <thead>
                        <tr>
                            <th data-toggle="true">名目</th>
                            <th>金额</th>
                            <th>余额</th>
                            <th>使用者</th>
                            <th data-hide="all">备注</th>
                            <th>使用时间</th>

                        </tr>
                        </thead>
                        <tbody id="billTBody">
                        <#if bills?exists>
                            <#list bills!'' as bill>
                                <tr>
                                    <td>${bill.title!''}</td>
                                    <td>${bill.amount!''}</td>
                                    <td>${bill.surplus!''}</td>
                                    <td>${bill.creator!''}</td>
                                    <td>${bill.remark!''}</td>
                                    <td> ${(bill.dotime?string("yyyy-MM-dd"))!}</td>
                                </tr>
                            </#list>
                        </#if>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="5">
                                <ul class="pagination pull-right"></ul>
                            </td>
                        </tr>
                        </tfoot>
                    </table>

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <button type="button" class="btn btn-w-m btn-white">添加账单</button>
    </div>
</div>
<!-- 全局js -->
<script src="/js/jquery.min.js?v=2.1.4"></script>
<script src="/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/js/plugins/footable/footable.all.min.js"></script>
<!-- 自定义js -->
<script src="/js/content.js?v=1.0.0"></script>
<script>
    $(function () {
        initTable()
    })

    function initTable() {
        $.post("/bill/getList", function (data) {
            var html = '';
            for (var i = 0; i < data.length; i++) {
                console.log(data[i].doTime);
                html = '<tr>' +
                    // '<th style="display: none">'+data[i].uuid+'</th>'+
                    '<td>' + data[i].title + '</td>' +
                    '<td>' + data[i].amount + '</td>' +
                    '<td>' + data[i].surplus + '</td>' +
                    '<td>' + data[i].creator + '</td>' +
                    // '<td>'+data[i].doTime+'</td>'+
                    '<td>' + data[i].remark + '</td>' +
                    '<td>2018</td>' +
                    '</tr>'
            }
            // $("#billTBody").empty();
            // $("#billTBody").html(html);
        })
    }

    $(document).ready(function () {
        $('.footable').footable();
        $('.footable2').footable();

    });
</script>


</body>

</html>
