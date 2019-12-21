package com.example.demo.business;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Picture;

@Service
public class Consumer {

	@RabbitListener(queues = "queue")
	public void listen(Picture message) throws InterruptedException {
		Thread.sleep(1000);
		//If exception is thrown, message won't be removed from queue..
		//U need to configure a dlx
		if(message.getSize()>900) {
			//Instead of throwing our custom excepption, we should throw provided by spring
		//	throw new PictureTooLargeException("Unable to process Image: " + message.getName());
			throw new AmqpRejectAndDontRequeueException("Unable to process Image: " + message.getName());
		}
		System.out.println(Thread.currentThread().getName()+ " consumed "+ message);
	}
	
}

//spin up 3 consumer threads