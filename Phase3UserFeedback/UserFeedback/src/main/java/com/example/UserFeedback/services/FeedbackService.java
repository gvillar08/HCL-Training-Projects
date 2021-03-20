package com.example.UserFeedback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.repositories.*;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository fr;
	
	public Iterable<Feedback> GetAllFeedback() {	//finds all feedback
		return fr.findAll();
	}
	
	public Feedback saveFeedback(String user, Integer rating, String comments)	//saves feedback entries to the database
	{
		Feedback f = new Feedback();
		f.setUser(user);
		f.setRating(rating);
		f.setComments(comments);
		fr.save(f);
		return f;
	}
}