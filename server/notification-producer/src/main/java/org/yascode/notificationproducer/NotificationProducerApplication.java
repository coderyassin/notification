package org.yascode.notificationproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yascode.domain.repository.NotificationRepository;

@SpringBootApplication(scanBasePackages = {"org.yascode.*"})
public class NotificationProducerApplication {
	private final NotificationRepository notificationRepository;

    public NotificationProducerApplication(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(NotificationProducerApplication.class, args);
	}

}
