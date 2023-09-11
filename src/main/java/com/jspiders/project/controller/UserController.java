package com.jspiders.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveData(@RequestBody User user)
	{
		return service.saveData(user);
	}

}
