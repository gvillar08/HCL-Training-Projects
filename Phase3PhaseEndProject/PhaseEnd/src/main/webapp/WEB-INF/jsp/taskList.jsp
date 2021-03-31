<html>
	<font face = "Times New Roman" style="color: #89ABE3FF;">
	<body>
		<h1>Task Manager Assistant</h1>				<!-- Main webpage for displaying user's tasks -->
		<form method="post" action="logout">
			<input type="submit" value="Log Out">
		</form>
		<form method="post" action="new">
			<input type="submit" value="New Task">
		</form>
		<div>${tasks}</div><br>						<!-- Tasks go here -->
	</body>
	</font>
</html>