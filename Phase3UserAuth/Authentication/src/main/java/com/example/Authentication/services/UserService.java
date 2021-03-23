package com.example.Authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Authentication.entities.Auth;
import com.example.Authentication.repositories.*;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;

    public Iterable<Auth> getAllUsers()									//returns an iterable of all of the users in the database
    {
        return ur.findAll();
    }
    
    public Integer loginValidation(String username, String password)	//checks if the user submission is valid against the SQL database
    {    	
    	for(Auth a : getAllUsers())										//for every user...
    	{
    		if(username.equals(a.getUsername()))						//...check if the username entered is a match against the database
    		{
    			if(password.equals(a.getPassword()))					//if the username is found, check the password
    				return 1;											//return 1 to indicate the username and password matched
    			else													//if the password doesn't match...
    				return -1;											//...return -1 to indicate username was found but password did not match
    		}
    	}
    	return -2;														//if username wasn't found in the database, return -2 to indicate it wasn't found
    }
}