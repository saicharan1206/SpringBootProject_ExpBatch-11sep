package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponse;
import com.jspiders.project.utility.ResponseStructure;

public interface UserService {
	
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequestDTO userRequset);

}
