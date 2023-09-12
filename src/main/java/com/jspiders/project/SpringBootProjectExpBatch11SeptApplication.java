package com.jspiders.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.jspiders.project.audit.AuditImplementation;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringBootProjectExpBatch11SeptApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectExpBatch11SeptApplication.class, args);
	}
	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditImplementation();
	}
}
