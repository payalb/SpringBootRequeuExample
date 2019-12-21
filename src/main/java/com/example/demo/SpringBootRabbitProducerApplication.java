package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.business.ProducerSendJson;
import com.example.demo.dto.Picture;

@SpringBootApplication
public class SpringBootRabbitProducerApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringBootRabbitProducerApplication.class, args);
		ProducerSendJson producer=ctx.getBean(ProducerSendJson.class);
	//	for(int i=1; i<=100; i++) {
			Picture p= new Picture(String.valueOf(1),"http://localhost:8080/"+1,90000);
			producer.sendMessage(p);
		//}
		ctx.registerShutdownHook();
	}

}
