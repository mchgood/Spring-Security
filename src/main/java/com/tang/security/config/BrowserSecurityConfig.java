package com.tang.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @auther: tangkc
 * @Date: 2019/10/13 21:30
 * @Description:
 * <p>https://www.cnblogs.com/lywJ/p/10985259.html</p>
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//http.httpBasic() // HTTP Basic方式
		//默认是表单方式
		http.formLogin() // 表单方式
				.and()
				.authorizeRequests() // 授权配置
				.anyRequest()  // 所有请求
				.authenticated(); // 都需要认证
	}
}
