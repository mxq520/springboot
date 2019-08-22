package com.mxq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxq.pojo.Users;

/**
 *spring Data Redis测试 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RedisTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 添加一个字符串
	 */
	@Test
	public void testSet() {
		this.redisTemplate.opsForValue().set("key", "北京尚学堂");
	}
	
	/**
	 * 获取一个字符串
	 */
	@Test
	public void testGet() {
		String value = (String) this.redisTemplate.opsForValue().get("key");
		System.out.println(value);
	}
	
	/**
	 * 添加一个Users对象
	 */
	@Test
	public void testSetUsers() {
		Users user = new Users();
		user.setAge(20);
		user.setId(1);
		user.setName("张三丰");
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("user", user);
	}
	
	/**
	 * 取Users对象
	 */
	@Test
	public void testGetUsers() {
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Users user = (Users) this.redisTemplate.opsForValue().get("user");
		System.out.println(user);
	}
	
	/**
	 * 添加一个json格式对象
	 */
	@Test
	public void testSetJsonUsers() {
		Users user = new Users();
		user.setAge(23);
		user.setId(2);
		user.setName("张四丰");
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		this.redisTemplate.opsForValue().set("user_json", user);
	}
	
	/**
	 * 取一个json格式对象
	 */
	@Test
	public void testGetJsonUsers1() {
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users user = (Users)this.redisTemplate.opsForValue().get("user_json");
		System.out.println(user);
	}
	
}
