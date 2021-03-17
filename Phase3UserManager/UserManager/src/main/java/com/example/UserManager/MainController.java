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
public class MainController {

	@Autowired
	private UserService us;
	
    Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/")
	public String showUsers(ModelMap model) {								//show the table of known users in the database
		
		logger.info("Getting all Users...");
		Iterable<User> users = us.GetAllUsers();
		
		logger.info("Passing users to view...");
	    model.addAttribute("users", users);    
		
        return "index";
    }
	
    @PostMapping("/submission")
	public String indexPage(ModelMap model, @RequestParam String id) {		//handles user input on the home screen
		
    	logger.info("Redisplaying the table...");
    	showUsers(model);													//redisplay the table
    	
    	logger.info("Converting and finding...");
		int convert = us.toInt(id);											//attempt converting the user input to an int
		User find = us.GetUserById(convert);								//attempt searching the user input
		
		if(convert == -1)													//if the convert to an int failed, notify the user
		{
			logger.info("Convert failed");
			model.put("errorMessage", "Sorry, numeric entries only");
			return "index";
		}
				
		if(find == null)													//if the user input search failed, notify the user
		{
			logger.info("Search failed");
			model.put("errorMessage", "Oops! That user could not be found, please try again");
			return "index";			
		}
		else																//if the search was successful...
		{
			logger.info("Search successful. Going to edit.jsp...");
			model.put("found", find);										//...append the result to the table in the next page...
			us.setSearch(convert);											//...and set the search result for later use by UserController
			return "edit";
		}
	}
}