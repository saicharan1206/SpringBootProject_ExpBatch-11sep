package com.jspiders.project.auditfields;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		
		return Optional.of("Anusha");
	}

}
