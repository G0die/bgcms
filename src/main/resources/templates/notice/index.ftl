<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 时间轴</title>

    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row">
    <div class="col-sm-12">
        <div class="wrapper wrapper-content">
            <div class="row animated fadeInRight">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span>通知列表</span>
                            <span onclick="showAddView()" style="float: right">新增通知<span
                                        class="glyphicon glyphicon-chevron-right" id="arrowLogo"></span></span>
                        </div>
                        <div class="text-center float-e-margins p-md" id="addDiv"
                             style="margin-top: 20px;display: none">
                            <form id="addForm" class="form-horizontal">
                                <div class="form-group col-sm-6">
                                    <label class="col-sm-2 control-label">标题</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="title" id="title">
                                    </div>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label class="col-sm-2 control-label">标签</label>

                                    <div class="col-sm-10">
                                        <select id="optionType" class="form-control" name="bgUuid">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-sm-12" style="    margin-left: -119px;margin-right: 70px;">
                                    <label class="col-sm-2 control-label">内容</label>

                                    <div class="col-sm-10">
                                        <textarea class="form-control" id="content" name="content"
                                                  style="width: 108%;height: 200px"></textarea>
                                    </div>
                                </div>

                            </form>
                            <button onclick="save()" class="btn btn-primary "
                                    style="float: right;margin-right: 71px;margin-bottom: 20px;" type="button"><i
                                        class="fa fa-check"></i>&nbsp;提交
                            </button>
                        </div>
                        <div class="ibox-content" id="ibox-content" style="background-color: #F5F5F5;">

                            <div id="vertical-timeline" class="vertical-container light-timeline">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- 全局js -->
<script src="/js/jquery.min.js?v=2.1.4"></script>
<script src="/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="/js/content.js?v=1.0.0"></script>
<!-- layer javascript -->
<script src="/js/plugins/layer/layer.min.js"></script>

<script>
    var showFalg = false

    function showAddView() {
        console.log("aaaa");
        $("#addDiv").toggle();
        if (showFalg) {
            $('#arrowLogo').removeClass("glyphicon-chevron-down");
            $('#arrowLogo').addClass("glyphicon-chevron-right");
            showFalg = false;
        } else {
            showFalg = true;
            $('#arrowLogo').removeClass("glyphicon-chevron-right");
            $('#arrowLogo').addClass("glyphicon-chevron-down");
        }
    }

    function save() {
        $.post("/notice/save", $('#addForm').serialize(), function (data) {
            layer.msg(data.msg);
            if (data.status == 1) {
                //刷新列表
                //清空表单
                $('#title').val("");
                $('#content').val("");
                initList();
            }
        })
    }

    function initOption() {
        $.post("/boardGame/getNameList", function (data) {
            var html = '<option value="0">全部</option>';
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].uuid + '">' + data[i].name + '</option>';
            }
            $('#optionType').empty()
            $('#optionType').html(html);
        })
    }

    function initList() {
        $.post("/notice/getSeeList", function (data) {
            if (data.status == 1) {
                var list = data.data;
                var html = '';
                for (var i = 0; i < list.length; i++) {
                    html += '<div class="vertical-timeline-block">\n' +
                        '    <div class="vertical-timeline-icon blue-bg">\n' +
                        '        <i class="fa fa-file-text"></i>\n' +
                        '    </div>\n' +

                        '    <div class="vertical-timeline-content">\n' +
                        '        <h2>' + list[i].title + '</h2>\n' +
                        '        <p>' + list[i].content + '</p>\n' +
                        '        <a href="#" class="btn btn-sm btn-success"> 查看详情 </a>\n' +
                        '        <span class="vertical-date">\n' + list[i].creator +
                        '             <br>\n' +
                        '            <small>' + list[i].createtime + '</small>\n' +
                        '        </span>\n' +
                        '    </div>\n' +
                        '</div>';
                }
                $("#vertical-timeline").empty();
                $("#vertical-timeline").html(html);
            } else {
                layer.msg(data.msg);
            }
        })
    }


    $(document).ready(function () {
        initList();
        initOption();
    });
</script>

</body>

</html>
