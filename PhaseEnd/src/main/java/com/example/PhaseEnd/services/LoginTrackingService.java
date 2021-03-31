package com.example.PhaseEnd.services;

import org.springframework.stereotype.Service;

@Service
public class LoginTrackingService
{
	public String username;
	public String password;
	
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
	
	public boolean isUserLoggedIn()
	{
		if(getUsername()==null||getPassword()==null)
			return false;
		return true;
	}
}