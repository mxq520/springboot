package com.mxq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *spring boot 整合Quartz案例 
 *
 */
@SpringBootApplication
@EnableScheduling
public class App {

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}

}
