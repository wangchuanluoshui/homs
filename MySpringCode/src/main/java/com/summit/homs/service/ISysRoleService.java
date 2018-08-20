package com.summit.homs.service;

import java.util.List;

import com.summit.homs.dto.SysRole;
import com.summit.homs.dto.SysUser;

public interface ISysRoleService {

	// 增加角色
	public Integer save(SysRole role);

	//删除
	public void delete(String id);
	
	//修改
	public SysRole update(SysRole role);
	
	//查询
	public SysRole findById(String id) throws Exception;
	
	//增加角色和对应的角色信息
	public SysRole saveRoleAndFunction(SysRole role);
}
