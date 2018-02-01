<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>dais管理界面</title>
    <link rel="stylesheet" href="/resource/layui/src/css/layui.css">
    <link rel="stylesheet" href="/resource/layui/dist/css/layui.css">
    <style>
        .srcStyle{
            width: 42px;background: rgba(26, 160, 148, 0.18);height: 30px;
        }
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
              <a >用户管理<span class="layui-box">&gt;</span></a>
              <a><cite>用户列表</cite></a>
            </span>
                <div class="layui-input-inline" style="margin-left: 26%">
                    <input type="text" id="searchValue" style="float:left;width: auto;" placeholder="请输入" autocomplete="off" class="layui-input">
                    <button id="searchButton" style="float:right;" class="layui-btn"><i class="layui-icon" >搜索</i></button>
                </div>
            <table id="tableinfo" class="layui-table" >
                <thead>
                <tr>
                    <th >序号</th>
                    <th >会员登陆名</th>
                    <th >头像</th>
                    <th >昵称</th>
                    <th >证件信息审核</th>
                    <th >证件照片审核</th>
                    <th >真实姓名</th>
                    <th >证件类型</th>
                    <th >证件号码</th>
                    <th >手持证件照</th>
                    <th >注册时间</th>
                    <c:if test="${user_info.roleid < 3}">
                        <th >操作</th>
                    </c:if>

                </tr>
                </thead>
                <tbody></tbody>
            </table>
            <%--<button class="layui-btn layui-btn-small" style="float: right;margin-right: 104px;" onclick="add()"><i class="layui-icon" ></i></button>--%>
        <%@include file="../page.jsp" %>
    </div>
    <%@include file="../foot.jsp" %>
</div>

<%--用作信息编辑增加修改等--%>
<div id="authform" style="display: none; position:relative;">
    <form>
        <input type="hidden" id="fid" />
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">实名认证</label>
                    <select id="authStatus" style="width: 160px;height: 33px;">
                        <option value="">请选择</option>
                        <option value="2">通过认证</option>
                        <option value="3">认证失败</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">手持身份证</label>
                    <select id="fidentityStatus" style="width: 160px;height: 33px;">
                        <option value="">请选择</option>
                        <option value="2">通过认证</option>
                        <option value="3">认证失败</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">失败原因</label>
                <div class="layui-input-block">
                    <textarea placeholder="审核失败时务必填写原因,该信息将直接在用户端显示" id="errorMsg" class="layui-textarea"></textarea>
                </div>
            </div>
        <div class="layui-form-item2">
            <div class="layui-input-block">
                <div class="layui-btn"  onclick="javascript:saveauth();">立即提交</div>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <div style="display: none;position: fixed;width: 318px; height: 140px; background: #e2e2e2;top: 27%;left: 27%;" id="showMsgDiv">
        <div style="background: #1aa094;color: #f8f8f8; padding-left: 7px;">提示信息</div>
        <div style="margin: 0 auto; display: table;padding-top: 20px;" id="showMsgContent">1111</div>
        <div style="position: fixed;top: 57%;left: 50%;"><button class="layui-btn layui-btn-small" onclick="closeMsgDailog()"><i class="layui-icon">确定</i></button></div>
    </div>
</div>
<div id="editform" style="display: none; position:relative;">
    <form>
        <input type="hidden" id="editfid" />
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" id="realName"  placeholder="请输入姓名"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-block">
                <input type="text" id="nickName"  placeholder="请输入昵称"   class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号码</label>
            <div class="layui-input-block">
                <input type="text" id="identityNo"  placeholder="请输入证件号码"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" >
            <div class="layui-inline" style="float: left">
                <label class="layui-form-label">禁言时长</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="gagTime" placeholder="输入正整数">
                </div>
            </div>
            <select style="height: 38px" id="gagTimeType">
                <option value="m">分钟</option>
                <option value="h">小时</option>
                <option value="d">天</option>
            </select>
       </div>

        <div class="layui-form-item2">
            <div class="layui-input-block">
                <div class="layui-btn"  onclick="javascript:save();">立即提交</div>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <div style="display: none;position: fixed;width: 318px; height: 140px; background: #e2e2e2;top: 27%;left: 27%;" id="editshowMsgDiv">
        <div style="background: #1aa094;color: #f8f8f8; padding-left: 7px;">提示信息</div>
        <div style="margin: 0 auto; display: table;padding-top: 20px;" id="editshowMsgContent">1111</div>
        <div style="position: fixed;top: 57%;left: 50%;"><button class="layui-btn layui-btn-small" onclick="closeMsgDailog()"><i class="layui-icon">确定</i></button></div>
    </div>
