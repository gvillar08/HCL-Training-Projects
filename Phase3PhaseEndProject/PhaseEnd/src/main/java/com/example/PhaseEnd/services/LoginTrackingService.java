package com.example.PhaseEnd.services;

import org.springframework.stereotype.Service;

@Service
public class LoginTrackingService		//a service for tracking if the user is logged in and authorized to access pages
{
	public String username;
	public String password;				//getters and setters
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isUserLoggedIn()		//checks if the user is logged in; returns false if username or passoword is empty, which indicates the program just booted or a user logged out
	{
		if(getUsername()==null||getPassword()==null)
			return false;
		return true;
	}
}