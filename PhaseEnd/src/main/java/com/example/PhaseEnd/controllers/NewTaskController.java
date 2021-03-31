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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.PhaseEnd.repositories.TaskRepository;
//import com.example.PhaseEnd.entities.User;
import com.example.PhaseEnd.services.LoginTrackingService;
import com.example.PhaseEnd.services.TaskService;

@Controller
public class NewTaskController
{
	@Autowired
	private TaskRepository tr;
	@Autowired
	private TaskService ts;
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
//		System.out.println(start);
		if(name.isBlank()||start.isBlank()||end.isBlank()||severity.equals("0"))
		{
			model.addAttribute("errorMessage", "Oops! Fields marked with * cannot be empty");
			return "newTask";
		}
		LocalDate s = LocalDate.parse(start, DateTimeFormatter.ofPattern( "yyyy-MM-dd", Locale.ENGLISH ));//.format(DateTimeFormatter.ofPattern( "uuuu/MM/dd" , Locale.ENGLISH));
		LocalDate e = LocalDate.parse(start, DateTimeFormatter.ofPattern( "yyyy-MM-dd", Locale.ENGLISH ));//.format(DateTimeFormatter.ofPattern( "uuuu/MM/dd" , Locale.ENGLISH));
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//, Locale.ENGLISH);
//		Date s = null;
//		Date e = null;
//		try {
//			s = formatter.parse(start);
//		} catch (ParseException e2) {	//never executed but just so compiles
//			//e2.printStackTrace();
//			model.addAttribute("errorMessage", "Oops! Please ensure all date fields are filled!");
//			return "newTask";
//		}
//		try {
//			e = formatter.parse(end);
//		} catch (ParseException e1) {
//			//e1.printStackTrace();
//			model.addAttribute("errorMessage", "Oops! Please ensure all date fields are filled!");
//			return "newTask";
//		}
		if(s==null||e==null)
		{
			model.addAttribute("errorMessage", "Oops! Please ensure all date fields are correct!");
			return "newTask";
		}
		if(s.isAfter(e))//.toString().isBlank())		//if one of these is blank, we don't check for this attribute
		{
			model.addAttribute("errorMessage", "Oops! Your start date is after the end date!");
			return "newTask";
		}
		if(name.length()>255||desc.length()>255||email.length()>255)
		{
			model.addAttribute("errorMessage", "Sorry, the task name, description, and email may only be 255 characters maximum each");
			return "newUser";
		}
		ts.createNewTask(name, desc, s, e, email, severity);
		model.addAttribute("successMessage", "Task successfully created! Return to Tasks to view it!");
		return "newTask";
	}
}