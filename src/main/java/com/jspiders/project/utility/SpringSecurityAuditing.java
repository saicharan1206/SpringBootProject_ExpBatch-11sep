package com.jspiders.project.utility;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditing implements AuditorAware<String>
{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("BHOJESHMANU");
	}
	

}
