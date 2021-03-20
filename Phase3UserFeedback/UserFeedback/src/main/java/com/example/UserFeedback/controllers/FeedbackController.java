package com.example.UserFeedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.UserFeedback.services.FeedbackService;

@Controller
public class FeedbackController {
	
	@Autowired
	FeedbackService fs;
	
	@GetMapping("/")
	public String homePageRedirect()	//redirects the user to the feedback page
	{
		return "home.jsp";
	}
}