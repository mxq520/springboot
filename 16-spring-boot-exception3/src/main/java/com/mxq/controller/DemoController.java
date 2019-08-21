package com.mxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/showUsers")
	public String showuser() {
		String str = null;
		str.length();
		return "";
	}
	
	@RequestMapping("/showUsers2")
	public String showuser2() {
		
		int a = 100/0;
		
		return "";
	}
	
}
