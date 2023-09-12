package com.jspiders.project.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponse;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.UserAlreadyExistsException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequestDTO userRequestDTO) {
		User save;
		User user=new User();
		if(userRepo.findByUserEmail(userRequestDTO.getUserEmail())==null){
			user.setUserEmail(userRequestDTO.getUserEmail().toLowerCase());
			user.setUserpassword(userRequestDTO.getUserPassword());
			save = userRepo.save(user);
			System.out.println(user.toString());
		}
		else {
			throw new UserAlreadyExistsException("User already exists");
		}
		
		UserResponse responseDTO = new UserResponse();
		responseDTO.setUserId(save.getUserId());
		responseDTO.setUserEmail(save.getUserEmail());
		responseDTO.setCreatedBy(save.getCreatedBy());
		responseDTO.setCreatedDate(save.getCreatedDate());
		responseDTO.setUpdatedBy(save.getUpdatedBy());
		responseDTO.setUpdatedDate(save.getUpdatedDate());
		
		ResponseStructure<UserResponse> responseStructure = new ResponseStructure<>();
		responseStructure.setData(responseDTO);
		responseStructure.setMessage("User registered successfully");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure, HttpStatus.CREATED);
	}
	
}