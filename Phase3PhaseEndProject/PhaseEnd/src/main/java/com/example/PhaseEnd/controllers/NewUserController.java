package com.example.PhaseEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.PhaseEnd.repositories.UserRepository;
import com.example.PhaseEnd.services.UserService;

@Controller
public class NewUserController											//controller for features on the newUser.jsp page
{
	@Autowired
	private UserRepository ur;
	@Autowired
	private UserService us;
	
	@PostMapping("/newUser")											//validates the user input on the newUser.jsp page
	public String newUser(ModelMap model, @RequestParam String username, @RequestParam String password1, @RequestParam String password2)
	{
		if(username.isBlank()||password1.isBlank()||password2.isBlank())
		{
			model.addAttribute("errorMessage", "Sorry, one or more fields are empty");
			return "newUser";
		}
		if(!password1.equals(password2))
		{
			model.addAttribute("errorMessage", "Oops! Your passwords didn't match!");
			return "newUser";
		}
		if(username.length()>255||password1.length()>255)
		{
			model.addAttribute("errorMessage", "Sorry, your username and password may only be 255 characters maximum");
			return "newUser";
		}
		if(ur.findByUser(username)!=null)
		{
			model.addAttribute("errorMessage", "That username is already taken! Please enter a unique username");
			return "newUser";
		}
		us.createNewUser(username, password2);							//create a new user if no errors are thrown
		model.addAttribute("successMessage", "Account successfully created! Return to the main menu to log in");
		return "newUser";
	}
}