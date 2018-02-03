<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>钱包管理界面</title>
    <link rel="stylesheet" href="/resource/layui/src/css/layui.css">
    <style>
        .layui-btn-small i{
            font-size: 12px !important;
            margin-right: 0px;
        }
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
        <%@include file="../main.jsp" %>
        <div class="layui-body">
            <!-- 内容主体区域 -->
            <br/>&nbsp;&nbsp;
            <span class="layui-breadcrumb" style="visibility: visible;">
              <a >首页<span class="layui-box">&gt;</span></a>
              <a >聊天室<span class="layui-box">&gt;</span></a>
              <a><cite>消息列表</cite></a>
            </span>
                <div class="layui-input-inline" style="margin-left: 26%">
                    <input type="text" id="searchValue" style="float:left;width: auto;" placeholder="请输入" autocomplete="off" class="layui-input">
                    <button id="searchButton" style="float:right;" class="layui-btn"><i class="layui-icon" >搜索</i></button>
                </div>
            <table id="tableinfo" class="layui-table" >
                <thead>
                <tr>
                    <th >序号</th>
                    <th>会员姓名</th>
                    <th>会员手机号</th>
                    <th>会员昵称</th>
                    <th>头像</th>
                    <th>消息类型</th>
                    <th>消息内容</th>
                    <th>创建时间</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        <%@include file="../page.jsp" %>
    </div>
    <%@include file="../foot.jsp" %>
</div>

<%--用作信息编辑增加修改等--%>
<div id="editform" style="display: none; position:relative;">
    <form class="layui-form" >
        <input type="hidden" id="fid"  placeholder="请输入"  class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">用户姓名</label>
            <div class="layui-input-block">
                <input type="text" id="username"  disabled="disabled"   class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">虚拟币</label>
            <div class="layui-input-block">
                <input type="text" id="coinname"  disabled="disabled"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">资产总值</label>
            <div class="layui-input-block">
                <input type="text" id="total"  placeholder="请输入总产总额"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">冻结资金</label>
            <div class="layui-input-block">
                <input type="text" id="frozen"  placeholder="请输入冻结资金"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item2">
            <div class="layui-input-block">
                <div class="layui-btn"  onclick="javascript:save();">立即提交</div>
                <div onclick="javascript:layer.closeAll();" class="layui-btn layui-btn-primary">取消</div>
            </div>
        </div>
    </form>
    <div style="display: none;position: fixed;width: 318px; height: 140px; background: #e2e2e2;top: 32%;left: 27%;" id="showMsgDiv">
        <div style="background: #1aa094;color: #f8f8f8; padding-left: 7px;">提示信息</div>
        <div style="margin: 0 auto; display: table;padding-top: 20px;" id="showMsgContent">1111</div>
        <div style="position: fixed;top: 56%;left: 50%;"><button class="layui-btn layui-btn-small" onclick="closeMsgDailog()"><i class="layui-icon">确定</i></button></div>
    </div>
</div>

<%--用作图片显示--%>
<div style=" display: none; margin: 0 auto" class="srcdivimg">
    <img width="660px" height="480px" src="" />
</div>

<script type="text/javascript" src="/resource/js/jquery-1.8.1.min.js"></script>
<script src="/resource/layui/src/layui.js"></script>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });

</script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){

    });
