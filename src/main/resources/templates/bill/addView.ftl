<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<div class="col-md-12" id="alertDiv">
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
</body>
</html>

