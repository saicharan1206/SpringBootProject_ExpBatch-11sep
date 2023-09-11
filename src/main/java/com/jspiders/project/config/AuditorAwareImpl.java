package com.jspiders.project.config;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component

public class AuditorAwareImpl  implements AuditorAware<String>{
	@Override
	public Optional getCurrentAuditor() {

		return Optional.of("Deepak");
	}

}
