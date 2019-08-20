package com.mxq.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SecondListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("SecondListener...init...........");
	}
}
