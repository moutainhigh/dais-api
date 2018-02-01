package com.dais.interceptor;

import com.dais.model.User;
import com.dais.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//在Handler执行之前处理
		//判断用户是否登录
		//从cookie中取token
		String token = request.getParameter("token");
		//根据token换取用户信息，调用sso系统的接口。
		User user = userService.queryUser(token);
		//取不到用户信息
		if (null == user) {
			//跳转到登录页面，把用户请求的url作为参数传递给登录页面。
			response.sendRedirect(request.getContextPath() + "/chat/relogin");
			//返回false
			return false;
		}
		//返回值决定handler是否执行。true：执行，false：不执行。
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
