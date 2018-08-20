package com.summit.homs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
/**
 * 
 * @Title:：SessionConfigurer.java 
 * @Package ：com.summit.homs.config 
 * @Description： TODO
 * @author： hyn   
 * @date： 2018年8月17日 下午5:49:15 
 * @version ： 1.0
 */

//maxInactiveIntervalInSeconds: 设置Session失效时间，使用Redis Session之后，原Boot的server.session.timeout属性不再生效
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 200*10)
public class SessionConfigurer {

}
