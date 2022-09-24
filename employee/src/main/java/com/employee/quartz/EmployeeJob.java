package com.employee.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@DisallowConcurrentExecution
public class EmployeeJob implements Job {

  private static  final Logger log = LoggerFactory.getLogger(EmployeeJob.class);


  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.info("exceuting job");
    System.out.println("executing quart   job ");
  }
}
