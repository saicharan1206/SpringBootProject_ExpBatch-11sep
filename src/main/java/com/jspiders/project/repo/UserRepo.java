package com.jspiders.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jspiders.project.entities.User;

public interface UserRepo  extends JpaRepository<User, Integer> {
	
	public User findByUserEmail(String email);
	
}
