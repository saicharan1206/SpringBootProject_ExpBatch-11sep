package com.jspiders.project.serviceimpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.UserEmailPresent;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;
	boolean flag;

	@Override
	public ResponseEntity<ResponseStructure> saveUser(UserRequestDTO userRequestDTO) {
		User user = new User();
	
		
		user.setUserEmail(userRequestDTO.getUserEmail().toLowerCase());
		user.setUserPassword(userRequestDTO.getUserPassword());
		user.setCreatedBy("M");
		user.setCreatedDate(LocalDateTime.now());
		user.setUpdatedBy("M");
		user.setUpdatedDate(LocalDateTime.now());
           List<User> user1 = repo.findAll();
           for (User users : user1) {
			if (users.getUserEmail().equals(user.getUserEmail())) {
			   throw new UserEmailPresent("Email ID is already Present!!!");
			}
		}
		User user2 = repo.save(user);
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setUserEmail(user2.getUserEmail());
		userResponseDTO.setUserId(user2.getUserId());
		ResponseStructure<UserResponseDTO>responseStructure = new ResponseStructure<UserResponseDTO>();
		responseStructure.setData(userResponseDTO);
		responseStructure.setMessage("user data added successfully");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		return  new ResponseEntity<ResponseStructure>(responseStructure,HttpStatus.CREATED);
	}
	
}