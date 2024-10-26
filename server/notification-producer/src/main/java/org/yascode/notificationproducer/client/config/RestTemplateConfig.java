package org.yascode.notificationproducer.client.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.yascode.notificationproducer.client.interceptor.LoggingInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Configuration
public class RestTemplateConfig {
    @Bean("restTemplateClient")
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

        if (Objects.isNull(interceptors)) {
            interceptors = new ArrayList<>();
        }

        interceptors.add(new LoggingInterceptor());
        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }
}
