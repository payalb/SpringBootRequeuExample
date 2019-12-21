package com.example.demo.business;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Picture;

@Service
public class ProducerSendJson {

	@Autowired RabbitTemplate template;
	
	public void sendMessage(Picture p) {
		template.convertAndSend("queue", p);
	}
}
