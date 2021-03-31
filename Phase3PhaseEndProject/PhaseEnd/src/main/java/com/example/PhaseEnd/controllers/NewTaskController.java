package com.example.PhaseEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.PhaseEnd.services.LoginTrackingService;
import com.example.PhaseEnd.services.TaskService;

@Controller
public class NewTaskController
{
	@Autowired
	private TaskService ts;
	@Autowired
	private LoginTrackingService lts;
	
    @GetMapping("/newTask")
    public String Default(ModelMap model)
    {
    	if(lts.isUserLoggedIn()==false)				//check if the user is logged in
    		return "login";							//if not, return the user to the login page...
    	return "newTask";							//...otherwise, continue to the page
    }
	
	@PostMapping("/newTask")						//validates the user input for creating a new task
	public String newTask(ModelMap model, @RequestParam String name, @RequestParam String desc, @RequestParam String start, @RequestParam String end, @RequestParam String email, @RequestParam String severity)
	{
		if(name.isBlank()||start.isBlank()||end.isBlank()||severity.equals("0"))
		{
			model.addAttribute("errorMessage", "Oops! Fields marked with * cannot be empty");
			return "newTask";
		}
		LocalDate s = LocalDate.parse(start, DateTimeFormatter.ofPattern( "yyyy-MM-dd", Locale.ENGLISH ));
		LocalDate e = LocalDate.parse(end, DateTimeFormatter.ofPattern( "yyyy-MM-dd", Locale.ENGLISH ));
		
		if(s==null||e==null)
		{
			model.addAttribute("errorMessage", "Oops! Please ensure all date fields are correct!");
			return "newTask";
		}
		if(s.isAfter(e))
		{
			model.addAttribute("errorMessage", "Oops! Your start date is after the end date!");
			return "newTask";
		}
		if(name.length()>255||desc.length()>255||email.length()>255)
		{
			model.addAttribute("errorMessage", "Sorry, the task name, description, and email may only be 255 characters maximum each");
			return "newTask";
		}
		ts.createNewTask(name, desc, s, e, email, severity);	//if no errors were thrown, create a new task
		model.addAttribute("successMessage", "Task successfully created! Return to Tasks to view it!");
		return "newTask";
	}
}