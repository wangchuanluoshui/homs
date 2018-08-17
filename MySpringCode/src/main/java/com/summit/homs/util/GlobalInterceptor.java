package com.summit.homs.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 全局拦截器
 * 
 * @Title:：GlobalInterceptor.java 
 * @Package ：com.summit.homs.global.cfg 
 * @Description： TODO
 * @author： hyn   
 * @date： 2018年8月16日 下午5:23:04 
 * @version ： 1.0
 */
public class GlobalInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String sessionId = request.getSession().getId();
		if (logger.isInfoEnabled()) {
			logger.info("SESSIONID:"+sessionId);
			logger.info(request.getContextPath());
			logger.info(request.getRequestURL().toString());
		}
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

