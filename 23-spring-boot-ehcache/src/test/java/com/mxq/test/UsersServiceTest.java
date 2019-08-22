package com.mxq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxq.App;
import com.mxq.pojo.Users;
import com.mxq.service.UsersService;

/**
 *UsersService 测试 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UsersServiceTest {

	@Autowired
	private UsersService usersService;
	
	@Test
	public void testFindUserById() {
		//第一次查询
		System.out.println(this.usersService.findUserById(1));
		
		//第二次查询
		System.out.println(this.usersService.findUserById(1));
	}
	
	@Test
	public void testFindUserByPage() {
		Pageable pageable = new PageRequest(0, 2);
		//第一次查询
		System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		
		//第二次查询
		System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		
		//第三次查询
		Pageable pageable1 = new PageRequest(1, 2);
		System.out.println(this.usersService.findUserByPage(pageable1).getTotalElements());
		
	}
	
	@Test
	public void testFindAll() {
		//第一次查询
		System.out.println(this.usersService.findUserAll().size());
		
		Users user = new Users();
		user.setAddress("南京");
		user.setAge(23);
		user.setName("朱启");
		this.usersService.saveUsers(user);
		
		//第二次查询
		System.out.println(this.usersService.findUserAll().size());
		
	}
}
