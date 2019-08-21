package com.mxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringBoot----SpringLoader
 * 
 * 
 *
 */
@Controller
public class UsersController {

	@RequestMapping("/show")
	public String show() {
		System.out.println("show.............qqqq111");
		return "index";
	}
	
}
