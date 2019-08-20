package com.mxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *Thymeleaf入门案例 
 *
 */
@Controller
public class DemoController {

	@RequestMapping("/{page}")
	public String showInfo(@PathVariable String page,Integer id,String name) {
		System.out.println(id+"--"+name);
		return page;
	}
	
}
