package com.pinku;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;

import com.pinku.config.RabbitMQConfiguration;

@SpringBootApplication
public class SpringBootJmsProducerApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJmsProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName, "message_routing_key", "Hello from RabbitMQ 2222!");
		System.out.println("Message sent successfully---------");
		
	}

}
