package com.jspiders.project.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class UserResponseDTO {
	private int userId;
	private String userEmail;
	private LocalDateTime createdDateTime;
	private String createdBy;
	private LocalDateTime updatedDateTime;
	private String updatedBy;
}
