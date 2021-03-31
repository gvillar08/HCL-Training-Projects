package com.example.PhaseEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.example.PhaseEnd.services.LoginTrackingService;
import com.example.PhaseEnd.services.TaskService;

@Controller
public class TaskListController
{
	@Autowired
	private LoginTrackingService lts;
	@Autowired
	private TaskService ts;
	
    @GetMapping("/taskList")
    public String Default(ModelMap model)
    {
    	if(lts.isUserLoggedIn()==false)
    		return "login";
    	model.addAttribute("tasks", ts.printTasks());
    	return "taskList";
    }
    
    @PostMapping("/new")
    public String newTask()
    {
    	return "newTask";
    }
    
//    @PostMapping("/refresh")
//    public String refresh(ModelMap model)				//delete refresh ability? if not this, then delete refresh button?
//    {
//    	model.addAttribute("tasks", ts.printTasks());
//    	return "taskList";
//    }
    
    @PostMapping("/edit={row}")
    public String edit(ModelMap model, @PathVariable("row") Integer row)
    {
    	model.addAttribute("tasks", ts.printTasks());
    	return "taskList";
    }
    
    @PostMapping("/delete={row}")
    public String delete(ModelMap model, @PathVariable("row") Integer row)
    {
    	ts.deleteTask(row);
    	model.addAttribute("tasks", ts.printTasks());
    	return "taskList";
    }
    
    @PostMapping("/logout")
    public String logout()
    {
    	lts.setUsername(null);
    	lts.setPassword(null);
    	return "login";
    }
}