Steps for running code:
	Open RestaurantFrontEnd and open any of the provided html files
		Preferably access the landing.html to arrive at the home page

Navigating the screens:
	contact.png
		Default screen for user-inputted feedback
		Can only be accessed via the "Contact Us" hyperlink at each page's footer
	contactSuccess.png
		Success screen once user feedback is submitted
	homeCarousel1.png
		Home screen's first carousel image
		Clicking the button will redirect the user to the menu
		Clicking the logo will redirect the user to this page
	homeCarousel2.png
		Home screen's second carousel image
		Clicking the button will redirect the user to the menu
	homeCarousel3.png
		Home screen's third carousel image
		Clicking the button will redirect the user to Our Story
	locations.png
		Default screen for showing restaurant's locations
		Directions buttons redirects the user to maps.google.com
			Note that there is no business logic to copy/paste the address into the maps
	menu.png
		Default menu screen, which can be accessed by home screen carousel buttons, the Menu icon, or Order Now
	menuInput.png
		Menu screen with values inputted for proof of concept
		Pressing the minus sign prevents the user from going lower than zero
	orderSuccess.png
		Success screen once a user clicks Place Order in the menu screen
	story.png
		Default Our Story screen
		Accessed by clicking Our Story in the navigation ribbon

Overall program notes:
	Screens are adaptable to screen size and should fit mobile devices just as well as desktops
	If the screen is reduced to a small mobile size, the top ribbon is condensed into a hamburger menu
	Although not shown in the screenshots, the icon next to the tab in the browser is the company logo

Step-by-step documentation of creating the application:
	Started with creating a sample logo, utilizing an Adobe open source bamboo stock image for the border
	Created a crude drawing of what the program will look like and how pages are linked to each other to help me create the program
		Looked to pandaexpress.com for inspiration
	Cloned Tim's boilerplate code to work with
		Cleaned up his code to meet peronal formatting style
	Scrapped Tim's code in favor for Bootstrap's carousel template code
	Implemented the landing page with my images and features in conjunction with the Bootstrap template
	Moved on to implementing a menu
	Implemented the order and feedback success screens
	Implemented the locations screen
	Implemented the story screen
	Implemented the contact screen
	Took necessary screenshots