package com.jspiders.project.service;

import org.springframework.http.ResponseEntity;
import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponse;
import com.jspiders.project.utility.ResponseStructure;

public interface UserService {
	/**
	 * This method is used to save the user to the database */
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequestDTO userRequestDTO);


}
