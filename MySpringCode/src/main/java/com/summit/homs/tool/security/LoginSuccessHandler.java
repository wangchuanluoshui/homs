package com.summit.homs.tool.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSONObject;
import com.summit.homs.dto.LoginSysUser;
import com.summit.homs.tool.redis.AbstractIRedisService;
import com.summit.homs.util.IResult;
import com.summit.homs.util.IResultUtil;


/**
 * 
 * 登陆成功处理类
 * 
 * @Title:：LoginSuccessHandler.java 
 * @Package ：com.summit.homs.global.cfg 
 * @Description： TODO
 * @author： hyn   
 * @date： 2018年8月16日 下午5:22:01 
 * @version ： 1.0
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// 获取当前用户(domain接收)
		LoginSysUser user = (LoginSysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		request.getSession().setAttribute("LOGIN_USER", user);
		logger.info("登陆成功，用户："+user.getChineseName());
		// 转发到index页面
//		response.sendRedirect(request.getContextPath() + "/hello");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		//返回JSON字符串
		PrintWriter writer =response.getWriter();
		writer.write(JSONObject.toJSONString(IResultUtil.success()));
		
	}

}
