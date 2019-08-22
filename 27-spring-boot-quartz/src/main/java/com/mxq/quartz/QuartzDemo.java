package com.mxq.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.mxq.service.UsersService;

/**
 * Job类
 *
 */
public class QuartzDemo implements Job {

	@Autowired
	private UsersService usersSeervice;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("execute........"+new Date());
		this.usersSeervice.addUsers();
	}

}
