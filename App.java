package com.cts.hc.utility;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		String[] springConfig = { "jobConfig.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");

		Job job = (Job) context.getBean("claimJob");
		JobRepository repo = (JobRepository) context.getBean("jobRepository");
		JobExecution execution;

		execution = joblauncher.run(job, new JobParameters());

		System.out.println("spring Batch Claim Status......" + execution.getStatus());

	}

}
