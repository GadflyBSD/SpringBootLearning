package com.hanwang.resttemplate;

import com.hanwang.resttemplate.component.BaiduMapRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestTemplateApplication implements CommandLineRunner {
	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run( RestTemplateApplication.class, args );
	}

	public void run(String[] args){
		BaiduMapRequest baiduMapRequest = context.getBean(BaiduMapRequest.class);
		baiduMapRequest.getBaiduMapForObject();
		System.out.println();
		baiduMapRequest.getBaiduMapForEntity();
		System.out.println();
		baiduMapRequest.getBaiduMapForObjectParam();
		System.out.println();
		baiduMapRequest.getBaiduMapForEntityParam();
		System.out.println();
		baiduMapRequest.getBaiduMapForObjectParam2();
		System.out.println();
		baiduMapRequest.getBaiduMapForEntityParam2();
	}

}
