package com.example.Authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Authentication.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService us;

    @GetMapping("/")
    public String showGreeting()										//maps the user to the loginScreen.jsp from the default URL
    {
        return "loginScreen";
    }

    @PostMapping("/login")
    public String submitLogin(ModelMap model, @RequestParam String username, @RequestParam String password)	//maps the user to the respective view after making an entry
    {
    	if(username.isBlank()||password.isBlank())						//if either field is submitted blank or with whitespace only...
    	{
    		model.put("errorMessage", "Oops! Please make sure all fields are filled before entering!");
    		return "loginScreen";										//...notify the user
    	}
    	else
    	{
    		int placeHolder = us.loginValidation(username, password);	//run the validation on the entry pair. This is run after checking for empty space to minimize potential unnecessary checking
    		
    		if(placeHolder == -1)										//if the return code is -1 (username found but password mismatch)...
    		{
    			model.put("errorMessage", "Sorry, your password couldn't be verified!");
    			return "loginScreen";									//...notify the user through an error on the login screen
    		}
    		else if(placeHolder == -2)									//if the return code is -2 (username not found in database)...
    		{
    			model.put("errorMessage", "Sorry, your username couldn't be found!");
    			return "loginScreen";									//...notify the user through an error on the login screen
    		}
    	}
    	return "success";												//if no error was thrown, take the user to the success.jsp page for a successful login
    }
}