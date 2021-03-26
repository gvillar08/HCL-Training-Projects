For documentation on individual methods and code, please see the comments within the code

Steps for running code:
	Clone the project folder into Eclipse
	Build the Maven project
	Run the project as a "Maven Build..." and enter "spring-boot:run" in goals
	Give the program a minute to boot
	Enter "localhost:8090" in your search engine of choice

Navigating the screens:
	HomeScreen.png
		The default screen shown once the default URL is entered
		Clicking "here" will direct the user to the login screen
			If the user has already logged in, they will skip that screen and go straight to the Hello screen
	LoginScreen.png
		Screen for entering credentials
	LoginScreenFAIL.png
		Error message displayed on the login screen for when user credentials are not valid
	HelloScreen.png
		Screen displayed once logged in
		Clicking "Log Out" will redirect the user to the login page
			The user can no longer access this screen until signed in again

Overall program notes:
	The footer at the bottom of each page, including the hyperlink to Wish.com, is just to add to the aesthetic of a spoof website and serves no practical purpose
	If the user has not successfully signed in yet and tries typing anything other than "/" or "/login" in the search bar, they will be redirected to the login URL
	The username and password is hard-coded into the program
		User: user
		Pass: pass

Step-by-step documentation of creating the application:
	Reviewed the project requirements and made a crude flowchart to assist with coding based off of them
	Copied the code from my previous project so I can build off of it
	Configured the code to save user login credentials in-memory
	Hit a wall, so I watched a tutorial on Spring Security
	Cloned the sample code from github.com/koushikkothagal/spring-security-jpa and started over
	Gave up on that and restarted back to Tim's code
	Cleaned up Tim's code to my liking and transferred my webpage from my previous assignent over to his jsp's
	Successfully integrated the webpages, deleted the unused ones, implemented error and log out messages, and implemented the ability to log out
	Took necessary screenshots and updated "Navigating the screens"
	Cleanup
		Deleted commented/unused code, added comments