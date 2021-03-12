<html>
  <body>
    <h1>Welcome to A Boring Website!</h1>
    <form method="post" action="login">
		Username: <input type="text" name="username"/>						<!-- User can login here -->
		Password: <input type="password" name="password"/>
		<input type="submit" value="Log in"/><br>							<!-- A submit button -->
		<div style="color: #FF0000;">${errorMessage}</div>					<!-- Error messages go here -->
		*Your first log in will take a minute to boot the program<br><br>
	</form>
    <a href="newAcct.jsp">New user? Create an account!</a>					<!-- A hyperlink for creating an account -->
  </body>
</html>