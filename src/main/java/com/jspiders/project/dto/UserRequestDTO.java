package com.jspiders.project.dto;

public class UserRequestDTO {

	private String userEmail;
	private String userPassword;
//	private String createdBy;
//	private String updatedBy;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

//	public String getCreateBy() {
//		return createdBy;
//	}
//
//	public void setCreateBy(String createBy) {
//		this.createdBy = createBy;
//	}
//
//	public String getUpdatedBy() {
//		return updatedBy;
//	}
//
//	public void setUpdatedBy(String updatedBy) {
//		this.updatedBy = updatedBy;
//	}

}
