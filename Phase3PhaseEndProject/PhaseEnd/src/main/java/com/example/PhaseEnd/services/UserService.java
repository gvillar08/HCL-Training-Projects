package com.example.PhaseEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PhaseEnd.entities.User;
import com.example.PhaseEnd.repositories.UserRepository;

@Service
public class UserService		//service pertaining to the user entity
{
	@Autowired
	private UserRepository ur;
	
	public void createNewUser(String username, String password)	//method for creating a new user
	{
		User user = new User();
		user.setUser(username);
		user.setPass(password);
		ur.save(user);
	}
}