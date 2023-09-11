package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.utility.ResponseStructure;

public interface UserService {

	public ResponseEntity<ResponseStructure> createUser(UserRequestDTO userDTO);
	
}
