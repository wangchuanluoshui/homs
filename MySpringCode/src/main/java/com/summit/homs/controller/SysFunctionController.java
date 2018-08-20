package com.summit.homs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.summit.homs.dto.LoginSysUser;
import com.summit.homs.dto.SysFunction;
import com.summit.homs.dto.SysUser;
import com.summit.homs.service.ISysFunctionService;
import com.summit.homs.util.IResult;
import com.summit.homs.util.IResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "菜单功能模块")
@Controller(value = "function")
public class SysFunctionController {

	@Autowired
	ISysFunctionService iSysFunctionServicer;
	
	@ApiOperation(value = "菜单注册接口")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/functionRegister",method=RequestMethod.POST)
	@ResponseBody
	public IResult addFunction(@ApiParam(value = "菜单信息", required = true) @RequestBody SysFunction sysFunction){
		System.out.println(sysFunction);
		SysFunction sysFunction2= iSysFunctionServicer.addFunction(sysFunction);
		return IResultUtil.success(sysFunction2);
    }
	
	
	@ApiOperation(value = "菜单删除接口")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/deleteFunction/{functionid}",method=RequestMethod.GET)
	@ResponseBody
	public IResult deleteFunction(@ApiParam(value = "菜单信息ID", required = true) @PathVariable(name="functionid") String functionid){
		Boolean b= iSysFunctionServicer.deleteFunction(functionid);
		return IResultUtil.success();
    }
	
	
	@ApiOperation(value = "查询用户的所有菜单信息")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/findFunctionTree",method=RequestMethod.GET)
	@ResponseBody
	public IResult findFunctionAllTree(@SessionAttribute("LOGIN_USER") SysUser sessionSysUser){
		List<SysFunction> sysFunctions = iSysFunctionServicer.findFunctionAllTree(sessionSysUser);
		return IResultUtil.success(sysFunctions);
    }
	
	@ApiOperation(value = "更新菜单信息")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/updateFunction",method=RequestMethod.POST)
	@ResponseBody
	public IResult updateFunction(@ApiParam(value = "菜单信息", required = true) @RequestBody SysFunction sysFunction){
		SysFunction sysFunctions = iSysFunctionServicer.updateFunction(sysFunction);
		return IResultUtil.success(sysFunctions);
    }
	
}
