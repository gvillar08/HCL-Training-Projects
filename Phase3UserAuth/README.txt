For documentation on individual methods and code, please see the comments within the code

Steps for running code:
	In MySQL Workbench, run the provided SQL in this folder
	Clone the project folder into Eclipse
	Edit application.properties with your own SQL credentials as needed
	Build the Maven project
	Run the project as a "Maven Build..." and enter "spring-boot:run" in goals
		Alternatively, run the project as a JUnit test to see the test results
	Give the program a minute to boot
	Enter "localhost:8090" in your browser of choice

Navigating the screens:
	Home.png
		This is the default login screen when the program is booted
		User can enter a username and password
		The inserted hyperlink is just for fun and takes you to Wish.com; this serves no practical purpose and just adds to the aesthetic
	HomeEmpty.png
		This is the error displayed when one or more fields are submitted empty or with whitespace only
	HomePassFAIL.png
		This is the error displayed when the username was found in the database but the password did not match
	HomeUserFAIL.png
		This is the error displayed when the username was not found in the database, regardless of password input
	LoginSuccess.png
		This is the screen displayed after a successful login
		The hyperlink will return you to the login screen

JUnit tests:
	JUnitPasses.png
		At the bottom of the image is the JUnit system output showing that all of the tests passed

Overall program notes:
	Although this program utilizes dummy data, it assumes that there are no duplicate usernames. Please keep this in mind if you change the SQL code to insert different users

Step-by-step documentation of creating the application:
	Cloned Tim's boilerplate code and made a couple formatting changes to my liking
	Created the login screen and success screens, as well as implementing the controller for the views
	Created SQL dummy data and worked on implementing a successful login by connecting to the database
	Ran into issues with connecting my application to the database, even after ensuring its format was similar to past projects, ensuring the SQL data was correct, and all of my code matched a Spring setup guide
	Looked over my code the next day and learned I simply needed to rename my User.java to Auth.java since @Entity converts it to a table, and the name of my SQL table is "auth" and not "user"
	Implemented verifying user credentials, cleaned up unused code, and moved on to implementing tests
	Implemented and successfully tested the EntityTests.java
	Deleted Tim's repository testing code as I have no methods in my UserRepository class to test
	Implemented and successfully tested the ServicesTests.java
	Took necessary screenshots
	Cleanup
		Deleted commented/unused code, added comments