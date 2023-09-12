package com.jspiders.project.serviceimpl;


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
	private UserResponseDTO responseDTO;

	
	@Override
	public ResponseStructure<UserResponseDTO> saveUser(UserRequestDTO userdata) 
	{
		   String email = userdata.getUserEmail().toLowerCase();
		   User userExist = repo.findByUserEmail(email);
		   if(userExist!=null)
		   {
			   throw new UserAlreadyExist(email+"  User Already Exist ");
		   }
		    User user1=new User();
			user1.setUserEmail(email);
			user1.setUserPassword(userdata.getUserPassword());
			
			
		    User user = repo.save(user1);	
		
		   
			responseDTO.setUserId(user.getUserId());
			responseDTO.setUserEmail(user.getUserEmail());
			responseDTO.setCreatedBy(user.getCreatedBy());
			responseDTO.setCreatedDate(user.getCreatedDate());
			responseDTO.setUpdatedBy(user.getUpdatedBy());
			responseDTO.setUpdatedDate(user.getUpdatedDate());
			
			ResponseStructure<UserResponseDTO> response=new ResponseStructure<>();
			response.setData(responseDTO);
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage("User Data Saved Successfully!!!!!");
			
			return response;
	
	}
	
	
}
