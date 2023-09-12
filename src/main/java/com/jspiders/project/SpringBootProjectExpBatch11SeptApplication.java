package com.jspiders.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*
 * @EnableJpaAuditing. This annotation will enable auditing for your JPA entities and automatically populate the createdTime field 
 * with the current timestamp when an entity is created.
 */
@EnableJpaAuditing
public class SpringBootProjectExpBatch11SeptApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectExpBatch11SeptApplication.class, args);
	}

}
