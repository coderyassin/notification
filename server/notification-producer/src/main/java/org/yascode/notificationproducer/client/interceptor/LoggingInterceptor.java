package org.yascode.notificationproducer.client.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("Request Headers: ");

        for (Map.Entry<String, List<String>> entry : request.getHeaders().entrySet()) {
            log.info("{}: {}",entry.getKey(), entry.getValue());
        }

        return execution.execute(request, body);
    }
}
