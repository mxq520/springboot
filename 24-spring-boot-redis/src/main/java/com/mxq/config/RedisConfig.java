package com.mxq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 *完成对Redis的整合的一些配置 
 *
 */
@Configuration
public class RedisConfig {

	/**
	 * 1.创建JedisPoolConfig对象。在该对象中完成一些连接池配置
	 * @ConfigurationProperties:会将前缀相同的内容创建一个实体
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.redis.pool")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		//最大空闲数
//		config.setMaxIdle(10);
//		//最小空闲数
//		config.setMinIdle(5);
//		//最大连接数
//		config.setMaxTotal(20);
		System.out.println("默认值："+config.getMaxIdle());
		System.out.println("默认值："+config.getMinIdle());
		System.out.println("默认值："+config.getMaxTotal());
		
		return config;
	}
	
	/**
	 * 2.创建JedisConnectionFactory:配置redis连接信息
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.redis")
	public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig  config) {
		
		System.out.println("配置完毕："+config.getMaxIdle());
		System.out.println("配置完毕："+config.getMinIdle());
		System.out.println("配置完毕："+config.getMaxTotal());
		
		JedisConnectionFactory factory = new JedisConnectionFactory();
		//关联连接池的配置信息
		factory.setPoolConfig(config);
		
		//配置连接Redis的信息
//		factory.setHostName("127.0.0.1");
//		factory.setPort(6379);
		
		
		return factory;
	}
	
	/**
	 * 3.创建RedisTemplate：用于执行Redis操作方法
	 * 
	 */
	@Bean
	public RedisTemplate redisTemplate(JedisConnectionFactory factory) {
		
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		//关联
		template.setConnectionFactory(factory);
		
		//为key设置序列化器
		template.setKeySerializer(new StringRedisSerializer());
		//为value设置序列化器
		template.setValueSerializer(new StringRedisSerializer());
		
		return template;
	}
}
