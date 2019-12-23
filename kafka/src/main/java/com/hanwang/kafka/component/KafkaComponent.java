package com.hanwang.kafka.component;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.kafka.annotation.EnableKafka;import org.springframework.kafka.annotation.KafkaListener;import org.springframework.kafka.core.KafkaTemplate;import org.springframework.stereotype.Component;import java.time.LocalDateTime;import java.time.format.DateTimeFormatter;import java.util.Scanner;@Component@EnableKafkapublic class KafkaComponent {	@Autowired	private KafkaTemplate kafkaTemplate;	@KafkaListener(topics = "test")	public void onMessage(String message){		System.out.println("===============================================================================");		System.out.println("消费端接收到：" + message);		System.out.println();	}	public void sendMessage() {		System.out.println();		Scanner scanner = new Scanner(System.in);		System.out.print("请输入您需要发送的消息：");		String message = scanner.nextLine();		if (message.isEmpty()) message = "我什么都没有说！";		send(message);	}	private void send(String message){		String now = LocalDateTime.now().format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));		kafkaTemplate.send("test","key",message + " >>> "  + now);	}}