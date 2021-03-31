<html>
	<font face = "Times New Roman" style="color: #89ABE3FF;">
	<body>
		<h1>Task Manager Assistant</h1>
		<h2>New Task</h2>
		<a href="/taskList">Return to Tasks</a><br>
	    <form method="post" action="newTask">
	    	<table>
				<tr><th>Task Name:*</th><td><input type="text" name="name"></td></tr>				<!-- User can log in here -->
				<!-- <tr><th>Description:</th><td><input type="text" name="desc"></td></tr>-->
				<tr><th>Description</th><td><textarea name="desc" rows="5" cols="50"></textarea></td></tr>
				<tr><th>Start Date:*</th><td><input type="date" name="start"></td></tr>
				<tr><th>End Date:*</th><td><input type="date" name="end"></td></tr>
				<tr><th>Email:</th><td><input type="text" name="email"></td></tr>
				<tr><th>Severity:*</th><td><select id="severity" name="severity">
					<option value="0">Select:</option>
				    <option value="Low">Low</option>
				    <option value="Medium">Medium</option>
				    <option value="High">High</option>
				</select></td></tr>
				<tr><td><input type="submit" value="Submit"></td></tr><br>
			</table>
			Fields marked with * are required
			<br><div style="color: #FF0000;">${errorMessage}</div><br>		<!-- Error messages go here -->
			<div>${successMessage}</div><br>		<!-- Success messages go here -->
		</form>
	</body>
	</font>
</html>