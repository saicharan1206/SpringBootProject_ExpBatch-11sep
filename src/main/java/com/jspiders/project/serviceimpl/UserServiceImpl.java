package com.jspiders.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.UserWithSameEmailExist;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	boolean flag;
	@Override
	public ResponseEntity<ResponseStructure> addUser(UserRequestDTO userRequestDTO) {
		User user = new User();
	
		
		user.setEmailId(userRequestDTO.getEmailId().toLowerCase());
		user.setPassword(userRequestDTO.getPassword());
           List<User> users = userRepo.findAll();
           for (User user2 : users) {
			if (user2.getEmailId().equals(user.getEmailId())) {
			   throw new UserWithSameEmailExist("Email id already in database");
			}
		}
		User user2 = userRepo.save(user);
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setEmailId(user2.getEmailId());
		userResponseDTO.setUserId(user2.getUserId());
		ResponseStructure<UserResponseDTO>responseStructure = new ResponseStructure<UserResponseDTO>();
		responseStructure.setData(userResponseDTO);
		responseStructure.setMessage("user data added successfully");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		return  new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
	}
	
}
