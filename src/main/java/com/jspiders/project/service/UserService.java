package com.jspiders.project.service;

import com.jspiders.project.dto.UserRequestDTO;
import com.jspiders.project.dto.UserResponseDTO;
import com.jspiders.project.utility.ResponseStructure;

public interface UserService {

	public ResponseStructure<UserResponseDTO> saveUser(UserRequestDTO user);


}
