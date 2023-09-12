package com.jspiders.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.project.dto.UserResponse;
import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(@RequestBody  UserRequestDTO request ){
		return	service.saveUser(request);
		
	}
}
