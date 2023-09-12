package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.utility.ResponseStructure;


public interface UserService {
	/**
	 * This method is to save user data*/
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(UserRequestDTO request);
	public ResponseEntity<ResponseStructure<UserResponseDTO>> updateUser(UserRequestDTO request, int userID);
}

