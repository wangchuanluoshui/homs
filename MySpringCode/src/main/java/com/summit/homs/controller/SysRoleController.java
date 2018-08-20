package com.summit.homs.controller;

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
import com.summit.homs.dto.SysRole;
import com.summit.homs.dto.SysUser;
import com.summit.homs.service.ISysRoleService;
import com.summit.homs.util.IResult;
import com.summit.homs.util.IResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "角色模块")
@Controller(value = "role")
public class SysRoleController {

	
	@Autowired
	ISysRoleService iSysRoleService;
	
	
	@ApiOperation(value = "角色的添加")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="addRole",method=RequestMethod.POST)
	@ResponseBody
    public IResult addRole(@ApiParam(value = "角色信息", required = true) @RequestBody SysRole sysRole){
		iSysRoleService.save(sysRole);
		return IResultUtil.success();
    }
	
	@ApiOperation(value = "角色的添删除")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/deleteRole/{id}",method=RequestMethod.GET)
	@ResponseBody
    public IResult deleteRole(@ApiParam(value = "角色ID", required = true) @PathVariable(name="id") String roleId){
		iSysRoleService.delete(roleId);
		return IResultUtil.success();
    }
	
	@ApiOperation(value = "角色的添加")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/updateRole",method=RequestMethod.POST)
	@ResponseBody
    public IResult delRole(@ApiParam(value = "角色信息", required = true) @RequestBody SysRole sysRole){
		iSysRoleService.update(sysRole);
		return IResultUtil.success();
    }
	
	
	@ApiOperation(value = "查询角色信息")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="/findRole/{id}",method=RequestMethod.GET)
	@ResponseBody
    public IResult findRole(@ApiParam(value = "角色ID", required = true) @PathVariable(name="id") String roleId) throws Exception{
		SysRole sysRole= iSysRoleService.findById(roleId);
		return IResultUtil.success(sysRole);
    }
	
	
	@ApiOperation(value = "增加角色对应权限资源的信息")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value="addRoleAndFunction",method=RequestMethod.POST)
	@ResponseBody
    public IResult addRoleAndFunction(@ApiParam(value = "角色信息", required = true) @RequestBody SysRole sysRole) throws Exception{
		SysRole sysRole2= iSysRoleService.saveRoleAndFunction(sysRole);
		return IResultUtil.success(sysRole2);
    }
}
