package com.jspiders.project.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class UserResponseDTO 
{
	private int userId;
	private String userEmail;
	private LocalDateTime createdDate;
	private String createdBy="BHOJESHMANU";
	private LocalDateTime updatedDate;
	private String updatedBy;

}
