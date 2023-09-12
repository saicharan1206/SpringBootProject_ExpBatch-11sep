package com.jspiders.project.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Auditable
{
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private LocalDateTime createdDate;
	@CreatedBy
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private LocalDateTime updatedDate;
	@LastModifiedBy
	private String updatedBy;

}
