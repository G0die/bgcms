<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - jqGird</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <!-- jqgrid-->
    <link href="/css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

    <style>
        /* Additional style to fix warning dialog position */

        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>桌游列表</h5>
                </div>
                <div class="ibox-content">


                    <div class="jqGrid_wrapper">
                        <table id="listTable"></table>
                        <div id="pagerDiv"></div>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <button type="button" class="btn btn-w-m btn-white" style="margin-left: 15px;"onclick="toAdd()">
                            <span class="glyphicon glyphicon-plus"> 发起众筹
            </button>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="/js/jquery.min.js?v=2.1.4"></script>
<script src="/js/bootstrap.min.js?v=3.3.6"></script>
<!-- Peity -->
<script src="/js/plugins/peity/jquery.peity.min.js"></script>
<!-- jqGrid -->
<script src="/js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
<script src="/js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>
<!-- layer javascript -->
<script src="/js/plugins/layer/layer.min.js"></script>
<script src="/js/plugins/layer/laydate/laydate.js"></script>

<!-- 自定义js -->
<script src="/js/content.js?v=1.0.0"></script>

<!-- Page-Level Scripts -->
<script>
    function toAdd() {
        layer.open({
            type: 1//Page层类型
            , area: ['700px', '300px']
            , title: '添加众筹'
            , shade: 0.6 //遮罩透明度
            , maxmin: true //允许全屏最小化
            , anim: 1 //0-6的动画形式，-1不开启
            , content: $('#alertDiv')
        });
    }

    function addBg() {
        $.post("/boardGame/addBg", $("#addBgForm").serialize(), function (data) {
            layer.msg(data.msg);
            if (data.status == 1) {
                layer.closeAll();
                var dataUrl = "/crowdFunding/toPayView?orderId=" + data.data;
                parent.addMenuTab(dataUrl, "阿里支付", dataUrl)
            }
        })
    }

    function initTable() {
        $.post("/boardGame/test", function (data) {
            // Configuration for jqGrid Example 2
            $("#listTable").jqGrid({
                // url :"/boardGame/test",
                // dataType :'json',
                data: data,
                datatype: "local",
                height: "auto",
                autowidth: true,
                shrinkToFit: true,
                multiselect: false,//是否多选
                altRows: true,//设置为交替行表格,默认为false
                rowNum: 10,
                rowList: [10, 20, 30],
                // ondblClickRow:function(row){
                //     console.log("db");
                //     console.log(row);
                // },
                onSelectRow: function (row) {
                    // console.log("单击");
                    // console.log(row);
                    // openNewPage("/boardGame/details","桌游详情");
                    // window.open("/boardGame/details?uuid="+row);
                    var dataUrl = "/boardGame/details?uuid=" + row;
                    parent.addMenuTab(dataUrl, "桌游详情", "dataIndex")
                },
                colNames: ['uuid', '名字', '类型', '简介', '玩家数量', "价格", '当前持有人', '状态', '浏览次数'],
                colModel: [
                    {
                        name: 'uuid',
                        index: 'uuid',
                        key: true
                        // hidden:true
                    },
                    {
                        name: 'name',
                        index: 'name',
                        editable: true,
                        autowidth: true,
                        search: true
                    },
                    {
                        name: 'type',
                        index: 'type',
                        editable: true,
                        autowidth: true,
                        search: true
                    },
                    {
                        name: 'information',
                        index: 'information',
                        editable: true,
                        autowidth: true
                    },
                    {
                        name: 'maxplayers',
                        index: 'maxplayers',
                        editable: true,
                        autowidth: true,
                        align: "right"
                        // formatter: "number"
                    },
                    {
                        name: 'money',
                        index: 'money',
                        editable: true,
                        autowidth: true,
                        align: "right",
                        sorttype: "float",
                        search: true
                    },
                    {
                        name: 'currentuser',
                        index: 'currentuser',
                        editable: true,
                        autowidth: true,
                        align: "right",
                        search: true
                    },
                    {
                        name: 'status',
                        index: 'status',
                        editable: true,
                        autowidth: true,
                        search: true
                    },
                    {
                        name: 'views',
                        index: 'views',
                        editable: true,
                        autowidth: true,
                        search: true
                    }
                ],
                jsonReader: {
                    root: "rows",
                    page: "page",    // json中代表当前页码的数据
                    total: "total",    // json中代表页码总数的数据
                    records: "records", // json中代表数据行总数的数据
                    repeatitems: false // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。
                },
                pager: "#pagerDiv",
                viewrecords: true,
                caption: "桌游",
                add: true,
                edit: true,
                addtext: 'Add',
                edittext: 'Edit',
                hidegrid: false
            });

            // Add selection
            // $("#listTable").setSelection(4, true);
            // Setup buttons
            $("#listTable").jqGrid('navGrid', '#pagerDiv', {
                edit: true,
                add: true,
                del: true,
                search: true
            }, {
                height: 200,
                reloadAfterSubmit: true
            });
            // Add responsive to jqGrid
            $(window).bind('resize', function () {
                var width = $('.jqGrid_wrapper').width();
                $('#listTable').setGridWidth(width);
            });
        })
    }

    $(document).ready(function () {
        $.jgrid.defaults.styleUI = 'Bootstrap';
        initTable();

    });
</script>

</body>
<div class="col-md-12" id="alertDiv" style="display: none">
    <form id="addBgForm">
        <div class="form-group">
            <label class="col-sm-3 control-label">名字：</label>
            <div class="col-sm-9">
                <input type="text" name="name" class="form-control" placeholder="请输入名字">
                <span class="help-block m-b-none"> </span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">类型：</label>
            <div class="col-sm-9">
                <input type="text" name="type" class="form-control" placeholder="请输入类型">
                <span class="help-block m-b-none"> </span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">玩家数量：</label>
            <div class="col-sm-9">
                <input type="text" name="maxplayers" class="form-control" placeholder="请输入玩家数量">
                <span class="help-block m-b-none"> </span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">金额：</label>
            <div class="col-sm-9">
                <input type="text" name="money" class="form-control" placeholder="请输入金额">
                <span class="help-block m-b-none"> </span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">信息说明：</label>
            <div class="col-sm-8">
                <textarea id="information" name="information" class="form-control" required="" aria-required="true"
                          style="width: 472px;" placeholder="说明:发起众筹者须先付一半费用"></textarea>
            </div>
        </div>
    </form>
    <div style="float: right;margin-right: 15px; margin-top: 5px;">
        <button class="btn btn-primary" onclick="addBg()" style="width: 82px;">保 存</button>
    </div>
</div>
</html>
