package com.tang.security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: tangkc
 * @Date: 2019/10/13 21:24
 * @Description:
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "hello spring security";
	}

	@GetMapping("index")
	public Object index(){
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
