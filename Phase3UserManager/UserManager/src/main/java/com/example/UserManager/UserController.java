package com.example.UserManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	private UserService us;
	
    Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @GetMapping("/edit")
	public String showUser(ModelMap model) {					//shows the table of the searched user
		
    	logger.info("Displaying refined table...");
		User find = us.GetUserById(us.getSearch());
		model.put("found", find);
        return "edit";
    }
    
    @PostMapping("/edit")
	public void editPage(ModelMap model, @RequestParam String n, @RequestParam String u, @RequestParam String p) {	//the logic for user input when an edit request is made
		
    	logger.info("Redisplaying refined table...");
    	showUser(model);										//redisplay the table

    	if(n.equals("")&&u.equals("")&&p.equals(""))			//if all of the fields are empty...
    	{
    		logger.info("All fields are empty");
			model.put("errorMessage", "Oops! At least one field has to be updated!");	//...notify the user
    	}
    	else													//notify the user that their request successfully went through since at least one field wasn't empty
    	{
    		logger.info("At least one field isn't empty");
			model.put("success", "Success! The field(s) have been updated. Return to main to see changes");  
    	}
    		
    	if(!n.equals(""))										//if the name isn't empty...
    	{
    		logger.info("Updating Name...");
    		us.editName(n, us.getSearch());						//...update it
    	}
    	
    	if(!u.equals(""))										//if the username isn't empty...
    	{
    		logger.info("Updating Username...");
    		us.editUsername(u, us.getSearch());					//...update it
    	}
    	
    	if(!p.equals(""))										//if the password isn't empty...
    	{
    		logger.info("Updating Password...");
    		us.editPassword(p, us.getSearch());					//...update it	
    	}
	}
}