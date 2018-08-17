package com.summit.homs.tool.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.alibaba.fastjson.JSONObject;
import com.summit.homs.util.IResultUtil;

public class LoginFailHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		//返回JSON字符串
		PrintWriter writer =response.getWriter();
		writer.write(JSONObject.toJSONString(IResultUtil.fail(401, "账号或密码不正确")));
	}

	

}
