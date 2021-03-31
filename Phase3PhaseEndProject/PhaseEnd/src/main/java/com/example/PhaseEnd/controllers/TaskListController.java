package com.example.PhaseEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.PhaseEnd.services.LoginTrackingService;
import com.example.PhaseEnd.services.TaskService;

@Controller
public class TaskListController						//controller for features in taskList.jsp
{
	@Autowired
	private LoginTrackingService lts;
	@Autowired
	private TaskService ts;
	
    @GetMapping("/taskList")
    public String Default(ModelMap model)
    {
    	if(lts.isUserLoggedIn()==false)					//checks if a user is logged in
    		return "login";								//returns user to login screen if false...
    	model.addAttribute("tasks", ts.printTasks());	//...otherwise, prints the user's tasks
    	return "taskList";
    }
    
    @PostMapping("/new")								//forwards user to newTask.jsp when the user clicks create a new task
    public String newTask()
    {
    	return "newTask";
    }
    
    @PostMapping("/edit={row}")							//checks the number appended to the URL to see what row edit button the user clicked
    public String edit(ModelMap model, @PathVariable("row") Integer row)
    {
    	ts.setCurrRow(row);								//sets the row number for later use by other classes
    	model.addAttribute("form", ts.populateForm());	//populates the editTask.jsp form with user data
    	return "editTask";								//forwards the user to editTask.jsp
    }
    
    @PostMapping("/delete={row}")						//checks the number appended to the URL to see what row delete button the user clicked
    public String delete(ModelMap model, @PathVariable("row") Integer row)
    {
    	ts.deleteTask(row);								//deletes the user-specified row
    	model.addAttribute("tasks", ts.printTasks());	//updates the list of user tasks
    	return "taskList";
    }
    
    @PostMapping("/logout")								//logs the user out and prevents the user from accessing pages past the login screen
    public String logout()
    {
    	lts.setUsername(null);
    	lts.setPassword(null);
    	return "login";
    }
}