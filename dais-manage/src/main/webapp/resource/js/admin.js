var editformHtmlMain = $("#editformMain").html();
$("#editformMain").html("");
function updatepassword() {
    layer.open({
        title: "修改密码"
        ,offset:"auto1"
        ,id: 'system_dailog' //防止重复弹出
        ,content: '<div> '+editformHtmlMain+'</div>'
        ,btn: false
        ,btnAlign: 'c' //按钮居中
        ,area: ['620px', 'auto']//宽高
        ,shadeClose: true //开启遮罩关闭
        ,yes: function(){
            layer.closeAll();
        }
    });
}

function savepassword(){
    var sysuserid = $("#sysuserid").val();
    var oldpassword = $("#oldpassword").val();
    var newpassword = $("#newpassword").val();
    if(oldpassword == ""|| newpassword == ""){
        $("#showMsgContentMain").html("请输入密码");
        return false;
    }
    $.ajax({
        type:"post",
        async:false,
        url:"/updatepassword",
        dataType: 'json',
        data:{id:sysuserid,oldpassword:oldpassword,newpassword:newpassword},
        success:function(data,status){
            if(data.status == "200"){
                $("#showMsgContentMain").html("修改成功");
                layer.closeAll();
            }else{
                $("#showMsgContentMain").html(data.msg);
            }
        },
        error:function(xhr,textStatus){
            $("#showMsgContentMain").html(xhr+textStatus);
        }
    });
}
function add0(m){return m<10?'0'+m:m }
function formatDate(times) {
    var time = new Date(times);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}