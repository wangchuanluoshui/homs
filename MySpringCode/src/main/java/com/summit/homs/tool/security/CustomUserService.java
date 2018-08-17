package com.summit.homs.tool.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.summit.homs.dto.LoginSysUser;
import com.summit.homs.dto.SysUser;
import com.summit.homs.repository.ISysUserRepository;

public class CustomUserService implements UserDetailsService {
	@Autowired
	ISysUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		LoginSysUser loginSysUser = new LoginSysUser();

		SysUser user = userRepository.findByLoginUserName(name);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		
		loginSysUser.setChineseName(user.getChineseName());
		
		loginSysUser.setEmail(user.getEmail());

		loginSysUser.setId(user.getId());
		
		loginSysUser.setPassword(user.getPassword());
		
		loginSysUser.setPhone(user.getPhone());
		
		loginSysUser.setRoles(user.getRoles());
		
		return loginSysUser;
	}
}
