package com.jspiders.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.emailIdAlreadyPresentException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public ResponseEntity<ResponseStructure> createUser(UserRequestDTO userDTO) {
		User user =new User();
				
		user.setEmail(userDTO.getEmail().toLowerCase());
		user.setPassword(userDTO.getPassword());
	
		List<User> findAllUsers = repo.findAll();
		
		for (User user2 : findAllUsers) {
			if(user2.getEmail().equals(user.getEmail())) {
				throw new emailIdAlreadyPresentException("Email is already present in database");
			}
		}
		
			User saveUser = repo.save(user);
			UserResponseDTO userResponse = new UserResponseDTO();
			userResponse.setUserId(saveUser.getUserId());
			userResponse.setEmail(saveUser.getEmail());
			
			ResponseStructure<UserResponseDTO> responseStructure = new ResponseStructure<UserResponseDTO>();
			responseStructure.setData(userResponse);
			responseStructure.setMessage("New user created");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure>(responseStructure, HttpStatus.CREATED);
	}

	 
}
