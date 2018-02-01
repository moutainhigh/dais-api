<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>dais管理界面</title>
    <link rel="stylesheet" href="/resource/layui/src/css/layui.css">
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
              <a><cite>虚拟币提现手续费</cite></a>
            </span>
                <div class="layui-input-inline" style="margin-left: 26%">
                    <input type="text" id="searchValue" style="float:left;width: auto;" placeholder="请输入" autocomplete="off" class="layui-input">
                    <button id="searchButton" style="float:right;" class="layui-btn"><i class="layui-icon" >搜索</i></button>
                </div>
            <table id="tableinfo" class="layui-table" >
                <thead>
                <tr>
                    <th >序号</th>
                    <th >币种名称</th>
                    <th >提现最低手续费</th>
                    <th >提现最高手续费</th>
                    <c:if test="${user_info.roleid < 3}">
                        <th >操作</th>
                    </c:if>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
            <c:if test="${user_info.roleid < 3}">
                <c:if test="${coinList != null }">
                    <button class="layui-btn layui-btn-small" style="float: right;margin-right: 104px;" onclick="add()"><i class="layui-icon" ></i></button>
                </c:if>
            </c:if>
        <%@include file="../page.jsp" %>
    </div>
    <%@include file="../foot.jsp" %>
</div>

<div id="editform" style="display: none; position:relative;">
    <form  >
        <input type="hidden" id="id"  placeholder="请输入"  class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">最小手续费</label>
            <div class="layui-input-block">
                <input type="text" id="minfees"  placeholder="最小手续费"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">最大手续费</label>
            <div class="layui-input-block">
                <input type="text" id="maxfees"  placeholder="最大手续费"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">选择币种</label>
                <select id="symbol" style="width: 160px;height: 33px;">
                    <c:forEach var="coin" items="${coinList}">
                        <option value="${coin.fid}">${coin.fname}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item2">
            <div class="layui-input-block">
                <div class="layui-btn"  onclick="javascript:save();">立即提交</div>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <div style="display: none;position: fixed;width: 318px; height: 140px; background: #e2e2e2;top: 27%;left: 27%;" id="showMsgDiv">
        <div style="background: #1aa094;color: #f8f8f8; padding-left: 7px;">提示信息</div>
        <div style="margin: 0 auto; display: table;padding-top: 20px;" id="showMsgContent">1111</div>
        <div style="position: fixed;top: 58%;left: 50%;"><button class="layui-btn layui-btn-small" onclick="closeMsgDailog()"><i class="layui-icon">确定</i></button></div>
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
            url:"/virtualCoin/getFeesList",
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
        $.each(data,function(v,o){
            s+='<tr><td>'+(v+1+((start-1)*limit))+'</td>';
            s+='<td style="display: none">'+o.id+'</td>';
            s+='<td style="display: none">'+o.symbol+'</td>';
            s+='<td >'+o.coinname+'</td>';
            s+='<td >'+o.minfees+'</td>';
            s+='<td >'+o.maxfees+'</td>';
            s+='<c:if test="${user_info.roleid < 3}"><td> <button onclick="edit(this)" class="layui-btn layui-btn-small"><i class="layui-icon"></i></button>' +
            '<c:if test="${user_info.roleid == 1}"><button class="layui-btn layui-btn-small" onclick="del(this)"><i class="layui-icon"></i></button></c:if></td></c:if></tr>';
        });
        if(data.length>0){
            $("#pageDiv").show();
            $("#tableinfo").find("tbody").html(s);
        }else{
            $("#pageDiv").hide();
            $("#tableinfo").find("tbody").html("<tr><td colspan='10' align='center'>暂无数据</td></tr>");
        }
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
                url:"/system/delete",
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
    var editformHtml = $("#editform").html();
    $("#editform").html("");
    function edit(othis){
        layer.open({
            title: "修改用户信息"
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
        $("#id").val($(obj).eq(1).text());
        $("#symbol").html("<option>"+$(obj).eq(3).text()+"</option>");
        var minfees = $("#minfees").val($(obj).eq(4).text());
        var maxfees = $("#maxfees").val($(obj).eq(5).text());
    }
    function add(){
        layer.open({
            title: "新增用户"
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
        var id = $("#id").val();
        var symbol = $("#symbol").val();
        var coinname = $("#symbol option:selected").text();
        var minfees = $("#minfees").val();
        var maxfees = $("#maxfees").val();
        if(minfees == "" || maxfees == ""){
            showMsgDailog("手续费不能为空");
            return false;
        }
        if(!(checkRate(minfees) && checkRate(maxfees))){
            showMsgDailog("手续费必须是数字");
            return false;
        }
        //不允许被修改币种
        if(id != null){
            coinname = null;
            symbol = null;
        }
        var param = {
            id:id,
            symbol:symbol,
            coinname:coinname,
            minfees:minfees,
            maxfees:maxfees
        };
        $.ajax({
            type:"post",
            async:false,
            url:"/virtualCoin/saveFees",
            dataType: 'json',
            //必需设定，后台@RequestBody会根据它做数据反序列化
            contentType:"application/json",
            //必需把JSON数据以字符串的格式提交
            data:JSON.stringify(param),
            success:function(data,status){
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
    function checkRate(nubmer){
        var re = /^[0-9]+.?[0-9]*$/;
        if (!re.test(nubmer)){
            return false;
        }
        return true;
    }
</script>
<script src="/resource/js/admin.js"></script>
</body>
</html>