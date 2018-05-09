package com.jt.demo.service;

import com.jt.demo.DemoApplication;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

// spring.io/guides/gs/messaging-rabbitmq
@Component
public class Amqp {

    public void receiveMessage(Object message) {
        System.out.println("Received <" + message + ">");
    }

    public void sendMessage(String message) {
        CachingConnectionFactory connectionFactory = null;
        connectionFactory = DemoApplication.connectionFactory();

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.convertAndSend(DemoApplication.topicExchangeName, "foo.bar.baz", message);
    }
}
