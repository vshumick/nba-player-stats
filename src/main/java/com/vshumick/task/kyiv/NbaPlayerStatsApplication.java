package com.vshumick.task.kyiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.vshumick.task.kyiv.repository")
public class NbaPlayerStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaPlayerStatsApplication.class, args);
	}

}
