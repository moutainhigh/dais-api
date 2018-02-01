<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <title>管理员登录</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="/resource/logincss/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="/resource/logincss/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="/resource/logincss/css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
<div class="container">
  <div class="col-md-12" style="top:80px">
    <h1 class="margin-bottom-15">Dais管理员登录</h1>
    <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" >
      <div class="form-group">
        <div class="col-xs-12">
          <div class="control-wrapper">
            <label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
            <input type="text" class="form-control" id="username" placeholder="请输入用户名">
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-12">
          <div class="control-wrapper">
            <label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
            <input type="password" class="form-control" id="password" placeholder="请输入密码">
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-12">
          <div class="control-wrapper">
            <input type="button" onclick="doQuery()" value="登录" class="btn btn-info">
          </div>
        </div>
      </div>
      <hr>
      <div class="form-group">
        <div class="col-md-12">
          <label>@copyright www.zhgtrade.com</label>
        </div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript" src="/resource/js/jquery-1.8.1.min.js"></script>
<script src="/resource/layui/src/layui.js"></script>
<script>
  layui.use(['form', 'layedit', 'laydate'], function(){
  });
</script>
<script type="text/javascript">
  $(document).ready(function() {
    $(document).keydown(function(event) {
      if (event.keyCode == 116) {//F5刷新重载页面
        window.location.reload();
      }
    });
    $("#username").focus();

    $(document).keyup(function(event) {
      if (event.keyCode == 13) {
        if (!validate()) {
          return;
        }
        doQuery();
      }
    });
  });

  function doQuery() {
    validate();
    $.ajax({
      type : "post",
      url : "/login",
      async : false,
      data : {
        "username" : $("#username").val(),
        "password" : $("#password").val()
      },
      dataType : "json",
      success:function(data,status){
        if (data.status == "200") {
          location.href = "/index";
        } else {
          layer.alert(data.msg);
        }
      }
    })
  }
  function validate() {
    var msg = "";
    var obj = "";
    if ($("#username").val() == '' || $("#username").val() == null) {
      obj = $("#username");
      msg = "请输入登录帐号";
    }else if ($("#password").val() == '' || $("#password").val() == null) {
      obj = $("#password");
      msg = "请输入登陆密码";
    }
    if(msg != ""){
      layer.open({
        title: "提示信息"
        ,offset:"auto1"
        ,id: 'system_dailog' //防止重复弹出
        ,content: '<div> '+msg+'</div>'
        ,btn: "确定"
        ,btnAlign: 'c' //按钮居中
        ,yes: function(){
          layer.closeAll();
          $(obj).focus();
          return false;
        }
      });
    }
    return true;
  }

</script>
</body>
</html>
