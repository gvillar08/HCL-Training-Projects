package com.example.PhaseEnd.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.PhaseEnd.entities.Task;
import com.example.PhaseEnd.entities.User;
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
	
	private Integer currRow;
	
	public Integer getCurrRow() {
		return currRow;
	}

	public void setCurrRow(Integer currRow) {
		this.currRow = currRow;
	}

	public Iterable<Task> GetAllTasks() {	//finds all feedback
		return tr.findAll();
	}
	
	public void createNewTask(String name, String desc, LocalDate start, LocalDate end, String email, String severity)
	{
		Task task = new Task();
		task.setTask(name);
		task.setDesc(desc);
		task.setStart(start.toString());
		task.setEnd(end.toString());
		task.setEmail(email);
		task.setSeverity(severity);
		task.setUser_id(ur.findByUser(lts.getUsername()).getId());
		tr.save(task);
	}
	
	public void deleteTask(Integer row)
	{
		//ArrayList<Task> userTasks = getUserTasks();
		tr.delete(getUserTasks().get(row-1));
	}
	
	public void editTask(String name, String desc, LocalDate start, LocalDate end, String email, String severity)
	{
		Task task = getUserTasks().get(getCurrRow()-1);
		task.setTask(name);
		task.setDesc(desc);
		task.setStart(start.toString());
		task.setEnd(end.toString());
		task.setEmail(email);
		task.setSeverity(severity);
		task.setUser_id(ur.findByUser(lts.getUsername()).getId());
		tr.save(task);
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
	
	public String populateForm()
	{
		Task t = getUserTasks().get(getCurrRow()-1);
		String form = "";
		
		form += "<html><body><form method='post' action='editTask'><table>"
				+ "<tr><th>Task Name:*</th><td><input type='text' name='name' value='"+t.getTask()+"'></td></tr>"
				+ "<tr><th>Description</th><td><textarea name='desc' rows='5' cols='50'>"+t.getDesc()+"</textarea></td></tr>"
				+ "<tr><th>Start Date:*</th><td><input type='date' name='start' value='"+t.getStart()+"'></td></tr>"
				+ "<tr><th>End Date:*</th><td><input type='date' name='end' value='"+t.getEnd()+"'></td></tr>"
				+ "<tr><th>Email:</th><td><input type='text' name='email' value='"+t.getEmail()+"'></td></tr>"
				+ "<tr><th>Severity:*</th><td><select id='severity' name='severity'>"
					+ "<option value='0'>Select:</option>"
					+ "<option value='Low'>Low</option>"
					+ "<option value='Medium'>Medium</option>"
					+ "<option value='High'>High</option>"
				+ "</select></td></tr>"
				+ "<tr><td><input type='submit' value='Submit'></td></tr><br></table>"
				+ "Fields marked with * are required"
				+ "</form></body></html>";
		return form;
	}
	
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
	        for(Task t : userTasks)
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