package com.jspiders.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponse;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.EmailException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequestDTO userRequest){
		List<User>  users = repo.findAll();
		for(User user2 : users ) {
			if(user2.getUserEmail().equalsIgnoreCase(userRequest.getUserEmail())) {
				throw new EmailException("email is already Present");
			}
		}
		 
		User user  = new User();
		user.setUserEmail(userRequest.getUserEmail().toLowerCase());
		user.setUserPassord(userRequest.getUserPassord());
		User user1 = repo.save(user);

	   UserResponse response = new UserResponse();
	   response.setUserId(user1.getUserId());
	   response.setUserEmail(user1.getUserEmail());

	   ResponseStructure<UserResponse> structure = new  ResponseStructure<UserResponse>();
	   structure.setStatusCode(HttpStatus.OK.value());
	   structure.setMessage("User Saved Succssefully");
	   structure.setData(response);
	   return new ResponseEntity<ResponseStructure<UserResponse>>(structure, HttpStatus.OK);	
		}
	}
	

