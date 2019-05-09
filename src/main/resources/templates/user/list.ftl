<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>社员</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="/favicon.ico"> <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row" id="listDiv">
        <div class="col-sm-4">
            <div class="contact-box">
                <a href="profile.html">
                    <div class="col-sm-4">
                        <div class="text-center">
                            <img alt="image" class="img-circle m-t-xs img-responsive" src="/img/a2.jpg">
                            <div class="m-t-xs font-bold">CTO</div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <h3><strong>奔波儿灞</strong></h3>
                        <p><i class="fa fa-map-marker"></i> 甘肃·兰州</p>
                        <address>
                            <strong>Baidu, Inc.</strong><br>
                            E-mail:xxx@baidu.com<br>
                            Weibo:<a href="">http://weibo.com/xxx</a><br>
                            <abbr title="Phone">Tel:</abbr> (123) 456-7890
                        </address>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </div>
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
        $('.contact-box').each(function () {
            animationHover(this, 'pulse');
        });
    });
    function init(){
        $.post("/user/getList",function (data) {
            $("#listDiv").empty();
            for(var i = 0;i<data.length;i++ ){
                var html = ' <div class="col-sm-4">'+
                                ' <div class="contact-box">'+
                                    '<a href="profile.html">'+
                                    '<div class="col-sm-4">'+
                                    '<div class="text-center">'+
                                    '<img alt="image" class="img-circle m-t-xs img-responsive" src="/img/a1.jpg">'+
                                    '<div class="m-t-xs font-bold">'+data[i].roler+'</div></div></div>'+
                                    '<div class="col-sm-8">'+
                                    '<h3><strong>'+data[i].username+'&nbsp;'+data[i].gender+'</strong></h3>'+
                                    '<p><i class="fa fa-map-marker"></i> '+data[i].province+'-'+data[i].city+'</p>'+
                                    '<address>'+
                                        '<strong>'+data[i].year+'-'+data[i].college+'-'+data[i].major+'</strong><br>'+
                                        'E-mail:'+data[i].mail+'<br>'+
                                        'Motto:'+data[i].motto+'<br>'+
                                    '</address>'+
                                    '</div><div class="clearfix"></div></a></div></div>';
                $("#listDiv").append(html);
            }
        })
    }
</script>

</body>

</html>
