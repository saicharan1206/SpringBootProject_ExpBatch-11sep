package com.jspiders.project.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.EmailAlreadyExistsException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(UserRequestDTO userRequestDTO) {
		
		String email=userRequestDTO.getUserEmail().toLowerCase();
		User user1 = userRepo.findByUserEmail(email);
		
		if (user1==null) {
			User user = new User();
			user.setUserEmail(email);
			user.setUserPassword(userRequestDTO.getUserPassword());
//			user.setCreatedBy(userRequestDTO.getCreateBy());
//			user.setCreatedDate(LocalDateTime.now());
//			user.setUpdatedDate(LocalDateTime.now());
//			user.setUpdatedBy(userRequestDTO.getUpdatedBy());
			userRepo.save(user);
			UserResponseDTO respone = new UserResponseDTO();
			respone.setUserId(user.getUserId());
			respone.setUserEmail(user.getUserEmail());
			ResponseStructure<UserResponseDTO> structure = new ResponseStructure<UserResponseDTO>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("User data inserted Successfully!!!");
			structure.setData(respone);
			return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.CREATED);
		}
		else
			throw new EmailAlreadyExistsException(email+" This email already exists ");
			
	}
	
}
