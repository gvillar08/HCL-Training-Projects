<html>
  <body>
    <h1>Registration</h1>
    <a href="main.jsp">Return to main menu</a><br><br>							<!-- A hyperlink for returning to the main menu -->
    <form method="post" action="register">
		New username: <input type="text" name="username"/><br>					<!-- User can input a new username and password here -->
		New password: <input type="password" name="password1"/><br>
		Confirm password: <input type="password" name="password2"/><br>
		<input type="submit" value="Create account"/><br>						<!-- Create account button -->
		<div style="color: #FF0000;">${errorMessage}</div>						<!-- Error messages go here -->
		<div>${success}</div>													<!-- Successful creation message goes here -->
		*Your first submission will take a minute to boot the program<br><br>
	</form>
  </body>
</html>