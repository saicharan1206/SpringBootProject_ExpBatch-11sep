package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.utility.ResponseStructure;

@Service
public interface UserService {
public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(UserRequestDTO user);
}
