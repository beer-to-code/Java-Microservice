package com.cts.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@Configuration
@EnableFeignClients
public class ConsumerMicroserviceApplication {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerMicroserviceApplication.class);

	public static void main(String[] args) {
		logger.info("Spring Boot Application For Consumer Microservice Started");
		SpringApplication.run(ConsumerMicroserviceApplication.class, args);
	}

}
