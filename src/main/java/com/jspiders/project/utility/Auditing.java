package com.jspiders.project.utility;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
//@Entity
@Component
public class Auditing {

	@CreatedBy
	String createdBy;
	@CreatedDate
	LocalDateTime createdDate;
	@LastModifiedBy
	String lastmodifiedby;
	@LastModifiedDate
	LocalDateTime lastmodifieddate;
}
