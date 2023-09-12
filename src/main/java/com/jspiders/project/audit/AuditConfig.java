package com.jspiders.project.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditConfig implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Preetham");
	}

}

/*
 * The AuditorAware interface defines a single method, getCurrentAuditor(), 
 * which returns an optional value representing the current auditor 
 * (usually the currently authenticated user or system user) as determined by your application. 
 * This method is called by Spring Data JPA when it needs to populate auditing fields.*/
