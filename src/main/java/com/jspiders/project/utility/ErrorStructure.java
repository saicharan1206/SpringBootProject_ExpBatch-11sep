package com.jspiders.project.utility;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorStructure 
{
	private LocalDateTime localDateTime;
	private int statusCode;
	private String message;
	private String rootCause;

}
