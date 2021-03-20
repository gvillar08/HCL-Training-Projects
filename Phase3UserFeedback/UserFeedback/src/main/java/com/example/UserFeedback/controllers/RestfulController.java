package com.example.UserFeedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;

@RestController
public class RestfulController {
	
	@Autowired
	FeedbackService fs;

	@GetMapping("/feedback")
	public Iterable<Feedback> getAllFeedbacks() {			//gets all feedback
	      return fs.GetAllFeedback();
	   }
	
	@PostMapping("/feedback")
	public Feedback setUserInput(ModelMap model, @RequestParam String user, @RequestParam(required = false) Integer rating, @RequestParam String comments)
	{
		if(!user.isBlank()&&rating!=null)					//if the required entries arent null...
			return fs.saveFeedback(user, rating, comments);	//...save them to the database and return them as JSON...
		else
			return new Feedback();							//...otherwise, return an empty JSON result and don't save the feedback
    }
}