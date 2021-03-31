package com.example.PhaseEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import com.example.PhaseEnd.entities.User;
import com.example.PhaseEnd.repositories.UserRepository;
import com.example.PhaseEnd.services.UserService;

@Controller
public class NewUserController
{
//    @GetMapping("/newUser")
//    public String Default() {
//    	return "newUser";
//    }
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private UserService us;
	
	@PostMapping("/newUser")
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
		us.createNewUser(username, password2);
		model.addAttribute("successMessage", "Account successfully created! Return to the main menu to log in");
		return "newUser";
	}
}