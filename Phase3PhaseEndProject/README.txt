For documentation on individual methods and code, please see the comments within the code

Steps for running code:
	In MySQL Workbench, run the provided SQL in this folder
	Clone the project folder into Eclipse
	Edit application.properties with your own SQL credentials as needed
	Build the Maven project
	Run the project as a "Maven Build..." and enter "spring-boot:run" in goals
	Give the program a minute to boot
	Enter "localhost:8090" in your browser of choice

Navigating the screens:
	editTask.png
		Webpage for editing a task
		Note how all of the data for the task is prepopulated
	editTaskSUCCESS.png
		Editing a task message displayed when a task is successfully edited
	login.png
		Home page when program is loaded
		Users are redirected here if they attempt to go further than the login screen without being logged in
	loginEMPTY.png
		Login screen error when one or more fields are empty
	loginMISMATCH.png
		Login screen error when the username is valid but the password isn't
	loginNOTFOUND.png
		Login screen error when the username cannot be found, regardless of a non-null password
	newTask.png
		Webpage for creating a new task
	newTask255.png
		New task error when one of the text fields is over 255 characters long
		Surpassing this would break the SQL code
	newTaskDATE.png
		New task error when the start date is after the end date
	newTaskEMPTY.png
		New task error when a required field is empty
	newTaskSUCCESS.png
		New task successfully created message
	newUser.png
		Webpage for creating a new user
	newUser255.png
		New user error when one of the text fields is over 255 characters long
		Surpassing this would break the SQL code
	newUserEMPTY.png
		New user error when at least one field is empty
	newUserMISMATCH.png
		New user error when the passwords don't match
	newUserSUCCESS.png
		New user successfully created message
	newUserTAKEN.png
		New user error when the entered username is already taken
		The code requires unique usernames for each person
	tasks.png
		Webpage for displaying user-specific tasks in a table
		SQL dummy data is shown
	tasksADDED.png
		Tasks page after a new task is added
		Note how the email field is blank because it isn't a required field when filling the form
	tasksDELETE.png
		Popup on the task page when the user clicks the delete button
		The task is deleted ONLY if the ok button is selected
	tasksEDITED.png
		Tasks page after the first entry is edited. Note how the dummy description data now says EDITED at the end
	tasksEMPTY.png
		Tasks page when the user has no tasks to display
		This is the default page when a user just created an account

Overall program notes:
	Although this program utilizes dummy data, it assumes that there are no duplicate usernames. Please keep this in mind if you change the SQL code to insert different users
	Note that screenshots for error messages during editing a user were omitted as they are wholly identical to error messages during creating a user
	Screenshots utilized dummy data within the SQL script

Step-by-step documentation of creating the application:
	Created a crude drawing of what the program will look like and how pages and databases are linked to each other to help me create the program
	Duplicated code from the previous Spring Security assignment to build off of it
	Started with the front-end screens and worked on integrating the database to display information
	Realized I was skipping ahead, so I focused on applying Agile methodology by creating working screens leading up to working on tasks
		Created the login screen and new user screen
	Made the login screen, new user screen, and tasks screen work with hard-coded spring security data before moving onto registering a user against the database
	Decided to rip out the Spring Security functionality as it was causing too many issues
	Implemented the login screen wholly and moved on to the new user screen
	Implemented the new user screen, along with saving new users to the database
	Moved onto the task screen and displaying the test SQL data
	Implemented functionality to prevent users that are not signed in from accessing the page, as well as implementing logging out
	Implemented functionality of displaying user-specific task tables
	Implemented a delete button for each item in the table
		Struggled to find a way for the program to notice which row number was selected so the respective row can be deleted
		Spent a while learning misc JS tools before learning about @PathVariable, which concisely solved my problem
	Integrated a confirmation before deletion
	Implemented row deletion
	Moved onto creating a new task before editing an existing task
	Ran into a wall with SQL not accepting my new tasks
		Learned the hard way that I was using reserved keywords and needed to use backticks in column declarations of the entity
	Moved on to implementing editing a task
	Implemented editing a task
		Reused creating a new task as the base code for this
		Implemented user details are prepopulated in the fields
	Cleanup
		Deleted commented/unused code, added comments
	Took necessary screenshots