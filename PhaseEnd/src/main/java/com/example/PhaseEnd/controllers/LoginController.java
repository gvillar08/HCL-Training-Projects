package com.example.PhaseEnd.controllers;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.PhaseEnd.entities.User;
import com.example.PhaseEnd.repositories.UserRepository;
import com.example.PhaseEnd.services.LoginTrackingService;
import com.example.PhaseEnd.services.TaskService;
import com.example.PhaseEnd.services.UserService;
//import com.example.PhaseEnd.services.UserSecurityService;

@Controller
public class LoginController						//the login controller
{
//	@Autowired
//	private UserSecurityService uss;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private LoginTrackingService lts;
	
	@Autowired
	private TaskService ts;
	
	@Autowired
	private UserService us;
	
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
    
//	@GetMapping("/credentialFail")					//upon credentials failing, notify the user through an error message
//	public String credentialFail(ModelMap model)
//	{
//		model.addAttribute("errorMessage", "Oops! Your credentials didn't match our records!");
//		return "login";
//	}
	
	@PostMapping("/login")
	public String signin(ModelMap model, @RequestParam String username, @RequestParam String password, HttpServletResponse response)
	{
		//UserDetails placeholder = null;
		//User placeholder = null;
		//System.out.println(username+"uhh");
		if(username.isBlank()||password.isBlank())
		{
			//System.out.println(username+"empty");
			model.addAttribute("errorMessage", "Sorry, one or more fields are empty");
			return "login";
			//return "credentialFail";
		}
		User placeholder = ur.findByUser(username); //uss.loadUserByUsername(username);
		if(placeholder==null)
		{
			//System.out.println(placeholder);
			model.addAttribute("errorMessage", "Oops! Your username couldn't be found");
			return "login";
			//return "credentialFail";
		}
		if(!placeholder.getPass().equals(password))
		{
			model.addAttribute("errorMessage", "Oops! Your password didn't match our records");
			return "login";
		}
		lts.setUsername(username);
		lts.setPassword(password);
		//System.out.println(placeholder);
//		uss.loadUserByUsername(username);
    	model.addAttribute("tasks", ts.printTasks());
		return "taskList";
	}
	
	//Dont need the following because it somehow already knows what logging out is?
	
//	@GetMapping("/logout")							//when the logout button is clicked, log the user out
//	public String logoutPage(ModelMap model, HttpServletRequest request, HttpServletResponse response)
//	{
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null)
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//	    return "redirect:/login?logout=true";
//	}
}