package com.example.Authentication;

import com.example.Authentication.entities.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityTests										//tests the entity class: Auth
{
	@Test
	public void passwordSetterGetterTest()						//tests the getters and setters for password
	{
		Auth testUser = new Auth();
		
		testUser.setPassword("myPassword");
		assertEquals(testUser.getPassword(),"myPassword");		//setting a test password to myPassword should return the same when the getter is called
	}
	
	@Test
	public void usernameSetterGetterTest()						//tests the getters and setters for username
	{
		Auth testUser = new Auth();
		
		testUser.setUsername("myUsername");
		assertEquals(testUser.getUsername(), "myUsername");		//setting a test username to myUsername should return the same when the getter is called
	}
}