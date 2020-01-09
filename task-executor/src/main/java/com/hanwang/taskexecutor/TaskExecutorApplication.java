package com.hanwang.taskexecutor;

import com.hanwang.taskexecutor.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class TaskExecutorApplication implements CommandLineRunner {
	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run( TaskExecutorApplication.class, args );
	}

	@Override
	public void run(String... strings){
		AsyncService asyncService = context.getBean(AsyncService.class);
		try {
			for (int i = 0; i < 10; i++) {
				asyncService.executeAsync1();
				asyncService.executeAsync2();
			}
			Thread.sleep(1000);
			// 阻塞调用
			asyncService.sayHello("带返回值的异步任务").get();
			// 限时调用
			asyncService.sayHello("带返回值的异步任务").get(1, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
	}

}