package com.jspiders.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.serviceimpl.UserServiceImpl;
import com.jspiders.project.utility.ResponseStructure;

@RestController
//@RequestMapping("/users")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	@PostMapping("/users/save")
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(@RequestBody UserRequestDTO user){
		return userServiceImpl.saveUser(user);
	}
}
