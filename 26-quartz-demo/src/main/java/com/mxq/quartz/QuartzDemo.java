package com.mxq.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * ����������
 *
 */
public class QuartzDemo implements Job {

	/**
	 * ���񱻴���ʱ��ִ�еķ���
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("execute....."+new Date());
	}

}
