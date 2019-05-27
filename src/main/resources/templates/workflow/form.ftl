<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>出借表单详情</title>
    <link rel="/shortcut icon" href="/favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/css/plugins/footable/footable.core.css" rel="stylesheet">

    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<style type="text/css">
    .input {
        width: 100%;
    }
</style>
<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>出借表单详情</h5>
                </div>


                <div class="ibox-content">
                    <form id="addWFForm">
                        <#--#f3f3f4-->
                        <table align="center" border="1"  style="width: 80%">
                            <tr>
                                <div class="form-group col-sm-6">
                                    <td><label class="control-label">申请人姓名：</label></td>
                                    <td>
                                        <div class="col-sm-8">
                                            <input type="text" class="input form-control"
                                                   <#if bf??>value="${bf.applicantName!''}"</#if>>
                                            <input type="hidden" <#if bf??>value="${bf.applicant!''}"</#if>
                                                   name="applicant">
                                        </div>
                                    </td>
                                </div>
                                <div class="form-group col-sm-6">
                                    <td><label class="control-label">当前持有人姓名：</label></td>
                                    <td>
                                        <div class="col-sm-8">
                                            <input type="text" class="input form-control"
                                                   <#if bf??>value="${bf.curUserName!''}"</#if>>
                                            <input type="hidden" <#if bf??>value="${bf.curUser!''}"</#if>
                                                   name="curUser">
                                        </div>
                                    </td>
                                </div>
                            </tr>
                            <tr>
                                <div class="form-group">
                                    <td colspan="1"><label class="control-label">桌游名称：</label></td>
                                    <td colspan="3">
                                        <div class="col-sm-8">
                                            <input type="text" style="" class="input form-control"
                                                   <#if bf??>value="${bf.bgName!''}"</#if>>
                                            <input type="hidden" <#if bf??>value="${bf.bgId!''}"</#if> name="bgId">
                                        </div>
                                    </td>
                                </div>

                            </tr>
                            <tr>
                                <div class="form-group">
                                    <td colspan="1" rowspan="4"><label class="control-label">备注：</label></td>
                                    <td colspan="3" rowspan="4">
                                        <div class="col-sm-8">
                                            <textarea type="text" class="input form-control" name="remark"
                                                      <#if bf??>value="${bf.remark!'无备注'}"</#if>></textarea>
                                        </div>
                                    </td>
                                </div>
                            </tr>
                        </table>
                    </form>


                    <div style="text-align: center;font-size: 20px;margin-top: 20px;">
                        <#if formId?exists>
                            <span style="color: #1ab394;">提交</span>-
                            <#if (bf.curStep?exists&&bf.curStep>0)>
                                <span style="color: #1ab394;">${bf.curUserName!''}已同意</span>-
                            </#if>
                            <#if (bf.curStep?exists&&bf.curStep=0)>
                                <span style="color: ##c2c2c2;">等待${bf.curUserName!''}审批</span>-
                            </#if>
                            <#if (bf.curStep?exists&&bf.curStep>1)>
                                <span style="color: #1ab394;">${bf.applicantName!''}已同意</span>-
                            </#if>
                            <#if (bf.curStep?exists&&bf.curStep<2)>
                                <span style="color: ##c2c2c2;">等待${bf.applicantName!''}审批</span>-
                            </#if>
                            <#if (bf.curStep?exists&&bf.curStep=2)>
                                <span style="color: #1ab394;">完成</span>
                            </#if>
                        </#if>
                    </div>


                    <#if (formId?exists&&bf.curStep?exists&&bf.curStep<2&&self?exists&&self)>
                        <div style="margin-top: 20px;margin-left: 450px;">
                            <button type="button" class="btn btn-w-m btn-primary"onclick="approval()">同意</button>
                            <button type="button" class="btn btn-w-m btn-danger" onclick="veto()">否决</button>
                        </div>
                    </#if>
                    <#if !formId?exists>
                        <div style="margin-top: 20px;margin-left: 610px;">
                            <button type="button" class="btn btn-w-m btn-primary" onclick="submit()">提交</button>
                        </div>
                    </#if>
                </div>
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
    var bf = "${bf.remark!''}";
    //申请表uuid
    var formId = "${formId!''}";
    debugger

    function submit() {

        $.post("/workflow/addWF", $('#addWFForm').serialize(), function (data) {
            layer.msg(data.msg);
            if (data.status == 1) {
                parent.closeTab_Active();
            }
        })
    }

    function setOnlyRead() {
        if (formId !== '')
            $(".input").css("disable", "true");
    }

    function approval(){
        $.post("/workflow/approval", {formId:formId}, function (data) {
            layer.msg(data.msg);
            if (data.status == 1) {
                history.go(0);
            }
        })
    }
    function veto(){
        $.post("/workflow/veto", {formId:formId}, function (data) {
            layer.msg(data.msg);
            if (data.status == 1) {
                history.go(0);
            }
        })
    }
    $(function () {
        setOnlyRead();
    })


</script>
</body>
</html>
