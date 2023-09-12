package com.jspiders.project.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class AuditingConfig {
	@Bean
	public AuditingImpl auditAware() {
		return new AuditingImpl();
	}
}
