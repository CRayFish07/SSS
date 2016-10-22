package com.silence.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {

	private final static Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
	//在方法执行之前执行，该拦截器在springmvc.xml文件中配置
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		LOGGER.info("execute the preHandle function");
		return true;
	}

	// 调用方法之后，但在渲染视图之前调用,可以对请求yu中的数据更改
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	// 渲染视图之后被调用
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}