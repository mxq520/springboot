package com.mxq.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * SpringBoot文件上传
 *
 */
@RestController //表示该类下的方法的返回值会自动做json格式转换
public class FileUploadController {

	/**
	 * 处理文件上传
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fileUploadController")
	public Map<String, Object> fileUpload(MultipartFile filename) throws Exception{
		System.out.println(filename.getOriginalFilename());
		filename.transferTo(new File("e:/"+filename.getOriginalFilename()));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "上传成功！");
		return map;
	}
	@RequestMapping("/test")
	public void test() {
		System.out.println("ssssssssssssssssssssss");
	}
}
