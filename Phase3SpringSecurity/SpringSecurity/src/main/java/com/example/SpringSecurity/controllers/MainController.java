package com.example.SpringSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController				//controller for the following webpages
{	
    @GetMapping("/")
    public String Default() {
    	return "home";
    }
    
    @GetMapping("/home")
    public String Home() {
    	return "home";
    }

    @GetMapping("/hello")
    public String Hello() {
    	return "hello";
    }
    
    @GetMapping("/login") 
	public String showLoginPage()
	{
		return "login";
	}
}