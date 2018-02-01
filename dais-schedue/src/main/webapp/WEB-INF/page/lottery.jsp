<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path  = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>抽奖</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jQueryRotate.2.2.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.easing.min.js"></script>
<script type="text/javascript">
$(function(){
	     $("#start").click(function(){ 
	        lottery(); 
	    }); 
	function lottery(){ 
	    $.ajax({ 
	        type: 'POST', 
	        url: '/lottery/prize',
	        dataType: 'json', 
	        cache: false, 
	        error: function(){ 
	            alert('出错了！'); 
	            return false; 
	        }, 
	        success:function(json){ 
	            $("#start").unbind('click').css("cursor","default"); 
	            var a = json.angle; //角度 
	            var p = json.prize; //奖项 
	            $("#start").rotate({ 
	                duration:3000, //转动时间 
	                angle: 0, 
	                animateTo:1800+a, //转动角度 
	                easing: $.easing.easeOutSine, 
	                callback: function(){ 
/* 	                    var con = confirm('恭喜你，中得'+p+'\n还要再来一次吗？'); 
	                    if(con){ 
	                        lottery(); 
	                    }else{ 
	                        return false; 
	                    }  */
	           	     $("#start").click(function(){ 
	         	        lottery(); 
	         	    }); 
	                } 
	            }); 
	        } 
	    }); 
	}
});
</script>
</head>
<body style="background:url(<%=path %>/img/bg.png) top center no-repeat; background-size:cover;overflow-x:hidden;">
	<div class="banner">
		<div class="turnplate" style="background-size:100% 100%;">
			<canvas class="item" id="wheelcanvas" width="553px" height="582px"></canvas>
			<img id="start" class="pointer" src="<%=path %>/img/icon.png"/>
		</div>
	</div>
</body>
</html>