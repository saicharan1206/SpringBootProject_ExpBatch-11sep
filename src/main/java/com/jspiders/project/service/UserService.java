package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.utility.ResponseStructure;



public interface UserService {
	
/**
 * THIS METHOD IS TO SAVE THE USER DETAILS*/
	public  ResponseEntity<ResponseStructure<UserResponseDTO>> userSave(UserRequestDTO userRequest);

}
