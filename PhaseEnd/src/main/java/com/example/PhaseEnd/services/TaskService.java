package com.example.PhaseEnd.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PhaseEnd.entities.Task;
import com.example.PhaseEnd.repositories.TaskRepository;
import com.example.PhaseEnd.repositories.UserRepository;

@Service
public class TaskService
{
	@Autowired
	private TaskRepository tr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private LoginTrackingService lts;
	
	public Iterable<Task> GetAllTasks() {	//finds all feedback
		return tr.findAll();
	}
	
	public void deleteTask(Integer row)
	{
		//ArrayList<Task> userTasks = getUserTasks();
		tr.delete(getUserTasks().get(row-1));
	}
	
	public ArrayList<Task> getUserTasks()
	{
		ArrayList<Task> userTasks = new ArrayList<Task>();
		Integer currUser = (ur.findByUser(lts.getUsername())).getId();
		
		for(Task t : tr.findAll())
		{
			if(t.getUser_id()==currUser)
				userTasks.add(t);
		}
		return userTasks;
	}
	
//	public Feedback saveFeedback(String user, Integer rating, String comments)	//saves feedback entries to the database
//	{
//		Feedback f = new Feedback();
//		f.setUser(user);
//		f.setRating(rating);
//		f.setComments(comments);
//		fr.save(f);
//		return f;
//	}
	
	public String printTasks()
	{
		ArrayList<Task> userTasks = getUserTasks();
		String table = "";
		Integer row = 1;
		
		table += "<html><body><style>table,th,td{border: 1px solid black; padding: 5px;}</style>"
				+"<table><tr><th>Task</th><th>Email</th><th>Start Date</th><th>End Date</th><th>Severity</th><th>Update</th><th>Delete</th></tr><br>";			//table headers
		
		if(userTasks.isEmpty())
            table += "<tr><td colspan='7'>You have no tasks!</td><br>";
		else
		{
	        for(Task t : tr.findAll())
	        {
	            table += "<tr><td>"+t.getTask()+"</td><td>"+t.getEmail()+"</td><td>"+t.getStart()+"</td><td>"+t.getEnd()+"</td><td>"+t.getSeverity()+"</td>"
	            	+ "<td><form method='post' action='edit="+row+"'><button>Edit</button></form></td>"
	            	+ "<td><form method='post' action='delete="+row+"' onsubmit='return confirmation(this);'><button>Delete</button></form></td>"
	            	+ "<tr><td colspan='7'><b>Description: </b>"+t.getDesc()+"</td><br>";
	            row++;
	        }
		}
        table += "</table>"
        		+ "<script> function confirmation(){"
        		+ "return confirm('Are you sure?');"
        		+ "}</script>"
        		+ "</body></html>";

        return table;
	}
}