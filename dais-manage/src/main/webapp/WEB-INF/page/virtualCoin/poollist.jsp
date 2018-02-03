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
              <a><cite>虚拟币可用地址</cite></a>
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
                    <th >log</th>
                    <th >可用地址数量</th>
                    <c:if test="${user_info.roleid < 3}">
                    <th >操作</th>
                    </c:if>
                </thead>
                <tbody></tbody>
            </table>
        <%@include file="../page.jsp" %>
    </div>
    <%@include file="../foot.jsp" %>
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
            url:"/virtualCoin/getPoolList",
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
            s+='<td style="display: none">'+o.fId+'</td>';
            s+='<td >'+o.fName+'</td>';
            s+='<td >'+o.fShortName+'</td>';
            s+='<td><img style="width:30px" src='+imgPath+o.furl+'></td>';
            s+='<td >'+checkCount(o.count)+'</td>';
            s+=' <c:if test="${user_info.roleid < 3}"><td>'
            + '<input type="text" style="height:31px;float:left;width: auto;" placeholder="请输入钱包解锁密码"  autocomplete="off" class="layui-input" />'
                +' <button class="layui-btn layui-btn-small" onclick="createWalletAddress(this)">生成地址</button></td></c:if></tr>';
        });
        if(data.length>0){
            $("#pageDiv").show();
            $("#tableinfo").find("tbody").html(s);
        }else{
            $("#pageDiv").hide();
            $("#tableinfo").find("tbody").html("<tr><td colspan='10' align='center'>暂无数据</td></tr>");
        }
    }

    function checkCount(count){
        if(count == undefined){
            return 0;
        }
        return count;
    }

    function createWalletAddress(othis){
        var id = $(othis).parent().siblings().eq(1).text();
        var password = $(othis).siblings('input').val();
        $.ajax({
            type:"post",
            async:false,
            url:"/virtualCoin/createWalletAddress",
            data:{uid:id,"passWord":password},
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