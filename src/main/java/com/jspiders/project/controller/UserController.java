package com.jspiders.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	
	@PostMapping("/users")
	public  ResponseEntity<ResponseStructure<UserResponseDTO>> userSave(@RequestBody UserRequestDTO userRequest)  {
		return service.userSave(userRequest);

}
}
