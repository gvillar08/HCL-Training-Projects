package com.example.PhaseEnd.controllers;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.PhaseEnd.entities.User;
import com.example.PhaseEnd.repositories.UserRepository;
import com.example.PhaseEnd.services.LoginTrackingService;
import com.example.PhaseEnd.services.TaskService;

@Controller
public class LoginController						//the login controller to handle features on login.jsp
{
	@Autowired
	private UserRepository ur;
	@Autowired
	private LoginTrackingService lts;
	@Autowired
	private TaskService ts;
	
	@GetMapping("/")
    public String Default() {
    	return "login";
    }
    
    @GetMapping("/login")
    public String login() {
    	return "login";
    }
    
    @GetMapping("/newUser")
    public String newUser() {
    	return "newUser";
    }
	
	@PostMapping("/login")							//validates the user's attempt to login
	public String signin(ModelMap model, @RequestParam String username, @RequestParam String password, HttpServletResponse response)
	{
		if(username.isBlank()||password.isBlank())
		{
			model.addAttribute("errorMessage", "Sorry, one or more fields are empty");
			return "login";
		}
		User placeholder = ur.findByUser(username);
		if(placeholder==null)
		{
			model.addAttribute("errorMessage", "Oops! Your username couldn't be found");
			return "login";
		}
		if(!placeholder.getPass().equals(password))
		{
			model.addAttribute("errorMessage", "Oops! Your password didn't match our records");
			return "login";
		}
		lts.setUsername(username);					//if no errors were thrown, save the user's credentials so they are now validated to access further pages without being rerouted back to login...
		lts.setPassword(password);
    	model.addAttribute("tasks", ts.printTasks());	//...and print the user's tasks
		return "taskList";
	}
}