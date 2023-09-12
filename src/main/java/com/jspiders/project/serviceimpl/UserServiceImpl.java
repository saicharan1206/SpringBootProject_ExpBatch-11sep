package com.jspiders.project.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.EmailAlreadyExists;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo repo;
	@Override
	
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(UserRequestDTO request) {
		String email = request.getEmail().toLowerCase();
		User user = new User();
		List<User> list = repo.findAll();
		boolean flag = true;
            if(!list.isEmpty()) {
            	for(int i=0; i<=list.size()-1; i++) {
    				if(list.get(i).getEmail().equalsIgnoreCase(email)) {
    					flag = false;	
    				}
    			}	
            }
            ResponseStructure<UserResponseDTO> structure = new ResponseStructure<>();
			if(flag == true) {
				user.setEmail(email);
				user.setPassword(request.getPassword());
			
				repo.save(user);
				
				UserResponseDTO response = new UserResponseDTO();
				response.setEmail(email);
				response.setMessage("Email saved sucessfully");
				
				
				structure.setStatusCode(HttpStatus.CREATED.value());
				structure.setMessage("Email saved sucessfully");
				structure.setData(response);
				
				
			}
			else {
				throw new EmailAlreadyExists(email, " Email cannot be saved");
			}

		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.CREATED );
	}
	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> updateUser(UserRequestDTO request, int userId) {
		Optional<User> user = repo.findById(userId);
		ResponseStructure<UserResponseDTO> structure = new ResponseStructure<>();
		if(!user.isEmpty())
		{
			User user1 = new User();
			user1.setID(userId);
			user1.setEmail(request.getEmail());
			user1.setPassword(request.getPassword());
			repo.save(user1);
			
			UserResponseDTO response = new UserResponseDTO();
			response.setEmail(request.getEmail());
			response.setMessage("Updated sucessfully");
			
			
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Data updated successfully");
			structure.setData(response);
			
			
			
		}
		
		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure, HttpStatus.OK) ;
	}
	
}
