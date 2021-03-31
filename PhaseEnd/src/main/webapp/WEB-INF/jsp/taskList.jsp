<html>
	<font face = "Times New Roman" style="color: #89ABE3FF;">
	<body>
		<h1>Task Manager Assistant</h1>
		<form method="post" action="logout">
			<input type="submit" value="Log Out">
		</form>
		<form method="post" action="new">
			<input type="submit" value="New Task">
		</form>
		<!-- <form method="post" action="refresh">
			<input type="submit" value="Refresh">
		</form>-->
		<div>${tasks}</div><br>		<!-- Tasks go here -->
		<!-- 
		<form method="post" action="login">
	    	<table>
				<tr><th>Username:</th><td><input type="text" name="username"></td></tr>
				<tr><th>Password:</th><td><input type="password" name="password"></td></tr>
				<tr><td><input type="submit" value="Submit"></td><td><a href="otherlink">New User?</a></td></tr><br>
			</table>
			<div style="color: #FF0000;">${errorMessage}</div><br>
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
		-->
	</body>
	</font>
</html>