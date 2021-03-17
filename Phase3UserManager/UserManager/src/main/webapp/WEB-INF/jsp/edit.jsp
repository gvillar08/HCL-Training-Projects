<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<style>
			table, th, td {
			  border: 1px solid black;
			}
		</style>
	</head>
	<body>
		<h2>Edit</h2>
		<a href="/">Return to Main</a><br>								<!-- Hyperlink to return to main -->
		Selected user:<br>
		<table style="float:left">
			<tr><th>ID</th><th>Name</th><th>Username</th><th>Password</th></tr>	<!-- Table displaying the user's search -->
			<tr>
				<td>${found.id}</td>
				<td>${found.name}</td>
				<td>${found.username}</td>
				<td>${found.password}</td>
			</tr>
		</table><br>
		<br>Please enter changes into the following fields:<br>
		Fields left empty will not be edited
	    <form method="post" action="edit">
	    	Name: <input type="text" name="n"/>							<!-- User enters changes here -->
			Username: <input type="text" name="u"/>						
			Password: <input type="text" name="p"/>						
			<input type="submit" value="Submit"/><br>					<!-- A submit button -->
			<div style="color: #FF0000;">${errorMessage}</div><br>		<!-- Error messages go here -->
			<div>${success}</div><br>									<!-- Successful message goes here -->			
		</form>
	</body>
</html>