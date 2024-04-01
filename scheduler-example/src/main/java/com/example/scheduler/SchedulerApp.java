package com.example.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerApp {

	@Scheduled(fixedRate = 2000)
	public void printText() {
		System.out.println("This is a scheduler message.");
	}

	@Scheduled(cron = "* 0/1 * * * ?")
	public void scheduleTask() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

		String strDate = dateFormat.format(new Date());

		System.out.println("Cron job Scheduler: Job running at - " + strDate);
	}
}
