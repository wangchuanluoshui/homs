package com.summit.homs.service;

import java.util.List;

import com.summit.homs.dto.SysFunction;
import com.summit.homs.dto.SysUser;

public interface ISysFunctionService {

	// 注册
	public SysFunction addFunction(SysFunction sysFunction);
	
	//删除
	public Boolean deleteFunction(String functionId);
	
	//修改
	public SysFunction updateFunction(SysFunction sysFunction);
	
	//根据用户查询所有菜单树
	public List<SysFunction> findFunctionAllTree(SysUser sysUser);
}
