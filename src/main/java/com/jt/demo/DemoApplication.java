package com.jt.demo;

import com.jt.demo.service.Amqp;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // ignore embeded database driver class error
public class DemoApplication {

    // Spring AMQP retures that the queue, exchange, and binding be declared as top level Spring bean
    public static final String topicExchangeName = "sprint-boot-exchange";
	private static final String queueName="testqueue";

	@Bean
    Queue queue() {
	    return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
	    return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
	    // Any msg send with a routing key beginning with foo.bar will be routed to the queue
	    return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    // ConnectionFactory is java solution, CachingConnectionFactory is spring solution
	@Bean
    public static CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory=new CachingConnectionFactory("rhino.rmq.cloudamqp.com");
        connectionFactory.setUsername("idosarnd");
        connectionFactory.setPassword("K1T59P-vGf6i8am6qRbi0ThMmQFHRZSE");
        connectionFactory.setVirtualHost("idosarnd");
        // TCP/IP connection failure handle
        // after 30 sec the peer TCP connection should be considered unreachable
        // heartbeat too low like 5sec can lead to fasle positives(peer being considered unavailable while it really isnt the case
        connectionFactory.setRequestedHeartBeat(30);
//        connectionFactory.setRequestedHeartbeat(30);  //ConnectionFactory function
        // Heartbeat frames are send about every timeout/2 seconds, after two missed heartbeats, the peer is considered to be unreachable
        connectionFactory.setConnectionTimeout(30000); // in milliseconds, zero for infinite

        return connectionFactory;
    }

    // Message listener container and receiver beans are all you need to listen for msg
    @Bean
    SimpleMessageListenerContainer container(CachingConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {

	    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setQueueNames(queueName);
	    container.setMessageListener(listenerAdapter);
	    return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Amqp receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