</script>
<script type="text/javascript">
    $(document).ready(function(){
        //ajax请求后台数据
        getDataPageInfo();
        //点击搜索时 搜索数据
        $("#searchButton").click(function(){
            getDataPageInfo();
            toPage();
        })
        toPage();
    });
    //分页参数设置 这些全局变量关系到分页的功能
    var start = 1;
    var limit = 10;
    var total = 0;
    //ajax请求后台数据
    function getDataPageInfo(){
        $.ajax({
            type:"post",
            async:false,
            url:"/chatroom/getMsglist",
            data:{start:start, limit:limit,search:$("#searchValue").val()},
            success:function(data,status){
                data=eval("("+data+")").data;
                getSysParamInfo(data.list);
                total = data.total;
            }
        });
    }
    function toPage(){
        layui.use(['laypage', 'layer'], function(){
            var laypage = layui.laypage
                    ,layer = layui.layer;
            laypage.render({
                elem: 'pageDiv'
                ,count: total
                ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
                ,jump: function(obj, first){
                    limit = obj.limit;
                    start = obj.curr;
                    if(!first){ //一定要加此判断，否则初始时会无限刷新
                        getDataPageInfo();//一定要把翻页的ajax请求放到这里，不然会请求两次。
                    }
                }
            });
        });
    };
    function getSysParamInfo(data){
        var s = "";
        var imgPath = "http://p-dais.oss-cn-hangzhou.aliyuncs.com/";
        $.each(data,function(v,o){
            s+='<tr ><td>'+(v+1+((start-1)*limit))+'</td>';
            s+='<td style="display: none">'+o.id+'</td>';
            s+='<td >'+o.freal_name+'</td>';
            s+='<td >'+o.flogin_name+'</td>';
            s+='<td >'+o.fnick_name+'</td>';
            s+='<td ><img style="width:30px"  src='+imgPath+o.fhead_img_url+'></td>';
            s+='<td >'+checkMsgType(o.msg_type)+'</td>';
            s+='<td width="30%"><input style="width: 90%;height: 28px;border: #eee;" value='+o.content+'/></td>';
            s+='<td>'+formatDate(o.createtime)+'</td></tr>';
        });
        if(data.length>0){
            $("#pageDiv").show();
            $("#tableinfo").find("tbody").html(s);
        }else{
            $("#pageDiv").hide();
            $("#tableinfo").find("tbody").html("<tr><td colspan='10' align='center'>暂无数据</td></tr>");
        }
    }

    function checkMsgType(type) {
        var msg = "普通消息";
        if(type == 2){
            msg = "群聊红包";
        }
        return msg;
    }

    function checkStatus(authStatus){
        var authStatusMsg = "等待提现";
        if(authStatus == "1"){
            authStatusMsg = "<font color='#4169e1'>等待提现</font>";
        }else if(authStatus == "2"){
            authStatusMsg = "<font color='#009688'>正在处理</font>";
        }else if(authStatus == "3"){
            authStatusMsg = "<font color='green'>提现成功</font>";
        }else if(authStatus == "5"){
            authStatusMsg = "<font color='red'>取消提现</font>";
        }
        return authStatusMsg;
    }
    function checkOpertionType(type){
        var typeMsg = "提现";
        if(type == "2"){
            typeMsg = "提现";
        }else if(type == "1"){
            typeMsg = "充值";
        }
        return typeMsg;
    }


    var editformHtml = $("#editform").html();
    $("#editform").html("");
    function edit(othis){
        layer.open({
            title: "虚拟币资金修改"
            ,offset:"auto1"
            ,id: 'system_dailog' //防止重复弹出
            ,content: '<div> '+editformHtml+'</div>'
            ,btn: false
            ,btnAlign: 'c' //按钮居中
            ,area: ['620px', 'auto']//宽高
            ,shadeClose: true //开启遮罩关闭
            ,yes: function(){
                layer.closeAll();
            }
        });
        var obj = $(othis).parent().siblings();
        var uid = $(obj).eq(1).text();
        $("#fid").val($(obj).eq(1).text());
        $("#username").val($(obj).eq(2).text());
        $("#coinname").val($(obj).eq(5).text());
        $("#total").val($(obj).eq(6).text());
        $("#frozen").val($(obj).eq(7).text());
    }

    var flagStatus = "";//用于判断是否自动关闭弹框刷新页面
    function save(){
        var total = $("#total").val();
        var frozen = $("#frozen").val();
        if( total== ""){
            showMsgDailog("资产为必填项");
            return false;
        }
        if(frozen == ""){
            showMsgDailog("冻结资金为必填项");
            return false;
        }
        var param = {
            fid:$("#fid").val(),
            ftotal:total,
            ffrozen:frozen
        }
        var fid = $("#fid").val();
        $.ajax({
            type:"post",
            async:false,
            url:"/wallet/updateWallet",
            contentType:"application/json",
            dataType: 'json',
            //必需设定，后台@RequestBody会根据它做数据反序列化
            //必需把JSON数据以字符串的格式提交
            data:JSON.stringify(param),
            success:function(data,status){
                if(data.status == "200"){
                    showMsgDailog("修改成功");
                    getDataPageInfo();
                    flagStatus = status;
                }else{
                    showMsgDailog(data.msg);
                }
            },
            error:function(xhr,textStatus){
                showMsgDailog(xhr+textStatus);
            }
        });
    }
    function alert(msg){
        layer.alert(msg, {
            skin: 'layui-layer-molv' //样式类
        });
    }
    function showMsgDailog(msg){
        $("#showMsgDiv").toggle();
        $("#showMsgContent").text(msg);
    }
    function closeMsgDailog(){
        $("#showMsgDiv").toggle();
        if(flagStatus == "success"){
            layer.closeAll();
            getDataPageInfo();
            toPage();
        }
    }


</script>
<script src="/resource/js/admin.js"></script>

</body>
</html>