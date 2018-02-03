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
        .layui-form-item {
            margin-bottom: 8px;
            clear: both;
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
              <a><cite>虚拟币类型</cite></a>
            </span>
                <div class="layui-input-inline" style="margin-left: 26%">
                    <input type="text" id="searchValue" style="float:left;width: auto;" placeholder="请输入" autocomplete="off" class="layui-input">
                    <button id="searchButton" style="float:right;" class="layui-btn"><i class="layui-icon" >搜索</i></button>
                </div>
            <table id="tableinfo" class="layui-table" >
                <thead>
                <tr>
                <tr>
                    <th>序号</th>
                    <th >名称</th>
                    <th >简称</th>
                    <th >状态</th>
                    <th >log</th>
                    <th >IP地址</th>
                    <th >端口号</th>
                    <th >充值提现</th>
                    <th >确认次数</th>
                    <th >合约地址</th>
                    <th >创建时间</th>
                    <c:if test="${user_info.roleid < 3}">
                    <th >操作</th>
                    </c:if>
                </thead>
                <tbody></tbody>
            </table>
            <c:if test="${user_info.roleid < 3}">
                <button class="layui-btn layui-btn-small" style="float: right;margin-right: 104px;" onclick="add()"><i class="layui-icon" ></i></button>
            </c:if>
        <%@include file="../page.jsp" %>
    </div>
    <%@include file="../foot.jsp" %>
</div>

<div id="editform" style="display: none; position:relative;">
        <input type="hidden" id="fid"  placeholder="请输入"  class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">币种名称</label>
            <div class="layui-input-block">
                <input type="text" id="fname"  placeholder="请输入币种名称"   class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">币种简称</label>
            <div class="layui-input-block">
                <input type="text" id="fshortname"  placeholder="请输入币种简称"   class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">主链</label>
            <div class="layui-input-block">
                <select id="parentid" class="layui-input">
                    <option value="0">独立链</option>
                    <option value="4">以太坊</option>
                    <option value="1">比特币</option>
                    <option value="2">莱特币</option>
                    <option value="3">BCC</option>
                    <option value="5">以太坊经典</option>
                    <option value="13">Bithome</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">合约地址</label>
            <div class="layui-input-block">
                <input type="text" id="contractAddress"  placeholder="请输入合约地址"   class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">ip</label>
            <div class="layui-input-block">
                <input type="text" id="fip"  placeholder="请输入ip地址"   class="layui-input">
            </div>
        </div><div class="layui-form-item">
        <label class="layui-form-label">端口</label>
        <div class="layui-input-block">
            <input type="text" id="fport"  placeholder="请输入端口号"   class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">accessKey</label>
            <div class="layui-input-block">
                <input type="text" id="faccessKey"  placeholder="请输入钱包服务帐号"   class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">secrtKey</label>
            <div class="layui-input-block">
                <input type="text" id="fsecrtKey"  placeholder="请输入钱包服务密钥"   class="layui-input">
            </div>
        </div>
        <form id="imgform" action="/virtualCoin/uploadpic" method="post" enctype="multipart/form-data">
            <div class="layui-form-item">
                <label class="layui-form-label">log</label>
                <div class="layui-input-block">
                    <input type="file" id="fileimg" name="img"   class="layui-input">
                </div>
            </div>
        </form>

        <div class="layui-form-item">
            <label class="layui-form-label">txurl前缀</label>
            <div class="layui-input-block">
                <input type="text" id="fintrourl"  placeholder="https://etherscan.io/tx/"   class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">确认次数</label>
            <div class="layui-input-block">
                <input type="text" id="confirmTimes"  placeholder="请输入"   class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                状态&nbsp;&nbsp;<input type="radio" name="fstatus" value="1" checked="checked">正常&nbsp;&nbsp;
                <input type="radio" name="fstatus" value="2" >禁用
                &nbsp;&nbsp;&nbsp;&nbsp;是否可以充值提现&nbsp;&nbsp;<input type="radio" name="fiswithdraw" value="true" checked="checked">是&nbsp;&nbsp;
                <input type="radio" name="fiswithdraw" value="false" >否
            </div>
        </div>

        <div class="layui-form-item2">
            <div class="layui-input-block">
                <div class="layui-btn"  onclick="javascript:save();">立即提交</div>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    <div style="display: none;position: fixed;width: 318px; height: 140px; background: #e2e2e2;top: 39%;left: 27%;" id="showMsgDiv">
        <div style="background: #1aa094;color: #f8f8f8; padding-left: 7px;">提示信息</div>
        <div style="margin: 0 auto; display: table;padding-top: 20px;" id="showMsgContent">1111</div>
        <div style="position: fixed;top: 55%;left: 50%;"><button class="layui-btn layui-btn-small" onclick="closeMsgDailog()"><i class="layui-icon">确定</i></button></div>
    </div>
</div>

<script type="text/javascript" src="/resource/js/jquery-1.8.1.min.js"></script>
<script src="/resource/layui/src/layui.js"></script>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
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
            url:"/virtualCoin/getCoinList",
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
            s+='<tr><td>'+(v+1+((start-1)*limit))+'</td>';
            s+='<td style="display: none">'+o.fid+'</td>';
            s+='<td style="display: none">'+o.parentid+'</td>';
            s+='<td >'+o.fname+'</td>';
            s+='<td >'+o.fshortname+'</td>';
            s+='<td >'+checkStatus(o.fstatus)+'</td>';
            s+='<td><img style="width:30px" src='+imgPath+o.furl+'></td>';
            s+='<td>'+o.fip+'</td>';
            s+='<td >'+o.fport+'</td>';
            s+='<td >'+o.fiswithdraw+'</td>';
            s+='<td>'+o.confirmTimes+'</td>';
            s+='<td>'+o.contractAddress+'</td>';
            s+='<td>'+formatDate(o.faddtime)+'</td>';
            s+='<td style="display: none">'+o.faccessKey+'</td>';
            s+='<td style="display: none">'+o.fsecrtKey+'</td>';
            s+='<td style="display: none">'+o.fintrourl+'</td>';
            s+=' <c:if test="${user_info.roleid < 3}"><td><button onclick="edit(this)" class="layui-btn layui-btn-small"><i class="layui-icon"></i></button>' +
                    '<button class="layui-btn layui-btn-small" onclick="del(this)"><i class="layui-icon"></i></button>' +
                    '<button class="layui-btn layui-btn-small" onclick="testConnect(this)"><i class="layui-icon"></i></button></td></c:if></tr>';
        });
        if(data.length>0){
            $("#pageDiv").show();
            $("#tableinfo").find("tbody").html(s);
        }else{
            $("#pageDiv").hide();
            $("#tableinfo").find("tbody").html("<tr><td colspan='10' align='center'>暂无数据</td></tr>");
        }
    }
    function checkStatus(status){
        var statusMsg = "正常";
        if(status == "1"){
            statusMsg = "<font color='#1aa094'>正常</font>";
        }else {
            statusMsg = "<font color='#c12525'>禁用</font>";
        }
        return statusMsg;
    }

    function del(othis){
        layer.confirm('真的删除行么？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(index){
            var id = $(othis).parent().siblings().eq(1).text();
            $.ajax({
                type:"post",
                async:false,
                url:"/virtualCoin/delete",
                data:{id:id},
                success:function(data,status){
                    data=eval("("+data+")");
                    if(data.status == "200"){
                        layer.alert("删除成功");
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
    function testConnect(othis){
        var id = $(othis).parent().siblings().eq(1).text();
        $.ajax({
            type:"post",
            async:false,
            url:"/virtualCoin/testWalletConnect",
            data:{id:id},
            success:function(data,status){
                data=eval("("+data+")");
                if(data.status == "200"){
                    layer.alert(data.data);
                }else{
                    layer.alert(data.msg);
                }
            },
            error:function(xhr,textStatus){
                showMsgDailog(xhr+textStatus);
            }
         });
    }

    var editformHtml = $("#editform").html();
    $("#editform").html("");
    function edit(othis){
        layer.open({
            title: "编辑系统参数"
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
        $("#fid").val($(obj).eq(1).text());
        $("#parentid option[value='"+$(obj).eq(2).text()+"']").attr("selected", "selected");
        $("#fname").val($(obj).eq(3).text());
        $("#fshortname").val($(obj).eq(4).text());
        $("#contractAddress").val($(obj).eq(11).text());
        $("#fip").val($(obj).eq(7).text());
        $("#fport").val($(obj).eq(8).text());
        $("#faccessKey").val($(obj).eq(13).text());
        $("#fsecrtKey").val($(obj).eq(14).text());
        $("#fintrourl").val($(obj).eq(15).text());
        $("#confirmTimes").val($(obj).eq(10).text());
        var fstatus = $(obj).eq(5).text();
        var fiswithdraw = $(obj).eq(9).text()
        if(fstatus == "正常"){
            $("input[name='fstatus']:eq(0)").attr("checked",'checked');
        }else{
            $("input[name='fstatus']:eq(1)").attr("checked",'checked');
        }
        if(fiswithdraw == 'true'){
            $("input[name='fiswithdraw']:eq(0)").attr("checked",'checked');
        }else{
            $("input[name='fiswithdraw']:eq(1)").attr("checked",'checked');
        }

    }
    function add(){
        layer.open({
            title: "新增系统参数"
            ,offset:"auto"
//            ,id: 'system_dailog' //防止重复弹出
            ,content: '<div> '+editformHtml+'</div>'
            ,btn: false
            ,btnAlign: 'c' //按钮居中
            ,area: ['620px', 'auto']//宽高
            ,yes: function(){
                layer.closeAll();
            }
        });
    }

    var flagStatus = "";//用于判断是否自动关闭弹框刷新页面
    var furl =null;
    function save(){
        uploadpic();
        var fid = $("#fid").val();
        var fname = $("#fname").val();
        var fshortname = $("#fshortname").val();
        var parentid = $("#parentid").val();
        var contractAddress = $("#contractAddress").val();
        var fip = $("#fip").val();
        var fport = $("#fport").val();
        var faccessKey = $("#faccessKey").val();
        var fsecrtKey = $("#fsecrtKey").val();
        var fintrourl = $("#fintrourl").val();
        var confirmTimes = $("#confirmTimes").val();
        var fstatus = $("input[name='fstatus']:checked").val();
        var fiswithdraw = $("input[name='fiswithdraw']:checked").val();

        var param = {
            fid:fid,
            fname:fname,
            fshortname:fshortname,
            parentid:parentid,
            contractAddress:contractAddress,
            fip:fip,
            fport:fport,
            faccessKey:faccessKey,
            fsecrtKey:fsecrtKey,
            fintrourl:fintrourl,
            confirmTimes:confirmTimes,
            fstatus:fstatus,
            fiswithdraw:fiswithdraw,
            furl:furl
        };
        $.ajax({
            type:"post",
            async:false,
            url:"/virtualCoin/saveUpdate",
            contentType:"application/json",
            data:JSON.stringify(param),
            success:function(data,status){
                data=eval("("+data+")");
                if(data.status == "200"){
                    showMsgDailog("保存成功");
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


    function uploadpic(){
        if($('#fileimg').val().length == 0){
            return "";
        }
        var form = new FormData(document.getElementById("imgform"));
        $.ajax({
            type:"post",
            async:false,
            url:"/virtualCoin/uploadpic",
            processData:false,
            contentType:false,
            sync:false,
            data:form,
            success:function(data,status){
                data=eval("("+data+")");
                if(data.status == "200"){
                    furl = data.data;
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