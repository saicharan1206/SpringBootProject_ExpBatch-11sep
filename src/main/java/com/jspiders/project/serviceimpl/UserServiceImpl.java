package com.jspiders.project.serviceimpl;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.UserFoundByEmail;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo repo;
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> userDetails(UserRequestDTO userRequestDTO) {
		String email= userRequestDTO.getEmail().toLowerCase();
		User user=new User();
		List<User> emailList=repo.findAll();
		boolean flag=true;
		if(!emailList.isEmpty())
		{
			for(int i=0;i<=emailList.size()-1;i++) {
				if(emailList.get(i).getEmailId().equalsIgnoreCase(email))
				{
					flag=false;
				}
			}
		}
		ResponseStructure<UserResponseDTO> structure=new ResponseStructure<UserResponseDTO>();
		if(flag==true) {
			user.setEmailId(email);
			user.setPassword(userRequestDTO.getPassword());
			repo.save(user);
			
			UserResponseDTO response=new UserResponseDTO();
			response.setEmailId(email);
			
			structure.setStatusCode(HttpStatus.OK.value());;
			structure.setMessage("Email ID saved successfully!!");
			structure.setData(response);
			return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.CREATED);
		}
		else
		{
			throw new UserFoundByEmail("Email ID exist in database!!");
		}
	}
}
