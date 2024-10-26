package org.yascode.notificationproducer.client.service;

import java.io.UnsupportedEncodingException;

public interface RabbitMQClient {
    boolean checkExchangeExists(String exchangeName);
}