</div>

<%--用作图片显示--%>
<div style=" display: none; margin: 0 auto" class="srcdivimg">
    <img width="600px" height="480px" src="" />
</div>

<script type="text/javascript" src="/resource/js/jquery-1.8.1.min.js"></script>
<script src="/resource/layui/src/layui.js"></script>
<%--<script src="/resource/layui/dist/layui.js"></script>--%>

<script>
    layui.use('element', function(){
        var element = layui.element;

    });
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
            url:"/user/getUserList",
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
        /*实名认证状态 3: 审核失败，2：已通过，1：已提交，0：未提交
        "fidentityStatus":1, 证件照审核状态 3: 审核失败，2：已通过，1：已提交，0：未提交*/
        var imgPath = "http://p-dais.oss-cn-hangzhou.aliyuncs.com/";

        $.each(data,function(v,o){
            s+='<tr ><td>'+(v+1+((start-1)*limit))+'</td>';
            s+='<td style="display: none">'+o.fid+'</td>';
            s+='<td >'+o.floginName+'</td>';
            s+='<td ><img style="width:30px"  src='+imgPath+o.fheadImgUrl+'></td>';
            s+='<td >'+o.fnickName+'</td>';
            s+='<td >'+checkStatus(o.authStatus)+'</td>';
            s+='<td>'+checkStatus(o.fidentityStatus)+'</td>';
            s+='<td >'+o.frealName+'</td>';
            s+='<td>'+checkIdentityType(o.fidentityType)+'</td>';
            s+='<td>'+o.fidentityNo+'</td>';
            s+='<td ><img class="srcStyle" onclick="showImg(this)" src='+imgPath+o.fidentityPath+'>&nbsp;<img class="srcStyle" onclick="showImg(this)" src='+imgPath+o.fidentityPath2+'></td>';
            s+='<td style="display: none">'+o.gagTime+'</td>';
            s+='<td>'+formatDate(o.fregisterTime)+'</td>';
            s+=' <c:if test="${user_info.roleid < 3}"><td><button onclick="edit(this)" class="layui-btn layui-btn-small"><i class="layui-icon">编辑</i>'+
                    '</button><button onclick="auth(this)" class="layui-btn layui-btn-small"><i class="layui-icon">审核</i>'+
                    '</button><button onclick="resetPassword(this)" class="layui-btn layui-btn-small"><i class="layui-icon">密码重置</i></button></td></c:if></tr>';
        });
        if(data.length>0){
            $("#pageDiv").show();
            $("#tableinfo").find("tbody").html(s);
        }else{
            $("#pageDiv").hide();
            $("#tableinfo").find("tbody").html("<tr><td colspan='10' align='center'>暂无数据</td></tr>");
        }
    }

    function checkIdentityType(fidentityType){
        if(fidentityType == "0"){
            return "身份证";
        }else{
            return "其它";
        }
    }
    function checkStatus(authStatus){
        var authStatusMsg = "未提交";
        if(authStatus == "1"){
            authStatusMsg = "<font color='#4169e1'>已提交</font>";
        }else if(authStatus == "2"){
            authStatusMsg = "<font color='#009688'>已通过</font>";
        }else if(authStatus == "3"){
            authStatusMsg = "<font color='red'>审核失败</font>";
        }
        return authStatusMsg;
    }

    function resetPassword(othis){
        var obj = $(othis).parent().siblings();
        layer.confirm('重置 '+$(obj).eq(6).text()+' 的登录密码为123456？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(index){
            var id = $(othis).parent().siblings().eq(1).text();
            $.ajax({
                type:"post",
                async:false,
                url:"/user/resetPassword",
                data:{id:id},
                success:function(data,status){
                    data=eval("("+data+")");
                    if(data.status == "200"){
                        layer.alert("重置成功");
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

    var authformHtml = $("#authform").html();
    $("#authform").html("");
    function auth(othis){
        layer.open({
            title: "审核证件"
            ,offset:"auto1"
            ,id: 'system_dailog' //防止重复弹出
            ,content: '<div> '+authformHtml+'</div>'
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
    }

    var editformHtml = $("#editform").html();
    $("#editform").html("");
    function edit(othis){
        layer.open({
            title: "修该用户信息"
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
        $("#editfid").val($(obj).eq(1).text());
        $("#realName").val($(obj).eq(7).text());
        $("#identityNo").val($(obj).eq(9).text());
        $("#nickName").val($(obj).eq(4).text());
        var arr = getMinute($(obj).eq(11).text());
        $("#gagTime").val(arr[0]);
        $("#gagTimeType").val(arr[1]);
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
    function save(){
        var fid = $("#editfid").val();
        var frealName = $("#realName").val();
        var fidentityNo = $("#identityNo").val();
        var fnickName = $("#nickName").val();
        if(frealName == ""|| fidentityNo == "" || fnickName == ""){
            showMsgDailog("输入项不能为空");
            return false;
        }
        var gagTime = $("#gagTime").val();
        if(gagTime > 0){
            gagTime = getformatDate(gagTime,$("#gagTimeType").val());
        }else{
            gagTime == new Date();
        }
        var param = {
            fid:fid,
            frealName:frealName,
            fidentityNo:fidentityNo,
            fnickName:fnickName,
            gagTime:gagTime
        };
        $.ajax({
            type:"post",
            async:false,
            url:"/user/updateUser",
            dataType: 'json',
            //必需设定，后台@RequestBody会根据它做数据反序列化
            contentType:"application/json",
            //必需把JSON数据以字符串的格式提交
            data:JSON.stringify(param),
            success:function(data,status){
                if(data.status == "200"){
                    showMsgDailog("修改成功");
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

    function saveauth(){
        var fid = $("#fid").val();
        var errorMsg = $("#errorMsg").val();
        var fidentityStatus = $("#fidentityStatus").val();
        var authStatus = $("#authStatus").val();
        if(fidentityStatus == ""|| authStatus == ""){
            showMsgDailog("请选择审核结果");
            return false;
        }
        if((fidentityStatus == "3" || authStatus == "3") & errorMsg == ""){
            showMsgDailog("失败原因不能为空");
            return false;
        }

        var param = {
            fid:fid,
            fidentityStatus:fidentityStatus,
            authStatus:authStatus
        };
        $.ajax({
            type:"post",
            async:false,
            url:"/user/auth?errorMsg="+errorMsg,
            dataType: 'json',
            //必需设定，后台@RequestBody会根据它做数据反序列化
            contentType:"application/json",
            //必需把JSON数据以字符串的格式提交
            data:JSON.stringify(param),
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
        $("#editshowMsgDiv").toggle();
        $("#editshowMsgContent").text(msg);
    }
    function closeMsgDailog(){
        $("#showMsgDiv").toggle();
        $("#editshowMsgDiv").toggle();
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
            ,area: ['640px', '580px']//宽高
            ,shadeClose: true //开启遮罩关闭
            ,yes: function(){
                layer.closeAll();
            }
        });
    }

    function getDays(times){
        var start = new Date();
        return parseInt((times - start.getTime()) / (24*60*60*1000));
    }

    function  getHours(times){
        var start = new Date();
        return parseInt((times-start.getTime()) / (60*60*1000));
    }

    function getMinute(times){
        var result = new Array();
        if(times == "null"){
            result[0] = 0;
            result[1] = "m";
            return result;
        }
        var start = new Date();
        var min = parseInt((times - start.getTime()) / (60*1000));
        result[0] = min;
        result[1] = "m";
        if(min > 60){
            var hour = getHours(times);
            result[0] = hour;
            result[1] = "h";
            if(hour > 24){
                var day = getDays(times);
                result[0] = day;
                result[1] = "d";
            }
        }
        if(min < 0)  result[0] =0;
        return result;
    }

    function  getformatDate(num,type){
        var date = new Date();
        if(type == "m"){
            date = new Date(date.getTime()+(num*60*1000));
        }else if(type == "h"){
            date = new Date(date.getTime()+(num*60*60*1000));
        }else if(type =="d"){
            date = new Date(date.getTime()+(num*24*60*60*1000));
        }
        return date;
    }


</script>
<script src="/resource/js/admin.js"></script>

</body>
</html>