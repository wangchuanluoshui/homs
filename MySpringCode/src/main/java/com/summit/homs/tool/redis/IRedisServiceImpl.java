package com.summit.homs.tool.redis;

import org.springframework.stereotype.Service;

import com.summit.homs.dto.LoginSysUser;

/**
 * 
 * 
* @Title:：IRedisServiceImpl.java 
* @Package ：com.summit.homs.service 
* @Description： TODO
* @author： hyn   
* @date： 2018年8月14日 下午8:30:11 
* @version ： 1.0
 */
@Service
public class IRedisServiceImpl extends AbstractIRedisService<LoginSysUser> {
	private static final String REDIS_KEY = "REDIS_KEY";

	@Override
	protected String getRedisKey() {
		return this.REDIS_KEY;
	}
}