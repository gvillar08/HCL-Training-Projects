<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Feedback</title>
	</head>
	<body>
		Welcome to the feedback page! We'd love to hear your opinion, so please fill all of the below fields to let us know what you think!<br><br>
		<form method="post" action="feedback">
	    	Name: (Required)<br>
	    	<input type="text" name="user"/><br><br>							<!-- User enters name here -->
	    	Rating: (Required)<br>												<!-- Radio input on scale of 1-5 for user satisfaction -->
	    	1
			<input type="radio" name="rating" value=1>
			<input type="radio" name="rating" value=2>
			<input type="radio" name="rating" value=3>
			<input type="radio" name="rating" value=4>
			<input type="radio" name="rating" value=5>
			5<br><br>
			Comments: (Optional)<br>											<!-- Accepts user comments -->
			<textarea id="comments" name="comments" rows="5" cols="50" placeholder="Please be as detailed as possible!"></textarea><br>
			<input type="submit" value="Submit"/><br>							<!-- A submit button -->
			<div style="color: #FF0000;">${errorMessage}</div><br>
			<div>${success}</div><br>	
		</form>
	</body>
</html>