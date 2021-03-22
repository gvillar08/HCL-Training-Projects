package com.example.Authentication.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;

    public Iterable<User> GetAllUsers()
    {
        return ur.findAll();
    }

//    public User GetUserByUsername(String username)
//    {
//        User foundUser = ur.findByUsername(username);
//        return foundUser;
//    }
    
    public Integer loginValidation(String username, String password)
    {
    	//System.out.println(GetUserByUsername(username));
    	System.out.println(GetAllUsers());
    	for(User temp:GetAllUsers())
    	{
    		System.out.println(temp);
    	}
    	System.out.println(ur.findAll());
    	System.out.println(ur.findById(0));//.get());
    	//returns null
    	return -1;
    }
//    public User GetUserById(int id) {
//    	Optional<User> foundUser = userRepository.findById(id);    	
//    	
//    	//TODO: we need to decide how to handle a "Not Found" condition
//    	
////    	if (!foundUser.isPresent()) {
////    		throw new UserNotFoundException();
////    	}
//    	return(foundUser.get());
//    }
    
//    public void UpdateUser(User usertoUpdate) {
//    	userRepository.save(usertoUpdate);
//    }
}