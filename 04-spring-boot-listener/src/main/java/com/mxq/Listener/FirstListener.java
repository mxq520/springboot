package com.mxq.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * SpringBoot整合listener
 *
 *<listener>
 *	<listener-class>com.mxq.Listener.FirstListener</listener-class>
 *</listener>
 */
@WebListener
public class FirstListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("Listener...init.........");
		
	}
}
