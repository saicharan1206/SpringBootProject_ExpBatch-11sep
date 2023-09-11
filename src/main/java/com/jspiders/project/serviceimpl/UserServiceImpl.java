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
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(UserRequestDTO userRequestDTO) {
		User save;
		User user=new User();
		if(userRepo.findByUserEmail(userRequestDTO.getUserEmail())==null){
			user.setUserEmail(userRequestDTO.getUserEmail().toLowerCase());
			user.setUserPassword(userRequestDTO.getUserPassword());
			save = userRepo.save(user);
			System.out.println(user.toString());
		}
		else {
			throw new UserExistsException("User already registered");
		}
		
		UserResponseDTO responseDTO = new UserResponseDTO();
		responseDTO.setUserId(save.getUserId());
		responseDTO.setUserEmail(save.getUserEmail());
		responseDTO.setCreatedBy(save.getCreatedBy());
		responseDTO.setCreatedDate(save.getCreatedDate());
		responseDTO.setUpdatedBy(save.getUpdatedBy());
		responseDTO.setUpdatedDate(save.getUpdatedDate());
		
		ResponseStructure<UserResponseDTO> responseStructure = new ResponseStructure<>();
		responseStructure.setData(responseDTO);
		responseStructure.setMessage("User registered successfully");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(responseStructure, HttpStatus.CREATED);
	}
	
}
