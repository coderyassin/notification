package org.yascode.notificationproducer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yascode.notificationproducer.client.service.RabbitMQClient;

import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Properties;

@Configuration
@Slf4j
public class RabbitMQConfig {

    private final RabbitMQClient rabbitMQClient;

    public RabbitMQConfig(RabbitMQClient rabbitMQClient) {
        this.rabbitMQClient = rabbitMQClient;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean("notification_queue")
    public Queue createQueueIfNotExist(RabbitAdmin rabbitAdmin) {
        String queueName = "notification_queue";
        Properties queueProperties = rabbitAdmin.getQueueProperties(queueName);

        if (Objects.isNull(queueProperties)) {
            log.info("Queue does not exist. Creating queue: {}", queueName);
            return new Queue(queueName, true);
        }

        log.info("Queue exists: {}", queueName);
        log.info("Queue properties: {}", queueProperties);
        return new Queue(queueName);
    }

    @Bean("notification_exchange")
    public TopicExchange createExchangeIfNotExist() throws UnsupportedEncodingException {
        String exchangeName = "notification_exchange";

        if (exchangeExists(exchangeName)) {
            log.info("Exchange exists: {}", exchangeName);
        }

        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding(Queue notification_queue, TopicExchange notification_exchange) {
        return BindingBuilder
                .bind(notification_queue)
                .to(notification_exchange)
                .with("notification_routing_key");
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    boolean exchangeExists(String exchangeName) {
        return rabbitMQClient.checkExchangeExists(exchangeName);
    }

}
