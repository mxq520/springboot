package com.mxq.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SpringBoot HelloWorld
 * @author w
 *
 */
@Controller
public class HelloWorld {

	@RequestMapping("/hello")
	@ResponseBody
	public Map<String, Object> showHelloWorld(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "HelloWorld");
		
		
		return map;
	}
}
