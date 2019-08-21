package com.mxq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxq.App;
import com.mxq.service.UserServiceImpl;

/**
 * SpringBoot测试类
 * @RunWith:启动类
 *SpringJUnit4ClassRunner.class:让junit与spring环境进行整合
 *@SpringBootTest(classes = {App.class}):1.当前类为springboot的测试类
 *@SpringBootTest(classes = {App.class}):2.加载SpringBoot启动类。启动springoot
 *junit与spring整合@Contextconfiguartion("classpath:applicationContext.xml")
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserServiceTest {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void testAddUser() {
		this.userServiceImpl.addUser();
	}
	
}
