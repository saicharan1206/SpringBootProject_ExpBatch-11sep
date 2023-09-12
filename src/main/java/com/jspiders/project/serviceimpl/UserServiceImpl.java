package com.jspiders.project.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.UserEmailAlreadyExistException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;
	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(UserRequestDTO request) {

			User user = new User();
			user.setUserEmail(request.getUserEmail().toLowerCase());
			user.setPassword(request.getPassword());
			 try {
				 user= repo.save(user);
			 }
			 catch (Exception e) {
				throw new UserEmailAlreadyExistException("Email is already exist!!");
			}
			UserResponseDTO responseDTO = new UserResponseDTO();
			responseDTO.setUserId(user.getUserId());
			responseDTO.setUserEmail(user.getUserEmail());
			responseDTO.setCreatedDateTime(user.getCreatedDateTime());
			responseDTO.setCreatedBy(user.getCreatedBy());
			
			ResponseStructure<UserResponseDTO> structure = new ResponseStructure<>();
			structure.setData(responseDTO);
			structure.setMessage("user data added successfully!!!");
			structure.setStatusCode(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.CREATED);	
		
	}
	
}
