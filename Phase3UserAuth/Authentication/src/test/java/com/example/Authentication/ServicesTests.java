package com.example.Authentication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Authentication.entities.*;
import com.example.Authentication.services.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ServicesTests {														//tests the services class: UserService

	@Autowired
	private UserService us;
	
	@Test
	public void getAllUsersTest()											//tests the getAllUsers()
	{
		Auth first = us.getAllUsers().iterator().next();					//get the first user from the database
		assertEquals(first.getUsername(), "user");							//the first username should equal user
		assertEquals(first.getPassword(), "pass");							//the first password should equal pass
    }
	
	@Test
	public void loginValidationTest()										//tests the loginValidation()
	{
		assertEquals((us.loginValidation("user", "incorrect")), -1);		//passing a correct username but an incorrect password should return -1
		assertEquals((us.loginValidation("incorrect", "incorrect")), -2);	//passing an incorrect user/pass pair should return -2
		assertEquals(us.loginValidation("user", "pass"), 1);				//passing a correct user/pass pair should return 1
	}
}