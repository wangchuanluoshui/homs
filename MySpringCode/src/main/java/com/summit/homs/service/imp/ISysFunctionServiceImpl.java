package com.summit.homs.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.homs.dto.SysFunction;
import com.summit.homs.dto.SysUser;
import com.summit.homs.repository.ISysFunctionRepository;
import com.summit.homs.service.ISysFunctionService;

@Service
public class ISysFunctionServiceImpl implements ISysFunctionService{

	@Autowired
	ISysFunctionRepository sysFunctionRepository;

	@Override
	public SysFunction addFunction(SysFunction sysFunction) {
		SysFunction sysFunction2= sysFunctionRepository.save(sysFunction);
		return sysFunction2;
	}

	@Override
	public Boolean deleteFunction(String functionId) {
		sysFunctionRepository.deleteById(functionId);
		return true;
	}

	@Override
	public SysFunction updateFunction(SysFunction sysFunction) {
		SysFunction sysFunction2=sysFunctionRepository.saveAndFlush(sysFunction);
		return sysFunction2;
	}

	@Override
	public List<SysFunction> findFunctionAllTree(SysUser sysUser) {
		
		
		
		//根据当前用户,查询对应角色
		
		
		//根据角色查询对应的功能菜单树
		
		
		return null;
	}

	
}
