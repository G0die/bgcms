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
                        <h2 class="font-bold" id="hMoney"></h2>
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
        <button type="button" class="btn btn-w-m btn-white" style="margin-left: 15px;" onclick="toAdd()">
            <span class="glyphicon glyphicon-plus">添加账单
        </button>
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
<script>

    function toAdd(){
        layer.open({
            type: 1//Page层类型
            ,area: ['700px', '300px']
            ,title: '添加账单'
            ,shade: 0.6 //遮罩透明度
            ,maxmin: true //允许全屏最小化
            ,anim: 1 //0-6的动画形式，-1不开启
            ,content: $('#alertDiv')
        });
    }
    function add(){
        $.post("/bill/add",$("#addBill").serialize(),function(data){
            layer.msg(data.msg);
            if(data.status == 1){
                layer.closeAll();
                window.location.reload();
            }
        })
    }

    function getSurplus(){
        $.post("/bill/getSurplus",function(data){
            $("#hMoney").empty();
            $("#hMoney").html("当前余额: &nbsp;:&nbsp; ¥ "+data.toFixed(2))

        })
    }
    $(document).ready(function () {
        getSurplus();
        $('.footable').footable();
        $('.footable2').footable();

    });
</script>

</body>
<div class="col-md-12" id="alertDiv" style="display: none">
    <form id="addBill">
        <div class="form-group">
            <label class="col-sm-3 control-label">名目：</label>
            <div class="col-sm-9">
                <input type="text" name="title" class="form-control" placeholder="请输入名目">
                <span class="help-block m-b-none"> </span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">金额：</label>
            <div class="col-sm-9">
                <input type="text" name="amount" class="form-control" placeholder="请输入金额">
                <span class="help-block m-b-none"> </span>

            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">时间：</label>
            <div class="col-sm-9">
                <input type="text" name="dotime" id="dotime" class="form-control" >
                <span class="help-block m-b-none"> </span>

            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">备注：</label>
            <div class="col-sm-8">
                <textarea id="remark" name="remark" class="form-control" required="" aria-required="true" style="width: 472px;"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">类型：</label>
            <div class="col-sm-9">
                <label class="radio-inline">
                    <input type="radio" checked="" value="支出" id="" name="type" style="margin-top: 3px;">支出</label>
                <label class="radio-inline">
                    <input type="radio" value="收入" id="" name="type" style="margin-top: 3px;">收入</label>
                <span class="help-block m-b-none"> </span>

            </div>
        </div>
    </form>
    <div style="float: right;margin-right: 15px; margin-top: 5px;">
        <button class="btn btn-primary" onclick="add()" style="width: 82px;">保 存</button>
    </div>
</div>
</html>
