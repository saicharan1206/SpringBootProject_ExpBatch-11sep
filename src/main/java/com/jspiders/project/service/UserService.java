package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.utility.ResponseStructure;

public interface UserService {
	public ResponseEntity<ResponseStructure<User>> saveUser(UserRequestDTO userRequestDTO);
}