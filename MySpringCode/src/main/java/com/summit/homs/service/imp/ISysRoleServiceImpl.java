package com.summit.homs.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.homs.dto.SysRole;
import com.summit.homs.dto.SysUser;
import com.summit.homs.repository.ISysRoleRepository;
import com.summit.homs.service.ISysRoleService;
import com.summit.homs.util.EntityUtils;


@Service
public class ISysRoleServiceImpl implements ISysRoleService{

	@Autowired
	ISysRoleRepository iSysRoleRepository;
	
	@Override
	@Transactional
	public Integer save(SysRole role) {
		Integer num= iSysRoleRepository.iSave(role.getId(), role.getName());
		return num;
	}

	@Override
	@Transactional
	public void delete(String id) {
		//先删除关联表
		iSysRoleRepository.iDeleteRolesRelatedUser(id);
		//再删除角色表
		iSysRoleRepository.iDelete(id);		
	}

	@Override
	@Transactional
	public SysRole update(SysRole role) {
		Integer num= iSysRoleRepository.iUpdate(role.getId(), role.getName());
		return role;
	}

	@Override
	public SysRole findById(String id) throws Exception {
		List<Object[]> objs= iSysRoleRepository.iQuert(id);
		
		List<SysRole> roles=EntityUtils.castEntity(objs, SysRole.class);
		System.out.println(roles.size());
		System.out.println(roles.get(0).toString());
		return roles.get(0);
	}
	
	@Override
	public SysRole saveRoleAndFunction(SysRole role) {
		SysRole sysRole= iSysRoleRepository.save(role);
		return sysRole;
	}
	
	

}
