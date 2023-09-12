package com.jspiders.project.utility;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
@Data
@MappedSuperclass
@Component
public class Auditing {
	@CreatedBy
	private String createdBy;
	@CreatedDate
	private LocalDateTime createdDateTime;
	@LastModifiedBy
	private String updatedBy;
	@LastModifiedDate
	private LocalDateTime updatedDateTime;
	
}
