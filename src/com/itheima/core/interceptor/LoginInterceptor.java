package com.itheima.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.core.po.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	//转发器时候的拦截器
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		//1.首先判断是否去login界面
		String urlHeader = request.getRequestURI();
		if( urlHeader.indexOf("/login") >= 0 ){
			return true;
		}
		//2.判断会否有user_session
		HttpSession session = request.getSession();
		User user  =  (User)session.getAttribute("USER_SESSION");
		if(user != null){
			return true;
		}
		//没有登录，直接进来
		request.setAttribute("msg", "您还没有登录，请登录！");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, arg1);
		return false;
	}

}
