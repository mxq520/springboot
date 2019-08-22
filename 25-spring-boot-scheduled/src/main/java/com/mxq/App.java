package com.mxq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *scheduled 
 *
 */
@SpringBootApplication
//@EnableScheduling:开起scheduled
@EnableScheduling
public class App {

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}

}
