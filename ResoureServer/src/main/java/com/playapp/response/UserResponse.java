package com.playapp.response;

public class UserResponse {

	private String userId;
	private String lastname;

	
	public UserResponse(String userId, String lastname) {
		super();
		this.userId = userId;
		this.lastname = lastname;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
		
}
