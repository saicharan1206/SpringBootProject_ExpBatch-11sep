package com.jspiders.project.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "aware")
public class UserConfig {

	@Bean
	public AuditorAware<String> aware(){
		return() -> Optional.of("Partha");
	}
}
