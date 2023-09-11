package com.jspiders.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.project.dto.UserRequestDTO;


import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@RestController
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("user/add")
	public ResponseEntity<ResponseStructure> addUser(@RequestBody @Validated UserRequestDTO requestDTO) {
		return userService.addUser(requestDTO);
	}
}
