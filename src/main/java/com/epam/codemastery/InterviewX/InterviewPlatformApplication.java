package com.epam.codemastery.InterviewX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.epam.codemastery.InterviewX.repository")
public class InterviewPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewPlatformApplication.class, args);
	}

}
