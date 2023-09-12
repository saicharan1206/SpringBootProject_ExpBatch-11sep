package com.jspiders.project.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditImplementation implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
	return Optional.of("Arpitha P");
	}

}
