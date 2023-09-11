package com.jspiders.project.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.UserAlreadyExsistException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveData(User user) {
	User user1 = new User();
	if(repo.findByUserEmail(user.getUserEmail())==null)
	{
		user.setUserEmail(user.getUserEmail().toLowerCase());
		user1 = repo.save(user);
		
		UserResponseDTO response = new UserResponseDTO();
		response.setUserId(user1.getUserId());
		response.setUserEmail(user1.getUserEmail());
		response.setUserPassword(user1.getUserPassword());
		response.setCreatedDate(user1.getCreatedDate());
		response.setCreatedBy(user1.getCreatedBy());
		response.setLastUpdatedBy(user1.getLastUpdatedBy());
		response.setLastUpdatedDate(user1.getLastUpdatedDate());
		
		ResponseStructure<UserResponseDTO> structure = new ResponseStructure<UserResponseDTO>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("user data sucessfully");
		structure.setData(response);
		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.CREATED);
	}
	else
	{
		throw new UserAlreadyExsistException("user is already exists");
	}
	 
	}

	
}
