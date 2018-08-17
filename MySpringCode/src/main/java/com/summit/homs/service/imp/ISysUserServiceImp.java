package com.summit.homs.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.homs.dto.SysUser;
import com.summit.homs.repository.ISysUserRepository;
import com.summit.homs.service.ISysUserService;

@Service
public class ISysUserServiceImp implements ISysUserService{

	@Autowired
	ISysUserRepository iSysUserRepository;
	
	@Override
	public SysUser addUser(SysUser sysUser) {
		SysUser user= iSysUserRepository.save(sysUser);
		return user;
	}

	@Override
	public List<SysUser> findByChineseName(String Chinesename) {
		List<SysUser> sysUsers= iSysUserRepository.findByChineseName(Chinesename);
		return sysUsers;
	}

	@Override
	public Boolean deleteUser(String userId) {
		SysUser sysUser= new SysUser();
		sysUser.setId(userId);
		iSysUserRepository.delete(sysUser);
		return true;
	}

	@Override
	public SysUser updateUser(SysUser sysUser) {
		SysUser  user= iSysUserRepository.saveAndFlush(sysUser);
		return user;
	}

	
}
