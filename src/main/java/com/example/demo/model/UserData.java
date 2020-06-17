package com.example.demo.model;

public class UserData {
	private Integer userId;
	private String userName;
	private String userRole;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserData(Integer userId, String userName, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public UserData() {

	}
}
