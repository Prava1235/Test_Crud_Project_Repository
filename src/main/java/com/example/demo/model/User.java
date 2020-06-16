package com.example.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.annotation.*;
import io.swagger.annotations.ApiModelProperty;

@Table(name = "User")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int userId;
	@ApiModelProperty(notes = "The User Name")
	@NotEmpty(message = "User name cann't be blank")
	@Column(name = "username")
	private String userName;
	@NotNull
	@Column(name = "user_role")
	private String userRole;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public User(int userId, String userName, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
	}

	public User() {

	}
}
