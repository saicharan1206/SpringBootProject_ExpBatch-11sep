package com.jspiders.project.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class Audtingconfi {

	@Bean
	public Auditingimpl auditorAware(){
		return new Auditingimpl();
	}
}
