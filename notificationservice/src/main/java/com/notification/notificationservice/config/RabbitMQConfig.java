//
package com.notification.notificationservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class RabbitMQConfig {
//
//    @Value("${rabbitmq.queue.name}")
//    private String queueName;
//
//    @Value("${rabbitmq.exchange.name}")
//    private String exchangeName;
//
//    @Value("${rabbitmq.routing.key}")
//    private String routingKey;
//
//    // Define the queue (durable)
//    @Bean
//    public Queue notificationQueue() {
//        return new Queue(queueName, true);
//    }
//
//    // Define the topic exchange
//    @Bean
//    public TopicExchange notificationExchange() {
//        return new TopicExchange(exchangeName);
//    }
//
//    // Bind the queue to the exchange with routing key
//    @Bean
//    public Binding binding() {
//        return BindingBuilder
//                .bind(notificationQueue())
//                .to(notificationExchange())
//                .with(routingKey);
//    }
//
//    // JSON converter for automatic POJO-to-JSON conversion
//    @Bean
//    public MessageConverter messageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    // Configure RabbitTemplate
//    @Bean
//    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(messageConverter());
//        return template;
//    }
//}

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "notificationQueue";

    @Bean
    public Queue queue() {
        // durable = true makes sure queue survives restarts and isn't auto-deleted
        return new Queue(QUEUE_NAME, true);
    }
}
