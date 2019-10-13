package com.tang.security.config;

import com.tang.security.handle.BaseAuthenticationFailureHandler;
import com.tang.security.handle.BaseAuthenticationSucessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @auther: tangkc
 * @Date: 2019/10/13 21:30
 * @Description:
 * <p>https://www.cnblogs.com/lywJ/p/10985259.html</p>
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BaseAuthenticationSucessHandler baseAuthenticationSucessHandler;

	@Autowired
	private BaseAuthenticationFailureHandler baseAuthenticationFailureHandler;
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin() // 表单登录
				// http.httpBasic() // HTTP Basic
				.loginPage("/login.html")//设置指定跳转界面
				.loginProcessingUrl("/login")//登录访问地址
				.successHandler(baseAuthenticationSucessHandler) // 处理登录成功
				.failureHandler(baseAuthenticationFailureHandler) //处理登录失败
				.and()
				.authorizeRequests() // 授权配置
				.antMatchers("/login.html",
						"/css/*",
						"/authentication/require").permitAll()//排除静态登录界面
				.anyRequest()  // 所有请求
				.authenticated()// 都需要认证
				.and().csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
