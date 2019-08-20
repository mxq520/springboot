package com.mxq;

import java.io.FileNotFoundException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.mxq.mapper")   //@MapperScan  用于扫描MyBatis的Mapper接口
public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		SpringApplication.run(App.class, args);

	}

}
