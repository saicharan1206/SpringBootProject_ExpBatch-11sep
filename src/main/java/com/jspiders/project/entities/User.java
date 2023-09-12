package com.jspiders.project.entities;

import java.util.Date;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * Entity Listeners: These are custom classes that contain callback methods annotated with JPA annotations
 *  like @PrePersist, @PreUpdate, @PostPersist, @PostUpdate, etc.
 *  These methods are invoked by the JPA provider (like Hibernate) automatically when the corresponding entity events occur.
 * */


@Entity(name = "demo_User")
/*
 * EntityListeners Annotation: This annotation is applied to an entity class to specify which entity 
 * listener classes should be invoked for that entity.
 * @EntityListeners(AuditingEntityListener.class) is used to specify that the AuditingEntityListener class 
 * should listen to events related to the YourEntity class.
 * 
 * */
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userEmail;
	private String userPassord;

	@CreatedDate
	private Date createdDate;
	
	@CreatedBy
	private String createdBy;
	
	/*
	 * @CreatedDate annotation from Spring Data JPA to indicate that this field should be automatically
	 *  populated with the current date and time when an entity is persisted. 
	 */
	
	
	@LastModifiedDate
	private Date updatedDate;
	
	@LastModifiedBy
	private String updatedBy;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassord() {
		return userPassord;
	}

	public void setUserPassord(String userPassord) {
		this.userPassord = userPassord;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	


	
}
