package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.utility.ResponseStructure;

public interface UserService {
	public ResponseEntity<ResponseStructure<UserResponseDTO>> userDetails(UserRequestDTO userRequestDTO);
}
