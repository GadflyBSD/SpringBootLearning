package com.hanwang.kafka;

import com.hanwang.kafka.component.KafkaComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {
	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		/*SpringApplication app = new SpringApplication(KafkaApplication.class);
		app.setBannerMode( Banner.Mode.OFF);
		app.run(args);*/
		SpringApplication.run( KafkaApplication.class, args );
	}

	@Override
	public void run(String... strings){
		KafkaComponent kafkaComponent = context.getBean( KafkaComponent.class);
		kafkaComponent.sendMessage();
	}

}
