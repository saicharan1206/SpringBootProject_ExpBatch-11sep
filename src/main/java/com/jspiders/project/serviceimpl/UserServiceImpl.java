package com.jspiders.project.serviceimpl;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Studentmanagement.util.ResponceStructure;
import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.EmailAllReadyFoundException;
import com.jspiders.project.exception.UserExistsException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepo repo;

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUserDetails(UserRequestDTO userRequest) {
		User save;
		User user=new User();
		if(repo.findByUserEmail(userRequest.getUserEmail())==null){
			user.setUserEmail(userRequest.getUserEmail().toLowerCase());
			user.setPassword(userRequest.getPassword());
			save = repo.save(user);
			System.out.println(user.toString());
		}
		else {
			throw new UserExistsException("User already registered");
		}
		
		UserResponseDTO responseDTO = new UserResponseDTO();
		responseDTO.setUserId(save.getUserId());
		responseDTO.setUserEmail(save.getUserEmail());
		responseDTO.setCreatedBy(save.getCreatedBy());
		responseDTO.setCreateDate(save.getCreateDate());
		responseDTO.setUpdatedBy(save.getUpdatedBy());
		responseDTO.setUpdatedDate(save.getUpdatedDate());
		
		ResponseStructure<UserResponseDTO> responseStructure = new ResponseStructure<>();
		responseStructure.setData(responseDTO);
		responseStructure.setMessage("User registered successfully");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(responseStructure, HttpStatus.CREATED);
	}
	
}
