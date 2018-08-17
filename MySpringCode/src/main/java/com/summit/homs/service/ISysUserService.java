package com.summit.homs.service;

import java.util.List;

import com.summit.homs.dto.SysUser;

public interface ISysUserService {

	// 注册
	public SysUser addUser(SysUser sysUser);

	// 查询用户根据用户ID或者名字查
	public List<SysUser> findByChineseName(String loginOrChinesenameOrPhone);
	
	//删除
	public Boolean deleteUser(String userId);
	
	//修改
	public SysUser updateUser(SysUser sysUser);
}
