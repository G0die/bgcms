<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 个人资料</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="/favicon.ico"> <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row animated fadeInRight">
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>${bg.name!}</h5>
                </div>
                <div>
                    <div class="ibox-content no-padding border-left-right">
                        <img alt="image" class="img-responsive" src="/img/profile_big.jpg">
                    </div>
                    <div class="ibox-content profile-content">
                        <h5>类型：${bg.type!}</h5>
                        <h5>玩家数：${bg.maxplayers!}</h5>
                        <h5>当前持有人：${bg.currentUser!}</h5>
                        <#if "${bg.status!''}" != "众筹中">
                        <h5>购买时间：${(bg.buytime?string("yyyy-MM-dd"))!}</h5>
                        <h5>购买金额：${bg.money!}</h5>
                        </#if>
                       <h5> 发起时间：${(bg.applicantiontime?string("yyyy-MM-dd"))!}</h5>
                        <h5>发起者：${bg.applicant!}</h5>
                        推荐理由：<div>${bg.information!}</div>
                        <div class="row m-t-lg">
                            <div class="col-sm-3">
                                <span>${bg.views!}</span>
                                <h5>评分</h5>
                            </div>
                            <div class="col-sm-3">
                                <span id="followSpan">${followNum!""}</span>
                                <h5>关注</h5>
                            </div>
                            <div class="col-sm-3">
                                <span>${bg.lends!}</span>
                                <h5> 出借次数</h5>
                            </div>
                            <div class="col-sm-3">
                                <span>${bg.views!}</span>
                                <h5>浏览次数</h5>
                            </div>
                        </div>
                        <div class="user-button">
                            <div class="row">
                                <div class="col-sm-6">
                                    <button type="button" class="btn btn-w-m btn-block"><i class="fa fa-coffee"></i>借</button>
                                </div>
                                <div class="col-sm-6">
                                    <button type="button" onclick="followOrCancel()" class="btn btn-w-m <#if followFlag> btn-danger<#else> btn-primary</#if>" id="BtnFollow" ><#if followFlag> 取消关注<#else> 关注</#if></button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <button type="button" class="btn btn-w-m btn-block"><i class="fa fa-coffee"></i>流浪图</button>
                                </div>
                                <div class="col-sm-6">
                                    <button type="button" class="btn btn-w-m btn-block"><i class="fa fa-coffee"></i>评分</button>
                                </div>
                            </div>
                            <button>众筹</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div class="ibox ">
                <div class="ibox-content text-center">
                    <h3 class="m-b-xxs">社交示例 02</h3>
                </div>
            </div>
            <div class="media-body">
                <textarea class="form-control" placeholder="填写评论..."></textarea>
            </div>


            <div class="social-feed-separated">

                <div class="social-avatar">
                    <a href="">
                        <img alt="image" src="/img/a5.jpg">
                    </a>
                </div>

                <div class="social-feed-box">

                    <div class="pull-right social-action dropdown">
                        <button data-toggle="dropdown" class="dropdown-toggle btn-white">
                            <i class="fa fa-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu m-t-xs">
                            <li><a href="#">设置</a></li>
                        </ul>
                    </div>

                    <div class="social-avatar">
                        <a href="#">
                            尤小右
                        </a>
                        <small class="text-muted">8月18日</small>
                    </div>
                    <div class="social-body">
                        <p>
                            新技术新概念很多，而且有了新定律：前端开发每18月会难一倍
                        </p>
                        <img src="img/p2.jpg" class="img-responsive">
                        <div class="btn-group">
                            <button class="btn btn-white btn-xs"><i class="fa fa-thumbs-up"></i> 赞</button>
                            <button class="btn btn-white btn-xs"><i class="fa fa-comments"></i> 评论</button>
                            <button class="btn btn-white btn-xs"><i class="fa fa-share"></i> 分享</button>
                        </div>
                    </div>
                    <div class="social-footer">
                        <div class="social-comment">
                            <a href="" class="pull-left">
                                <img alt="image" src="img/a3.jpg">
                            </a>
                            <div class="media-body">
                                <a href="#">
                                    尤小右
                                </a> 图表展示、数据可视化是前端领域一个麻烦且重要的事情，这里推荐了11个JS图表库，各取所需吧
                                <br/>
                                <a href="#" class="small"><i class="fa fa-thumbs-up"></i> 26</a> -
                                <small class="text-muted">8月18日</small>
                                <span class="glyphicon glyphicon-comment" style="float: right"></span>
                            </div>
                        </div>

                        <div class="social-comment">
                            <a href="" class="pull-left">
                                <img alt="image" src="img/a4.jpg">
                            </a>
                            <div class="media-body">
                                <a href="#">
                                    尤小右
                                </a> 看上去不错，如能结合乐曲播放有个动效就更酷了 :z
                                <br/>
                                <a href="#" class="small"><i class="fa fa-thumbs-up"></i> 11</a> -
                                <small class="text-muted">8月18日</small>
                            </div>

                            <div class="social-comment">
                                <a href="" class="pull-left">
                                    <img alt="image" src="img/a7.jpg">
                                </a>
                                <div class="media-body">
                                    <a href="#">
                                        尤小右
                                    </a> 用checkbox + CSS 也能玩出来很多花样，来看看这些有趣的例子吧！
                                    <br/>
                                    <a href="#" class="small"><i class="fa fa-thumbs-up"></i> 11</a> -
                                    <small class="text-muted">8月18日</small>
                                </div>
                            </div>

                            <div class="social-comment">
                                <a href="" class="pull-left">
                                    <img alt="image" src="img/a8.jpg">
                                </a>
                                <div class="media-body">
                                    <textarea class="form-control" placeholder="填写评论..."></textarea>
                                </div>
                            </div>

                        </div>

                        <div class="social-comment">
                            <a href="" class="pull-left">
                                <img alt="image" src="img/a6.jpg">
                            </a>
                            <div class="media-body">
                                <a href="#">
                                    尤小右
                                </a> 有情怀的工程师，赞。
                                <br/>
                                <a href="#" class="small"><i class="fa fa-thumbs-up"></i> 26</a> -
                                <small class="text-muted">8月18日</small>
                            </div>
                        </div>

                        <div class="social-comment">
                            <a href="" class="pull-left">
                                <img alt="image" src="img/a7.jpg">
                            </a>
                            <div class="media-body">
                                <a href="#">
                                    尤小右
                                </a> 几位同学中奖，请将你们的收获地址电话姓名私信给我哦~
                                <br/>
                                <a href="#" class="small"><i class="fa fa-thumbs-up"></i> 26</a> -
                                <small class="text-muted">8月18日</small>
                            </div>
                        </div>

                        <div class="social-comment">
                            <a href="" class="pull-left">
                                <img alt="image" src="img/a3.jpg">
                            </a>
                            <div class="media-body">
                                <textarea class="form-control" placeholder="填写评论..."></textarea>
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
<!-- Peity -->
<script src="/js/plugins/peity/jquery.peity.min.js"></script>
<!-- Peity -->
<script src="/js/demo/peity-demo.js"></script>

