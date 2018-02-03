<%@ page pageEncoding="UTF-8"%>
<div class="layui-header">
		<div class="layui-logo">dais管理系统</div>
		<!-- 头部区域（可配合layui已有的水平导航） -->
		<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="/virtualCoin/coinlist">虚拟币</a></li>
				<li class="layui-nav-item"><a href="/user/userlist">用户</a></li>
			<li class="layui-nav-item">
				<a href="javascript:;">充值提现</a>
				<dl class="layui-nav-child">
					<dd><a href="/virtualCoin/feeslist">手续费</a></dd>
					<dd><a href="/captualoperation/captualoperationlist">提现审核</a></dd>
					<dd><a href="/captualoperation/rechargelist">充值记录</a></dd>
				</dl>
			</li>
		</ul>
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item">
				<a href="javascript:;">
					<img src="http://t.cn/RCzsdCq" class="layui-nav-img">
					${user_info.username}
				</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:updatepassword();">修改密码</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item"><a href="/loginout">退出</a></li>
		</ul>
	</div>

	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
				<li class="layui-nav-item layui-nav-itemed">
					<a class="" href="javascript:;">虚拟币管理</a>
					<dl class="layui-nav-child">
						<dd><a href="/virtualCoin/coinlist">虚拟币类型列表</a></dd>
						<dd><a href="/virtualCoin/poollist">虚拟币地址管理</a></dd>
						<dd><a href="/virtualCoin/feeslist">虚拟币提现费率</a></dd>
						<dd><a href="/captualoperation/captualoperationlist">虚拟币提现记录</a></dd>
						<dd><a href="/captualoperation/rechargelist">虚拟币充值记录</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">用户管理</a>
					<dl class="layui-nav-child">
						<dd><a href="/user/userlist">用户列表</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">虚拟币资产</a>
					<dl class="layui-nav-child">
						<dd><a href="/wallet/walletlist">虚拟币资产</a></dd>
					</dl>
				</li>
				<%--<li class="layui-nav-item">
					<a href="javascript:;">DAIS账户</a>
					<dl class="layui-nav-child">
						<dd><a href="/account/accountlist">账户资产</a></dd>
					</dl>
					<dl class="layui-nav-child">
						<dd><a href="/account/optionlist">收支记录</a></dd>
					</dl>
				</li>--%>
			<%--	<li class="layui-nav-item">
					<a href="javascript:;">聊天室消息</a>
					<dl class="layui-nav-child">
						<dd><a href="/chatroom/msglist">消息列表</a></dd>
					</dl>
				</li>--%>
				<li class="layui-nav-item">
					<a href="javascript:;">系统管理</a>
					<dl class="layui-nav-child">
						<c:if test="${user_info.id == 1}">
							<dd><a href="/param/paramlist">系统配置参数</a></dd>
						</c:if>
						<dd><a href="/system/adminlist">管理员列表</a></dd>
					</dl>
				</li>
			</ul>
		</div>
	</div>

<div id="editformMain" style="display: none; position:relative;">
	<form class="layui-form" >
		<input type="hidden" id="sysuserid" value="${user_info.id}" placeholder="请输入"  class="layui-input">
		<div class="layui-form-item">
			<label class="layui-form-label">原始密码</label>
			<div class="layui-input-block">
				<input type="text" id="oldpassword" placeholder="请输入原始密码"   class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">新密码</label>
			<div class="layui-input-block">
				<input type="text" id="newpassword"  placeholder="请输入新密码"   class="layui-input">
			</div>
		</div>
		<div style="position: fixed;float: right;right: 29%;color: red;" id="showMsgContentMain"></div>
		<div class="layui-form-item2">
			<div class="layui-input-block">
				<div class="layui-btn"  onclick="javascript:savepassword();">立即提交</div>
				<div onclick="javascript:layer.closeAll();" class="layui-btn layui-btn-primary">取消</div>
			</div>
		</div>
	</form>
</div>
