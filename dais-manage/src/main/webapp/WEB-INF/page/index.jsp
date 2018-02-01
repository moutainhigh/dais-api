<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="taglibs.jsp"%>
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
  <%@include file="main.jsp" %>
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <br/>&nbsp;&nbsp;
            <span class="layui-breadcrumb" style="visibility: visible;">
              <a >首页<span class="layui-box">&gt;</span></a>
            </span>
  </div>
  <%@include file="foot.jsp" %>
</div>

<script src="/resource/layui/src/layui.js"></script>
<script type="text/javascript" src="/resource/js/jquery-1.8.1.min.js"></script>
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
<script src="/resource/js/admin.js"></script>
</body>
</html>