<script>
    var followFlag = ${followFlag?c};
    var uuid = '${bg.uuid!}';
    var followNum = ${followNum!0};
    function followOrCancel(){
        $.post("/boardGame/followOrCancel",{followFlag:followFlag,uuid:uuid},function (data) {
            layer.msg(data.msg);
            if(data.status==1){
                if(followFlag){
                    //由关注到取消
                    followNum--;
                    followFlag = false;
                    $("#BtnFollow").text("关注");
                    $("#BtnFollow").removeClass(" btn-danger");
                    $("#BtnFollow").addClass("btn-primary");
                    $("#followSpan").text(followNum);
                }else {
                    //由取消到关注
                    followNum++;
                    followFlag = true;
                    $("#BtnFollow").text("取消关注");
                    $("#BtnFollow").addClass(" btn-danger");
                    $("#BtnFollow").removeClass("btn-primary");
                    $("#followSpan").text(followNum);

                }
            }
        })

    }

    function getComments(){
        $.post("/commment/getCommentList",{objId:uuid},function (data) {
            if(data.status==1){


            }else {
                layer.msg(data.msg);
            }
        })

    }
    function getCommentBodyHtml(data) {
        var html = '';
        for (var i = 0;i<data.length;i++){
            html += ''
        }
        return html
    }
    function getCommentHtml(data,grade,html) {
        for (var i = 0;i<data.length;i++){

        }
    }

</script>

</body>

</html>
