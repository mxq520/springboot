package com.mxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springboot 处理异常方式一，自定义错误页面
 *
 */
@Controller
public class UsersController {

	
	@RequestMapping("/show")
	public String showInfo() {
		
		String str = null;
		str.length();
		return "ok";
	}
	
	@RequestMapping("/show2")
	public String showInfo2() {
		
		int a = 100/0;
		return "ok";
	}
}
