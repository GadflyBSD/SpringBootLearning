package com.hanwang.web;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run( WebApplication.class, args );
		/*SpringApplication app = new SpringApplication(WebApplication.class);
		app.setBannerMode( Banner.Mode.OFF);
		app.run(args);*/
	}
}
