package com.example.SpringSecurity.controllers;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController						//the login controller
{
	@GetMapping("/credentialFail")					//upon credentials failing, notify the user through an error message
	public String credentialFail(ModelMap model)
	{
		model.addAttribute("errorMessage", "Oops! Your credentials didn't match our records!");
		return "login";
	}
	
	@GetMapping("/logout")							//when the logout button is clicked, log the user out
	public String logoutPage(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
			new SecurityContextLogoutHandler().logout(request, response, auth);
	    return "redirect:/login?logout=true";
	}
}