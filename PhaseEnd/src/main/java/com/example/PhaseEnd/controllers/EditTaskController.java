package com.example.PhaseEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.PhaseEnd.repositories.TaskRepository;
//import com.example.PhaseEnd.entities.User;
import com.example.PhaseEnd.services.LoginTrackingService;
import com.example.PhaseEnd.services.TaskService;

@Controller
public class EditTaskController
{
	@Autowired
	private TaskRepository tr;
	@Autowired
	private TaskService ts;
	@Autowired
	private LoginTrackingService lts;
		
    @GetMapping("/editTask")
    public String Default(ModelMap model)
    {
    	if(lts.isUserLoggedIn()==false)
    		return "login";
    	model.addAttribute("form", ts.populateForm());
    	return "editTask";
    }
    
	@PostMapping("/editTask")
	public String newTask(ModelMap model, @RequestParam String name, @RequestParam String desc, @RequestParam String start, @RequestParam String end, @RequestParam String email, @RequestParam String severity)
	{
//		System.out.println(start);
		if(name.isBlank()||start.isBlank()||end.isBlank()||severity.equals("0"))
		{
	    	model.addAttribute("form", ts.populateForm());
			model.addAttribute("errorMessage", "Oops! Fields marked with * cannot be empty");
			return "newTask";
		}
		LocalDate s = LocalDate.parse(start, DateTimeFormatter.ofPattern( "yyyy-MM-dd", Locale.ENGLISH ));
		LocalDate e = LocalDate.parse(start, DateTimeFormatter.ofPattern( "yyyy-MM-dd", Locale.ENGLISH ));
		
		if(s==null||e==null)
		{
	    	model.addAttribute("form", ts.populateForm());
	    	model.addAttribute("errorMessage", "Oops! Please ensure all date fields are correct!");
			return "newTask";
		}
		if(s.isAfter(e))//.toString().isBlank())		//if one of these is blank, we don't check for this attribute
		{
	    	model.addAttribute("form", ts.populateForm());
	    	model.addAttribute("errorMessage", "Oops! Your start date is after the end date!");
			return "newTask";
		}
		if(name.length()>255||desc.length()>255||email.length()>255)
		{
	    	model.addAttribute("form", ts.populateForm());
	    	model.addAttribute("errorMessage", "Sorry, the task name, description, and email may only be 255 characters maximum each");
			return "newTask";
		}
		ts.editTask(name, desc, s, e, email, severity);
    	model.addAttribute("form", ts.populateForm());
    	model.addAttribute("successMessage", "Task successfully edited! Return to Tasks to view it!");
		return "editTask";
	}
}