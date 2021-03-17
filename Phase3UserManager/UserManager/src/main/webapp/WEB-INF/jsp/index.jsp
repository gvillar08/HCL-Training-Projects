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
	<h2>Users</h2>
	    <form method="post" action="submission">
	    	Please enter a User ID to edit: <input type="text" name="id"/>		<!-- User can search here -->
			<input type="submit" value="Edit"/><br>								<!-- A submit button -->
			<div style="color: #FF0000;">${errorMessage}</div><br>				<!-- Error messages go here -->
		</form>
		<table style="float:left">
		   <tr><th>ID</th><th>Name</th><th>Username</th><th>Password</th></tr>	<!-- Table of all users in the database -->
		   <c:forEach items="${users}" var="user" varStatus="count">
		    <tr id="${count.index}">
		    	<td>${user.id}</td>
		        <td>${user.name}</td>
		        <td>${user.username}</td>
		        <td>${user.password}</td>
		    </tr>
		  </c:forEach>
		</table>
	</body>
</html>