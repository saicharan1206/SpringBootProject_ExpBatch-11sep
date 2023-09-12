package com.jspiders.project.entities;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jspiders.project.audit.Audit;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User extends Audit<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String email;
	private String password;
	//private LocalDateTime createdDate;
	//private String createdBy;
	//private LocalDateTime updatedDate;
	//private String updatedBy;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public LocalDateTime getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(LocalDateTime createdDate) {
//		this.createdDate = createdDate;
//	}
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	public LocalDateTime getUpdatedDate() {
//		return updatedDate;
//	}
//	public void setUpdatedDate(LocalDateTime updatedDate) {
//		this.updatedDate = updatedDate;
//	}
//	public String getUpdatedBy() {
//		return updatedBy;
//	}
//	public void setUpdatedBy(String updatedBy) {
//		this.updatedBy = updatedBy;
//	}
	
	
	
	
	

}
