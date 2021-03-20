For documentation on individual methods and code, please see the comments and logging outputs within the code

Steps for running code:
	In MySQL Workbench, run the provided SQL at the bottom of this document
	Clone the code into Eclipse with the same file structure as provided
	Edit application.properties with your own SQL credentials as needed
	Build the Maven project
	Run the project as a "Maven Build..." and enter "spring-boot:run" in goals
	Give the program a minute to boot
	Enter "localhost:8090" in your browser of choice

Navigating the screens:
	Feedback.png
		This is the default feedback screen
		Failing to enter data in any of the fields marked "Required" and submitting will lead to FeedbackNULL.png and none of the info is appended to the database
		As seen in the feedback form, comments are optional
		Successfully filling the fields will lead to FeedbackPopulated.png
	FeedbackNULL.png
		Except rating, all fields are marked as null
	FeedbackPopulated.png
		Once this page has been reached, submitted data has been successfully appended to the database and user input is displayed in JSON format

Step-by-step documentation of creating the application:
	Cloned Tim's boilerplate code and made a couple formatting changes to my liking
	Used Tim's boilerplate SQL code to create my own table
		See the SQL code used at the bottom of this document
	Created the web.xml and then the home.jsp to provide a visual framework to work off of
	Deleted web.xml because that isn't necessary
	Made a crude drawing to better understand the flow of logic through controllers
	Created RestfulController class
	Worked on home.jsp and FeedbackController till it was able to retrieve user input and set it
	Worked on setting up the RestfulController to append feedback to the database
	To make it work, I had to essentially transfer the functionality form the FeedbackController to this controller
	Deleted the Success and Failure jsp pages because they were unnecessarily complicating the assignment
	Realized I was overthinking everything and simplified my POST to a few lines of code to output the required JSON
	Cleanup
		Deleting commented/unused code, adding comments

SQL code used:
	create database Feedback;
	use Feedback;
	CREATE TABLE `feedback` (
	  `id` int NOT NULL AUTO_INCREMENT,
	  `comments` varchar(255) DEFAULT NULL,
	  `rating` int NOT NULL,
	  `user` varchar(255) DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ;

	insert into feedback (comments, rating, user) VALUES ("Awesome", 10, "tim");
	insert into feedback (comments, rating, user) VALUES ("Awesome 2", 10, "tim");
	insert into feedback (comments, rating, user) VALUES ("Awesome 3", 10, "tim");