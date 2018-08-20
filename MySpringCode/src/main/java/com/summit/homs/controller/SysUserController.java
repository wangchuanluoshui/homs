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
import com.summit.homs.dto.SysUser;
import com.summit.homs.service.ISysUserService;
import com.summit.homs.util.IResult;
import com.summit.homs.util.IResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @Title:：UserController.java 
 * @Package ：com.summit.homs.controller 
 * @Description： TODO
 * @author： hyn   
 * @date： 2018年8月17日 下午5:49:22 
 * @version ： 1.0
 */

@Api(value = "用户模块")
@Controller
public class SysUserController {

	@Autowired
	ISysUserService iSysUserService;
	
	@ApiOperation(value = "权限测试ADMIN，USER登录的用户才可以点开")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @RequestMapping(value="/user",method=RequestMethod.GET)
	@ResponseBody
    public IResult user(@SessionAttribute("LOGIN_USER") SysUser sessionSysUser){
		System.out.println("userController:"+sessionSysUser);
        return IResultUtil.success();
    }
	@ApiOperation(value = "权限测试只有ADMIN登录的用户才可以点开")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/admin",method=RequestMethod.GET)
	@ResponseBody
    public IResult admin(@SessionAttribute("LOGIN_USER") SysUser sessionSysUser){
		System.out.println("adminController"+sessionSysUser);
		return IResultUtil.success();
    }
	@ApiOperation(value = "登录功能，以获取session")
    @RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
    public void login(@ApiParam(value = "用戶信息", required = true) @RequestBody String jsonstr){
    }
	
	
	/**
	 * 
	 * @param sessionSysUser
	 * @return IResult
	 */
	@ApiOperation(value = "用户注册接口")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/registerUser",method=RequestMethod.POST)
	@ResponseBody
	public IResult addUser(@ApiParam(value = "用戶信息", required = true) @RequestBody SysUser user){
		SysUser sysUser= iSysUserService.addUser(user);
		return IResultUtil.success(sysUser);
    }
	
	/**
	 * 
	 * @param sessionSysUser
	 * @return IResult
	 */
	@ApiOperation(value = "用户注册查询")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @RequestMapping(value="/findUser/{chineseName}",method=RequestMethod.GET)
	@ResponseBody
	public IResult findByLoginNameOrChineseNameOrPhone(@ApiParam(value = "用户登录名or中文名or电话", required = true) @PathVariable(name="chineseName") String chineseName){
		List<SysUser> sysUsers= iSysUserService.findByChineseName(chineseName);
		return IResultUtil.success(sysUsers);
    }
	
	
	/**
	 * 
	 * @param sessionSysUser
	 * @return IResult
	 */
	@ApiOperation(value = "删除用户信息")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/deleteUser/{id}",method=RequestMethod.GET)
	@ResponseBody
	public IResult deleteUserByUserId(@ApiParam(value = "用户ID", required = true) @PathVariable(name="id") String userid){
		iSysUserService.deleteUser(userid);
		return IResultUtil.success();
    }
	
	
	/**
	 * 
	 * @param sessionSysUser
	 * @return IResult
	 */
	@ApiOperation(value = "更新用户信息")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/updateUser",method=RequestMethod.POST)
	@ResponseBody
	public IResult deleteUserByUserId(@ApiParam(value = "用戶信息", required = true) @RequestBody SysUser user){
		SysUser sysUser= iSysUserService.updateUser(user);
		return IResultUtil.success(sysUser);
    }
}
