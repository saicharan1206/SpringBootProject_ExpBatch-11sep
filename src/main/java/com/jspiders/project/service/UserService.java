package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;

import com.example.Studentmanagement.util.ResponceStructure;
import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.EmailAllReadyFoundException;
import com.jspiders.project.utility.ResponseStructure;

public interface UserService {
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUserDetails(UserRequestDTO userRequest);

}
