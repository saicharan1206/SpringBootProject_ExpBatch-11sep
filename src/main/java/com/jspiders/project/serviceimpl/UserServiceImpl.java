package com.jspiders.project.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.UserAlreadyExist;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	@Autowired
	private UserResponseDTO dto;
	
	@Override
	public ResponseStructure<UserResponseDTO> insertUserDetails(UserRequestDTO userData) {
			User user1=new User();
			user1.setCreatedDate(LocalDateTime.now());
			user1.setEmailId(userData.getEmailId().toLowerCase());
			user1.setPassword(userData.getPassword());
			User user2=null;
			try {
				user2=repo.save(user1);
			}
			catch (Exception e) {
				throw new UserAlreadyExist("User Details are already exist");
			}
			dto.setUserId(user2.getUserId());
			dto.setEmailId(user2.getEmailId());
			dto.setCreatedBy(user2.getCreatedBy());
			dto.setCreatedDate(user2.getCreatedDate());
			dto.setUpdateDate(user2.getUpdateDate());
			dto.setUpdatedBy(user2.getUpdatedBy());
		ResponseStructure<UserResponseDTO> structure=new ResponseStructure<>();
		structure.setData(dto);
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("User Details Saved Successfully");
		return structure;
	}
		
 }

