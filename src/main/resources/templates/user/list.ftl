<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>社员</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="search-form" style=" width: 80%;margin-bottom: 20px;">
        <div class="input-group">
            <input id="keyInput" type="text" placeholder="请输入搜索的名字" name="search" class="form-control input-lg">
            <div class="input-group-btn">
                <button class="btn btn-lg btn-primary" onclick="init()">
                    搜索
                </button>
                <span style="width: 5px"></span>
                <button class="btn btn-lg btn-danger" onclick="clearInput()">
                    重置
                </button>
            </div>
        </div>

    </div>
    <div class="row" id="listDiv">

    </div>
</div>

<!-- 全局js -->
<script src="/js/jquery.min.js?v=2.1.4"></script>
<script src="/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="/js/content.js?v=1.0.0"></script>
<script>
    $(document).ready(function () {
        init();

    });

    function init() {
        var keyWord =$("#keyInput").val();
        $.post("/user/getList",{keyWord:keyWord},function (data) {
            $("#listDiv").empty();
            for (var i = 0; i < data.length; i++) {
                var html = ' <div class="col-sm-4">' +
                    ' <div class="contact-box">' +
                    '<a href="profile.html">' +
                    '<div class="col-sm-4">' +
                    '<div class="text-center">' +
                    '<img alt="image" class="img-circle m-t-xs img-responsive" src="/img/a1.jpg">' +
                    '<div class="m-t-xs font-bold">' + data[i].roler + '</div></div></div>' +
                    '<div class="col-sm-8">' +
                    '<h3><strong>' + data[i].username + '&nbsp;' + data[i].gender + '</strong></h3>' +
                    '<p><i class="fa fa-map-marker"></i> ' + data[i].province + '-' + data[i].city + '</p>' +
                    '<address>' +
                    '<strong>' + data[i].year + '-' + data[i].college + '-' + data[i].major + '</strong><br>' +
                    'E-mail:' + data[i].mail + '<br>' +
                    'Motto:' + data[i].motto + '<br>' +
                    '</address>' +
                    '</div><div class="clearfix"></div></a></div></div>';
                $("#listDiv").append(html);
            }
            classHover();
        })
    }
    function clearInput() {
        $("#keyInput").val("");
        init()
    }
    function classHover() {
        $('.contact-box').each(function () {
            animationHover(this, 'pulse');
        });
    }
</script>

</body>

</html>
