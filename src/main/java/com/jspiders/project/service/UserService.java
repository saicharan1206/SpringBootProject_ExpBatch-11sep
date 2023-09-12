package com.jspiders.project.service;

import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.utility.ResponseStructure;

@Service
public interface UserService {

	
	public ResponseStructure<UserResponseDTO> insertUserDetails(UserRequestDTO user);


}
