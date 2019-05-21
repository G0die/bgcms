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
            <#--标题-->
            <div class="ibox ">
                <div class="ibox-content text-center">
                    <h3 class="m-b-xxs">最新动态</h3>
                </div>
            </div>
            <#--发布框-->
            <div class="media-body">
                <textarea class="form-control" id="contentInput" placeholder="填写评论..."></textarea>
                <button style="float: right;" onclick="comment()"> 发布</button>
            </div>

            <div class="social-feed-separated" id="commentList">
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
    function comment(){
        var content = $("#contentInput").val();
        $.post("/comment/sendComment",{objId:uuid,content:content},function (data) {
            layer.msg(data.msg);
            if(data.status==1){
                getComments();
                $("#contentInput").val("");
            }
        })
    }
    function getComments(){
        $.post("/comment/getCommentList",{objId:uuid},function (data) {
            if(data.status==1){
                var html = getCommentBodyHtml(data.data)
                $("#commentList").empty();
                $("#commentList").html(html);
            }else {
                layer.msg(data.msg);
            }
        })

    }
    function getCommentBodyHtml(data) {
        var html = '';
        for (var i = 0;i<data.length;i++){
            html += '';
            // 头像
            html += '<div class="social-avatar"><a href=""><img alt="image" src="/img/a5.jpg"></a></div>';
            html += '<div class="social-feed-box">';

            html += '<div class="pull-right social-action dropdown"><button data-toggle="dropdown" class="dropdown-toggle btn-white"> <i class="fa fa-angle-down"></i></button>';
            //删除
            html += '<ul class="dropdown-menu m-t-xs"><li><a href="#">删除</a></li></ul></div>';
            // 发布人+时间
            html += '<div class="social-avatar"><a href="#">'+data[i].fromUserName+'&nbsp;</a><small class="text-muted">'+data[i].createTime+'</small></div>';
            //内容
            html += '<div class="social-body"> <p>'+data[i].content+'</p>';
            //图片
            // html += '<img src="/img/p2.jpg" class="img-responsive">';
            // 赞,评论,分享按钮
            html += '<div class="btn-group">' +
                        '<button class="btn btn-white btn-xs"><i class="fa fa-thumbs-up"></i> 赞</button>' +
                        '<button class="btn btn-white btn-xs" onclick="showComInput(this)"><i class="fa fa-comments" ></i> 评论</button>' +
                        '<button class="btn btn-white btn-xs"><i class="fa fa-share"></i> 分享</button>' +
                      '</div></div>';
            html += '<div class="social-footer">';
            //评论及子评论
            if(data[i].nextData!=null&&data[i].nextData.length>0){
                var temp = getCommentHtml(data[i].nextData);
                html += temp;
            }
            //评论框
            html += '<div class="social-comment" style="display: none">' +
                        '<a href="" class="pull-left">' +
                            '<img alt="image" src="/img/a8.jpg">' +
                        '</a>' +
                        '<div class="media-body">' +
                            '<textarea class="form-control" placeholder="填写评论..."></textarea>' +
                            '<button style="float: right;" onclick="reply(1,\''+data[i].fromUserId+'\',\''+data[i].uuid+'\',this)"> 发布</button>' +
                        '</div>' +
                    '</div>';

            html += '</div>';
            html += '</div>';
        }
        return html
    }
    function getCommentHtml(data) {
        var html = '';
        for (var i = 0;i<data.length;i++){
            //头像
            html += '<div class="social-comment">' +
                        '<a href="" class="pull-left">' +
                          '<img alt="image" src="/img/a3.jpg">' +
                        '</a>';

            html += '<div class="media-body">';
            //作者和内容
            html += '<a href="#"> '+data[i].fromUserName+'</a>'+data[i].content+'';
            if (data[i].grade != 2){
                //评论按钮
                html += '<span class="fa fa-comments" style="float: right" onclick="showReplyInput(this,\''+data[i].grade+'\',\''+data[i].fromUserId+'\',\''+data[i].uuid+'\')"></span>';
            }
            html += '<br/>';
            // 点赞数量
            html += '<a href="#" class="small"><i class="fa fa-thumbs-up"></i> 26</a> -';
            //发布时间
            html += '<small class="text-muted">'+data[i].createTime+'</small>';

            html += '</div>';
            if(data[i].nextData!=null&&data[i].nextData.length>0){
                html += getCommentHtml(data[i].nextData);
            }
            if(data[i].grade != 2){
                //评论框
                html += '<div class="social-comment" style="display: none">' +
                            '<a href="" class="pull-left">' +
                                '<img alt="image" src="/img/a8.jpg">' +
                            '</a>' +
                            '<div class="media-body">' +
                                '<textarea class="form-control" placeholder="填写评论..."></textarea>' +
                                '<input type="hidden" class="lastId">' +
                                '<input type="hidden" class="toUserId">' +
                                '<button style="float: right;" onclick="reply(2,null,null,this)"> 发布</button>' +
                            '</div>' +
                        '</div>';
            }

            html += '</div>';
        }
        return html;
    }
    $(function () {
        getComments();
    })
    function showComInput(obj) {
        $(obj).parent().parent().parent().find(".social-comment").last().toggle();
    }
    function showReplyInput(obj,grade,toId,lastId) {
        if(grade == 1){
            $(obj).parent().parent().find(".social-comment").last().toggle();
            $(obj).parent().parent().find(".social-comment").last().find(".lastId").val(lastId);
            $(obj).parent().parent().find(".social-comment").last().find(".toUserId").val(toId);
        }
        if(grade == 2){
            $(obj).parent().parent().parent().find(".social-comment").last().toggle();
            $(obj).parent().parent().parent().find(".social-comment").last().find(".lastId").val(lastId);
            $(obj).parent().parent().parent().find(".social-comment").last().find(".toUserId").val(toId);
        }

    }

    function reply(grade,toUserId,lastId,obj) {
        var content = $(obj).parent().find(".form-control").val();
        if (toUserId == null ){
            toUserId = $(obj).parent().find(".toUserId").val();
        }
        if (lastId == null ){
            lastId = $(obj).parent().find(".lastId").val();
        }
        $.post("/comment/reply",{objId:uuid,content:content,grade:grade,toUserId:toUserId,lastId:lastId},function (data) {
            layer.msg(data.msg);
            if(data.status==1){
                // console.log($.cookie('username').val());
                $(obj).parent().find(".form-control").val("");
                getComments();
                // $(obj).parent().parent().before(html);
            }
        })
    }

</script>

</body>

</html>
