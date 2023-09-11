package com.jspiders.project.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.UserExistsException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(UserRequestDTO user) {
		User user2 = new User();
		if(userRepo.findByUserEmail(user.getUserEmail())==null)
		{
			user2.setUserEmail(user.getUserEmail().toLowerCase());
			user2.setUserPassword(user.getUserPassword());
			User user1 = userRepo.save(user2);
			
			UserResponseDTO response = new UserResponseDTO();
			response.setUserId(user1.getUserId());
			response.setUserEmail(user1.getUserEmail());
			response.setUserPassword(user1.getUserPassword());
			response.setCreatedDate(user1.getCreatedDate());
			response.setCreatedBy(user1.getCreatedBy());
			response.setUpdatedDate(user1.getUpdatedDate());
			response.setUpdatedBy(user1.getUpdatedBy());
			
			ResponseStructure<UserResponseDTO> structure = new ResponseStructure<UserResponseDTO>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("user data sucessfully");
			structure.setData(response);
			return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.CREATED);
		}
		else
		{
			throw new UserExistsException("user is already exists");
		}
	}

	
	
}
