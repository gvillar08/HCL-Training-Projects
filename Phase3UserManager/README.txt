For documentation on individual methods and code, please see the comments and logging outputs within the code

Steps for running code:
	In MySQL Workbench, run the provided SQL at the bottom of this document
	Clone the code into Eclipse with the same file structure as provided
	Edit application.properties with your own SQL credentials as needed
	Build the Maven project
	Run the project as a "Maven Build..." and enter "spring-boot:run" in goals
	Enter "localhost:8090" in your browser of choice
	Give the program a minute to boot

Navigating the screens: (These results are based on the provided SQL at the bottom of this document)
	MainMenu.png
		This is the default screen when starting the program
		The database of known users is displayed and the user can input a user id to edit
		MainMenuNonNumeric.png
			Result if the user enters a non-numeric entry
		MainMenuSearchFail.png
			Result if the user enters a number that does not match a listed user id
		MainMenuEdited.png
			Result after making a name change and returning to the menu
	EditMenu.png
		This is the default screen once the user enters a valid search from the main menu
		The details of the searched user is displayed, along with fields for inputting changes
		EditMenuAllEmpty.png
			Result if the user submits all of the fields blank
		EditMenuSuccess.png
			Result if at least one of the fields wasn't blank when submitted
			See MainMenuEdited.png and its respective comments for when you return to main menu after this

Overall program notes:
	There are no required formats when editing any of the users' fields

Step-by-step documentation of creating the application:
	Cloned Tim's boilerplate code and made a couple formatting changes to my liking
	Used Tim's boilerplate SQL code to create my own table
	Merged his users.jsp into the index.jsp to create how I envision the home page to be
	Focused on creating the MainController and UserService
		Within MainController, I focused on confirming the user's id search through if statements
		Within UserService, I added toInt to convert searches to int and handle errors, as well as condensing Tim's GetUserById to a try-catch block
	Deleted some controllers and jsps that I won't need
	Simplified the folder hierarchy for src/main/java
	Although the home page worked, the table would disappear once an entry was submitted, so I fixed that
	Worked on UserController, UserService, and edit.jsp
		Although implementing these was similar to implementing the first screen earlier, I implemented a getter and setter in UserService for saving the user search input
	Cleanup
		Deleting commented/unused code, adding logging comments, adding comments

SQL code used:
	create database users;
	use users;
	CREATE TABLE `user` (
	  `id` int NOT NULL AUTO_INCREMENT,
	  `username` varchar(255) DEFAULT NULL,
	  `name` varchar(255) DEFAULT NULL,
	  `password` varchar(255) DEFAULT NULL,
	  PRIMARY KEY (`id`)
	);
	insert into user (username, name, password) VALUES ("xX_TimboBaggins_Xx", "Tim", "password");
	insert into user (username, name, password) VALUES ("hotPotato", "Mary", "abc123");
	insert into user (username, name, password) VALUES ("SuperCoolDude", "Lee", "cr171c4l");