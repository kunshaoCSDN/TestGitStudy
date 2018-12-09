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

	//ת����ʱ���������
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		//1.�����ж��Ƿ�ȥlogin����
		String urlHeader = request.getRequestURI();
		if( urlHeader.indexOf("/login") >= 0 ){
			return true;
		}
		//2.�жϻ����user_session
		HttpSession session = request.getSession();
		User user  =  (User)session.getAttribute("USER_SESSION");
		if(user != null){
			return true;
		}
		//û�е�¼��ֱ�ӽ���
		request.setAttribute("msg", "����û�е�¼�����¼��");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, arg1);
		return false;
	}

}
