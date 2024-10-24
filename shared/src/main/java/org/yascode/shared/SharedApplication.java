package org.yascode.shared;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.yascode"})
public class SharedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharedApplication.class, args);
    }

}
