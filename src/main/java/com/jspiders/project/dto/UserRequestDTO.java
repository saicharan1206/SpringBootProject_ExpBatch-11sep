package com.jspiders.project.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
@Component
public class UserRequestDTO 
{
	@Email(regexp = "[A-Z,a-z]{3,10}[0-9]{2,5}@gmail[.]com",message = "Email Shout be in The Form of @gmail.com")
	private String userEmail;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "8 characters mandatory(1 upperCase,1 lowerCase,1 special Character,1 number)")
	private String userPassword;

}
