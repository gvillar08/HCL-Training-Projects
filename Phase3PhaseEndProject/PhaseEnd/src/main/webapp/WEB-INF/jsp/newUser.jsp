<html>
	<font face = "Times New Roman" style="color: #89ABE3FF;">
	<body>
		<h1>Task Manager Assistant</h1>
		<h2>New User</h2>																			<!-- Webpage for creating a new user -->
		<a href="login">Return to Main Menu</a><br>
	    <form method="post" action="newUser">
	    	<table>
				<tr><th>Username:</th><td><input type="text" name="username"></td></tr>
				<tr><th>Password:</th><td><input type="password" name="password1"></td></tr>
				<tr><th>Confirm Password:</th><td><input type="password" name="password2"></td></tr>
				<tr><td><input type="submit" value="Submit"></td></tr><br>
			</table>
			<div style="color: #FF0000;">${errorMessage}</div><br>									<!-- Error messages go here -->
			<div>${successMessage}</div><br>														<!-- Success messages go here -->
		</form>
	</body>
	</font>
</html>