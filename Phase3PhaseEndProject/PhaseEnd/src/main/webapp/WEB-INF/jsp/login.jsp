<html>
	<font face = "Times New Roman" style="color: #89ABE3FF;">
	<body>
		<h1>Task Manager Assistant</h1>
		<h2>Login</h2>																				<!-- Default webpage for booting the program, logging in, and failed logins -->
	    <form method="post" action="login">
	    	<table>
				<tr><th>Username:</th><td><input type="text" name="username"></td></tr>				<!-- User can log in here -->
				<tr><th>Password:</th><td><input type="password" name="password"></td></tr>
				<tr><td><input type="submit" value="Submit"></td><td><a href="/newUser">New User?</a></td></tr><br>
			</table>
			<div style="color: #FF0000;">${errorMessage}</div><br>									<!-- Error messages go here -->
		</form>
	</body>
	</font>
</html>