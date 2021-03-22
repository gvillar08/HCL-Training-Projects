<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<html>
	<body>
		<font face = "Comic sans MS" size =" 5" style="color: #ff00ff;">
		<h2>Welcom safe logging in screen NO VIRUS Norton aproved</h2>
		</font><br>
	    <form method="post" action="login">
			Username: <input type="text" name="username"/>						
			Password: <input type="password" name="password"/>						
			<input type="submit" value="Submit"/><br>					<!-- A submit button -->
			<div style="color: #FF0000;">${errorMessage}</div><br>		<!-- Error messages go here -->
			<!-- <div>${success}</div><br>									<!-- Successful message goes here -->			
		</form>
	</body>
	<footer>
		<a href="https://www.wish.com/~/gadgets/refurbished-apple-phones/?hide_login_modal=true">CLICK HERE! WIN ~NEW~ IPHONE 11!!! CLCIK!</a><br>
		<img src="https://tabarnapp.com/assets/img/icons2.png?v=7d25d779a9" alt="SAFE!">
		<img src="https://icon-library.com/images/ssl-secure-icon/ssl-secure-icon-14.jpg" alt="NOT VIRUS!" style="width:200;height:200;">
	</footer>
</html>