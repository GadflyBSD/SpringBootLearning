package com.hanwang.scheduled;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;

@EnableScheduling
@SpringBootApplication
public class ScheduledApplication implements CommandLineRunner, SchedulingConfigurer {

	public static void main(String[] args) {
		SpringApplication.run( ScheduledApplication.class, args );
	}

	@Override
	public void run(String... strings){
		System.out.println("-----------------------开始执行任务--------------------------");
		System.out.println();
	}

	/**
	 * 执行定时任务.
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(
				//1.添加任务内容(Runnable)
				() -> initializeTasks(),
				//2.设置执行周期(Trigger)
				triggerContext -> {
					String cron = "0/2 * * * * ?";
					return new CronTrigger(cron)
							.nextExecutionTime(triggerContext);
				}
		);
	}

	private void initializeTasks(){
		System.out.println("----------------------------------------------------------------------");
		System.out.println("执行定时任务: " + LocalDateTime.now().toLocalTime());
		System.out.println();
	}

}
