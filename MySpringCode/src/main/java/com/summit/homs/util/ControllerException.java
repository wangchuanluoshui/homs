package com.summit.homs.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.thymeleaf.exceptions.TemplateInputException;

/**
 *   全局异常处理类
 * 
 * @Title:：ControllerException.java 
 * @Package ：com.summit.homs.global.cfg 
 * @Description： TODO
 * @author： hyn   
 * @date： 2018年8月16日 下午5:22:41 
 * @version ： 1.0
 */
@ControllerAdvice
@RestController
@RequestMapping(value = "/error")
public class ControllerException {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public IResult defaultException(HttpServletResponse response,Exception exception) {
		IResult iresult=new IResult();

		Integer returnCode;
		String returnMsg="";
		Object returnData=null;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		logger.error("服务异常",exception);
		
		//权限不足返回异常 
		if(exception instanceof AccessDeniedException)
		{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			returnCode=HttpServletResponse.SC_FORBIDDEN;
			returnMsg="权限不足";
		}else if(exception instanceof HttpRequestMethodNotSupportedException)
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			returnCode=HttpServletResponse.SC_UNAUTHORIZED;
			returnMsg="错误的请求";
		}
		else 
		{
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			returnCode=HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			returnMsg=exception.getLocalizedMessage();
		}
		
		iresult.setCode(returnCode);
		iresult.setMsg(returnMsg);
		iresult.setData(returnData);
		return iresult;
	}
	
	
}
