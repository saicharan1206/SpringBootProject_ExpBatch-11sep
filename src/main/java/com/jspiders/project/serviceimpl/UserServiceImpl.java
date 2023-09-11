package com.jspiders.project.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.entities.User;
import com.jspiders.project.exception.EmailAlreadyFoundException;
import com.jspiders.project.repo.UserRepo;
import com.jspiders.project.service.UserService;
import com.jspiders.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> saveUser(UserRequestDTO userRequest) {
		
		String email = userRequest.getUserEmail().toLowerCase();
		User object = repo.findByUserEmail(email);
		if(object==null) {
			User user = new User();
			user.setUserEmail(email);
			user.setUserPassword(userRequest.getUserPassword());
			user.setCreatedBy("SEENU");
			
	 /** Because of the EnableJpaAuditing & @EntityListeners(AuditingEntityListener.class) **/
			/** Created Date -- user.setCreatedDate(LocalDateTime.now());**/
			/** Updated Date -- user.setUpdatedDate(LocalDateTime.now());**/
			// UpdatedBy
			
			User user2 = repo.save(user);
			
			UserResponseDTO response = new UserResponseDTO();
			response.setUserEmail(user2.getUserEmail());
			response.setUserId(user2.getUserId());
			
			ResponseStructure<UserResponseDTO> structure = new ResponseStructure<UserResponseDTO>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("User Data inserted Successfully");
			structure.setData(response);
			
			return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure, HttpStatus.CREATED);
		}
		
		throw new EmailAlreadyFoundException("This Email is not applicable");	
	}
}
