<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
              <a >系统管理<span class="layui-box">&gt;</span></a>
              <a><cite>配置参数列表</cite></a>
            </span>
                <div class="layui-input-inline" style="margin-left: 26%">
                    <input type="text" id="searchValue" style="float:left;width: auto;" placeholder="请输入" autocomplete="off" class="layui-input">
                    <button id="searchButton" style="float:right;" class="layui-btn"><i class="layui-icon" >搜索</i></button>
                </div>
            <table id="tableinfo" class="layui-table" >
                <thead>
                <tr>
                    <th lay-data="{checkbox:true, fixed: true}"></th>
                    <th >key</th>
                    <th >value</th>
                    <th >描述</th>
                    <th >创建时间</th>
                    <th >更新时间</th>
                    <th >操作</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
            <button class="layui-btn layui-btn-small" style="float: right;margin-right: 104px;" onclick="add()"><i class="layui-icon" ></i></button>
        <%@include file="../page.jsp" %>
    </div>
    <%@include file="../foot.jsp" %>
</div>

<div id="editform" style="display: none; position:relative;">
    <form class="layui-form" >
        <input type="hidden" id="id"  placeholder="请输入"  class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">key</label>
            <div class="layui-input-block">
                <input type="text" id="key"  placeholder="请输入"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">value</label>
            <div class="layui-input-block">
                <input type="text" id="value"  placeholder="请输入"   class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <input type="text" id="description"  placeholder="请输入"  class="layui-input">
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
        <div style="position: fixed;top: 65%;left: 50%;"><button class="layui-btn layui-btn-small" onclick="closeMsgDailog()"><i class="layui-icon">确定</i></button></div>
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
            url:"/param/getParam",
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
            s+='<td >'+o.paramKey+'</td>';
            s+='<td >'+o.paramValue+'</td>';
            s+='<td >'+o.description+'</td>';
            s+='<td>'+formatDate(o.created)+'</td>';
            s+='<td>'+formatDate(o.updated)+'</td>';
            s+='<td><button onclick="edit(this)" class="layui-btn layui-btn-small"><i class="layui-icon"></i></button>' +
            '<button class="layui-btn layui-btn-small" onclick="del(this)"><i class="layui-icon"></i></button></td></tr>';
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
                url:"/param/delete",
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
        $("#id").val($(obj).eq(1).text());
        $("#key").val($(obj).eq(2).text());
        $("#value").val($(obj).eq(3).text());
        $("#description").val($(obj).eq(4).text());
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
        var id = $("#id").val();
        var key = $("#key").val();
        var description = $("#description").val();
        var value = $("#value").val();
        if(key == "" ||  value== ""|| description == ""){
            showMsgDailog("输入项不能为空");
            return false;
        }

        var param = {
            id:id,
            paramKey:key,
            paramValue:value,
            description:description
        };
        $.ajax({
            type:"post",
            async:false,
            url:"/param/save",
            dataType: 'json',
            //必需设定，后台@RequestBody会根据它做数据反序列化
            contentType:"application/json",
            //必需把JSON数据以字符串的格式提交
            data:JSON.stringify(param),
            success:function(data,status){
                if(data.status == "200"){
                    showMsgDailog("保存成功");
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
</script>
<script src="/resource/js/admin.js"></script>
</body>
</html>