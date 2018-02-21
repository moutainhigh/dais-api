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
		String token = request.getParameter("token");
		User user = userService.queryUser(token);
		if (null == user) {
			response.sendRedirect(request.getContextPath() + "/user/relogin");
			return false;
		}
		if(user.getWalletStatus() == 2 && request.getRequestURL().indexOf("/virtualCoin/") > 0){
			response.sendRedirect(request.getContextPath() + "/user/invalidWallet");
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
