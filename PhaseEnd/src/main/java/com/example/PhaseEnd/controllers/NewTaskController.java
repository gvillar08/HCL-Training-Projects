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
import com.example.PhaseEnd.services.LoginTrackingService;
import com.example.PhaseEnd.services.UserService;

@Controller
public class NewTaskController
{
	@Autowired
	private UserRepository ur;
	@Autowired
	private UserService us;
	@Autowired
	private LoginTrackingService lts;
	
    @GetMapping("/newTask")
    public String Default(ModelMap model)
    {
    	if(lts.isUserLoggedIn()==false)
    		return "login";
    	//model.addAttribute("tasks", ts.printTasks());
    	return "newTask";
    }
	
	@PostMapping("/newTask")
	public String newUser(ModelMap model, @RequestParam String name, @RequestParam String desc, @RequestParam String start, @RequestParam String end, @RequestParam String email, @RequestParam String severity)
	{
		if(name.isBlank())
		{
			model.addAttribute("errorMessage", "Oops! Fields marked with * cannot be empty");
			return "newTask";
		}
//		if(!password1.equals(password2))
//		{
//			model.addAttribute("errorMessage", "Oops! Your passwords didn't match!");
//			return "newUser";
//		}
//		if(username.length()>255||password1.length()>255)
//		{
//			model.addAttribute("errorMessage", "Sorry, your username and password may only be 255 characters maximum");
//			return "newUser";
//		}
//		if(ur.findByUser(username)!=null)
//		{
//			model.addAttribute("errorMessage", "That username is already taken! Please enter a unique username");
//			return "newUser";
//		}
//		us.createNewUser(username, password2);
		System.out.println(name+ desc+ start+ end+ email+ severity);
		model.addAttribute("successMessage", "Account successfully created! Return to the main menu to log in");
		return "newUser";
	}
}