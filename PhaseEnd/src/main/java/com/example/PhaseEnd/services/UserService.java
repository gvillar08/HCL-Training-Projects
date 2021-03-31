package com.example.PhaseEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import com.example.PhaseEnd.entities.User;
import com.example.PhaseEnd.repositories.UserRepository;

@Service
public class UserService //implements UserDetailsService
{
	@Autowired
	private UserRepository ur;
	
	public void createNewUser(String username, String password)
	{
		User user = new User();
		user.setUser(username);
		user.setPass(password);
		ur.save(user);
	}
	
//	public Iterable<User> GetAllUsers() {	//finds all feedback
//		return ur.findAll();
//	}
	
//	public Feedback saveFeedback(String user, Integer rating, String comments)	//saves feedback entries to the database
//	{
//		Feedback f = new Feedback();
//		f.setUser(user);
//		f.setRating(rating);
//		f.setComments(comments);
//		fr.save(f);
//		return f;
//	}
}