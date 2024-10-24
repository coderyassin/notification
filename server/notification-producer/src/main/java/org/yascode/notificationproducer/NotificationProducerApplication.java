package org.yascode.notificationproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.yascode.*"})
public class NotificationProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationProducerApplication.class, args);
	}

}
