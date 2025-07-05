package com.syntaxzero.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.syntaxzero.taskmanager")
@EnableJpaRepositories(basePackages = "com.syntaxzero.taskmanager.repository")
@EntityScan(basePackages = "com.syntaxzero.taskmanager.model")
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

}