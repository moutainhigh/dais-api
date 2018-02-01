<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>dais管理界面</title>
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
              <a >虚拟币管理<span class="layui-box">&gt;</span></a>
              <a><cite>虚拟币充值列表</cite></a>
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
                    <th>虚拟币</th>
                    <th>状态</th>
                    <th>交易类型</th>
                    <th>数量</th>
                    <th>手续费</th>
                    <th>充值地址</th>
                    <th>创建时间</th>
                    <th>最后修改时间</th>
                   <%-- <th >操作</th>--%>
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
        <font  style="position: fixed;top: 8%;" color="red">注：此过程不可逆,请谨慎操作</font>
        <input type="hidden" id="operationId"  placeholder="请输入"  class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">钱包密码</label>
            <div class="layui-input-block">
                <input type="text" id="walletpassword"  placeholder="请输入钱包密码"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户姓名</label>
            <div class="layui-input-block">
                <input type="text" id="username"  disabled="disabled"   class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">虚拟币类型</label>
            <div class="layui-input-block">
                <input type="text" id="coinname"  disabled="disabled"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">充值数量</label>
            <div class="layui-input-block">
                <input type="text" id="famont"  disabled="disabled"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">充值手续费</label>
            <div class="layui-input-block">
                <input type="text" id="ffees"  disabled="disabled"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">充值地址</label>
            <div class="layui-input-block">
                <input type="text" id="withdrawaddress"  disabled="disabled"  class="layui-input">
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
            url:"/captualoperation/getCaptualoperationRechargelist",
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
        /*id,coinName,operationId,userid,symbol,createtime,amount,fees,opertionType,status,lastUpdatetime,withdrawVirtualAddress,userName,userPhone;*/
        var s = "";
        /*实名认证状态 3: 审核失败，2：已通过，1：已提交，0：未提交
        "fidentityStatus":1, 证件照审核状态 3: 审核失败，2：已通过，1：已提交，0：未提交*/
        $.each(data,function(v,o){
            s+='<tr ><td>'+(v+1+((start-1)*limit))+'</td>';
            s+='<td style="display: none">'+o.operationId+'</td>';
            s+='<td >'+o.userName+'</td>';
            s+='<td >'+o.userPhone+'</td>';
            s+='<td >'+o.coinName+'</td>';
            s+='<td >'+checkStatus(o.status)+'</td>';
            s+='<td>'+checkOpertionType(o.opertionType)+'</td>';
            s+='<td >'+o.amount+'</td>';
            s+='<td>'+o.fees+'</td>';
            s+='<td>'+o.rechargeVirtualAddress+'</td>';
            s+='<td>'+formatDate(o.createtime)+'</td>';
            s+='<td>'+formatDate(o.lastUpdatetime)+'</td></tr>';
           /* s+='<td><button onclick="edit(this)" class="layui-btn layui-btn-small"><i class="layui-icon">审核</i></button></td></tr>';*/
            /*s += '<td><div class="layui-btn-group"> <button class="layui-btn layui-btn-small" onclick="opration(this,1)"><i class="layui-icon">锁定' +
                    '</i></button><button class="layui-btn layui-btn-small" onclick="opration(this,2)"><i class="layui-icon">取消锁定' +
                    '</i></button><button class="layui-btn layui-btn-small" onclick="edit(this,1)"><i class="layui-icon">审核' +
                    '</i></button><button class="layui-btn layui-btn-small" onclick="opration(this,3)"><i class="layui-icon">取消提现'+
                    '</i></button></div></td></tr>';*/
        });
        if(data.length>0){
            $("#pageDiv").show();
            $("#tableinfo").find("tbody").html(s);
        }else{
            $("#pageDiv").hide();
            $("#tableinfo").find("tbody").html("<tr><td colspan='10' align='center'>暂无数据</td></tr>");
        }
    }

    function checkStatus(authStatus){
        var authStatusMsg = "等待确认";
        if(authStatus == "1"){
            authStatusMsg = "<font color='#4169e1'>等待确认</font>";
        }else if(authStatus == "2"){
            authStatusMsg = "<font color='#009688'>等待确认</font>";
        }else if(authStatus == "3"){
            authStatusMsg = "<font color='green'>充值成功</font>";
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


    function opration(othis,type){
        var msg = "锁定";
        if(type == "1"){
            msg = "锁定";
        }else if(type == "2"){
            msg = "取消锁定";
        }else if(type == "3"){
            msg = "取消提现";
        }
        var obj = $(othis).parent().parent().siblings();
        var uid = $(obj).eq(1).text();
        msgContent = "真的要" + msg + "么？";
        layer.confirm(msgContent, {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(index){
            var id = $(othis).parent().siblings().eq(1).text();
            $.ajax({
                type:"post",
                async:false,
                url:"/captualoperation/goVirtualCapitaloperationChangeStatus",
                data:{uid:uid,type:type},
                success:function(data,status){
                    data=eval("("+data+")");
                    if(data.status == "200"){
                        layer.alert(msg+"成功");
                        getDataPageInfo()
                        toPage();
                    }else{
                        layer.alert(data.msg);
                    }
                },
                error:function(xhr,textStatus){
                    layer.alert(xhr+textStatus);
                }
            });
            layer.close(index);
        });
    }
    var editformHtml = $("#editform").html();
    $("#editform").html("");
    function edit(othis){
        layer.open({
            title: "虚拟币提现审核"
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
        var obj = $(othis).parent().parent().siblings();
        var uid = $(obj).eq(1).text();
        $("#operationId").val($(obj).eq(1).text());
        $("#username").val($(obj).eq(2).text());
        $("#coinname").val($(obj).eq(4).text());
        $("#famont").val($(obj).eq(7).text());
        $("#ffees").val($(obj).eq(8).text());
        $("#withdrawaddress").val($(obj).eq(9).text());
    }

    var flagStatus = "";//用于判断是否自动关闭弹框刷新页面
    function save(){
        var fid = $("#operationId").val();
        var walletpassword = $("#walletpassword").val();
        if(walletpassword == ""){
            showMsgDailog("钱包密码不能为空");
            return false;
        }

        $.ajax({
            type:"post",
            async:false,
            url:"/captualoperation/virtualCapitalOutAudit",
            dataType: 'json',
            //必需设定，后台@RequestBody会根据它做数据反序列化
            //必需把JSON数据以字符串的格式提交
            data:{fid:fid,fpassword:walletpassword},
            success:function(data,status){
                if(data.status == "200"){
                    showMsgDailog("审核成功");
                    total = total+1;//总页数增加
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

    function showImg(othis){
        $(".srcdivimg").find("img").attr('src',$(othis)[0].src);
        layer.open({
            title: "查看证件照"
            ,offset:"auto1"
            ,id: 'system_dailog' //防止重复弹出
            ,content: '<div> '+$(".srcdivimg").html()+'</div>'
            ,btn: false
            ,btnAlign: 'c' //按钮居中
            ,area: ['700', '580px']//宽高
            ,shadeClose: true //开启遮罩关闭
            ,yes: function(){
                layer.closeAll();
            }
        });
    }


</script>
<script src="/resource/js/admin.js"></script>

</body>
</html>