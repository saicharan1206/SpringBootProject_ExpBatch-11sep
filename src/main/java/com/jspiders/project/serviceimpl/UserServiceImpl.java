package com.jspiders.project.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.EmailAlreadyExistException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	
	

	
	@Override
	public  ResponseEntity<ResponseStructure<UserResponseDTO>> userSave(UserRequestDTO userRequest)  {
	
		List<User> userList=repo.findAll();
		
		User user = new User();
		
	if(userList!=null)
	{
		for(User ele:userList)
		{
			if(ele.getUserEmail().equalsIgnoreCase(userRequest.getUserEmail()))
			{
				throw new EmailAlreadyExistException("DATA IS NOT SAVED ");
			}
		}
	}
		user.setUserEmail(userRequest.getUserEmail().toLowerCase());
		user.setUserPassword(userRequest.getUserPassword());
		repo.save(user);

		UserResponseDTO response = new UserResponseDTO();
		response.setUserEmail(userRequest.getUserEmail());
		
		ResponseStructure<UserResponseDTO> responseStructure = new ResponseStructure<UserResponseDTO>();
		responseStructure.setData(response);
		responseStructure.setMessage("DATA SAVED SUCCESSFULL");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		
		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(responseStructure,HttpStatus.OK);
		
	}
	
}
