package org.yascode.notificationproducer.client.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.yascode.notificationproducer.client.service.RabbitMQClient;

@Service
@Slf4j
public class RabbitMQClientImpl implements RabbitMQClient {

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.management.port:15672}")
    private String managementPort;

    @Override
    public boolean checkExchangeExists(String exchangeName) {
        return false;
    }
}
