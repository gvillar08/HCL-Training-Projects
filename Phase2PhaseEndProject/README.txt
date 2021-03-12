For documentation on individual methods and code, please see the comments within the code

Steps for running code:
	In MySQL Workbench, run the provided SQL at the bottom of this document
	Clone the code into Eclipse with the same file structure as provided
	Edit hibernate.cfg.xml with your own SQL credentials as needed
	Build the Maven project
	Right click on the project > properties > deployment assembly > ensure that Maven Dependencies are present
	Run main.jsp on Tomcat server

Navigating the screens:
	main.jsp 	(MenuDefault.png)
		This serves as the main menu
		User can enter username and password here or select a hyperlink for creating a new account
		Submit button possiblities:
			Regardless of input, if there are no users, the user is notified and given a hyperlink to creating an account	(MenuNoUsers.png)
			If username isn't found, user is notified									(MenuInvalidUser.png)
			If username is found but password isn't, user is notified of mismatch						(MenuInvalidPass.png)
			If credentials are correct, user is redirected to landing.jsp
	landing.jsp	(LandingDefault.png)
		This page is accessed upon successful login
		The only option here is to select a hyperlink to return to the main menu
	newAcct.jsp	(RegisterDefault.png)
		This page is accessed when creating a new account hyperlink is clicked
		User can click a hyperlink to return to the main menu
		User can input a new username, password, and confirm the password
		Submit button possibilities:
			If any of the fields are empty, user is notified								(RegisterEmpty.png)
			If the password confirmation does not match, the user is notified						(RegisterMismatch.png)
			If the username matches one already in the database, the user is notified to create a unique name		(RegisterDuplicate.png)
			If none of the fields are empty and the passwords match, the user is notified of the success and given a hyperlink to return to the main menu to sign in (RegisterSuccess.png)

Overview of data layer:
	At the SQL data layer, little is happening
	The database is duplicated into a list during login and registration for checking if credentials already exist
	Changes are appended to the database via hibernate upon an account creation

Overall program notes:
	Program does not allow duplicate usernames
	Upon first use of the program, an account needs to be created before signing in
	The first submission in any section will take a minute to process. Afterwards, submissions will run smoothly
		Note that a password mismatch or empty field in newAcct.jsp does not boot hibernate, thus runs quickly
	All errors returned to the user appear in red text under the text boxes in either web page
	There are only 3 pages a user can reach; errors are presented in the user's current page

Step-by-step documentation of creating the application:
	Created a crude depiction of front-end layout and possibilites. See FrontEndLayout.png for further details.
		This document might not fully depict the actual end project as this is just a desired layout to assist in writing code
	Cloned and implemented Tim's boilerplate code* for setting up the application in Eclipse
		*https://github.com/timfox456/java-fsd-phase2/tree/main/phase-end-project
	Created a database and table for storing usernames and passwords. See "SQL code used" at the bottom of this page
	Made a few small changes to the boilerplate code, such as editing code to match my SQL login and respective database
	Created two more jsp pages (newAcct.jsp and landing.jsp) for future use
	Edited main.jsp's layout
	Had to manually add a username and password to the database to work on the login functionality
	Implemented logging into the main page
	Finalized landing.jsp for successful logins
	Implemented generating the correct messages for creating an account
	Implemented functionality of posting a successful entry to the database
	Added an error use case for logging in and tweaked layouts of jsp pages slightly
	Post-coding cleanup
		Deleting unused imports, commented code, ensuring indents are correct, etc
	Inserted comments
	Took screenshots of results

SQL code used:
	CREATE DATABASE boringWebsite;
	CREATE TABLE boringWebsite.user (
		id  int(11) AUTO_INCREMENT,
		username VARCHAR(256),
		password VARCHAR(256),
		PRIMARY KEY (`id`)
	);
