package com.jspiders.project.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserResponse;
import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.UserAlreadyExist;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequestDTO request) {
	
			
			//user.setCreatedDate(LocalDateTime.now());
			

			User save=null;
			try {
				User user = new User();
				user.setUserEmail(request.getUserEmail().toLowerCase());
				user.setUserPassword(request.getPassword());
				save = repo.save(user);
			}
			catch (Exception e) {
				throw new UserAlreadyExist("user already exits");
			}
			

			UserResponse response = new UserResponse();
			response.setUserId(save.getUserId());
			response.setCreatedBy(save.getCreatedBy());
			response.setCreatedDate(save.getCreatedDate());
			response.setUpdatedBy(null);
			response.setUpdatedDate(null);

			ResponseStructure<UserResponse> responseStructure = new ResponseStructure<>();
			responseStructure.setData(response);
			responseStructure.setMessage("created sucesfully");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity(responseStructure, HttpStatus.CREATED);

		
		
	}

}
