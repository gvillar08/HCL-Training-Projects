package com.example.Authentication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.Authentication.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService us;

    @GetMapping("/")
    public String showGreeting()//ModelMap model)
    {
        return "loginScreen";
    }

    @PostMapping("/login")
    public String submitLogin(ModelMap model, @RequestParam String username, @RequestParam String password)
    {
    	if(username.isBlank()||password.isBlank())
    	{
    		model.put("errorMessage", "Oops! Please make sure all fields are filled before entering!");
    		return "loginScreen";
    	}
    	else
    	{
    		if(us.loginValidation(username, password) == -1)
    		{
    			model.put("errorMessage", "Sorry, your credentials couldn't be verified!");
    			return "loginScreen";
    		}
    		else
    			return "success";
    	}
    }
}