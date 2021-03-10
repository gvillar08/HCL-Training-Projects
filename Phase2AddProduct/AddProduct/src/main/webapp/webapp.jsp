<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<b>Please enter an animal name, color, and price into the following field to add to the animal registry</b><br>
		Please note that none of the following fields may be empty and price must be a numeric entry<br><br>
		<form method="post" action="pets">
			Name:  <input type="text" name="name"/><br>							<!-- This form takes in user input for name, color, and price -->
			Color: <input type="text" name="color"/><br>
			Price: <input type="text" name="price"/><br><br>
			Your first button press will take a minute to boot the program<br>
			<input type="submit" value="Submit all"/>
		</form>
		<form method="get" action="pets">
			<input type="submit" value="Print current registry"/>				<!-- This form lets the user press a button to display the database of animals -->
		</form>
	</body>
</html>