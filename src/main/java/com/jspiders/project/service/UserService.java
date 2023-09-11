package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.utility.ResponseStructure;
public interface UserService {
	/**
	 * This method is used to save the user to the database*/
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(UserRequestDTO userRequestDTO);
}