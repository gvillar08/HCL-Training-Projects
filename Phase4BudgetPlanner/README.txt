Steps for running code:
	Unzip the bootstrap folder
	Open RestaurantFrontEnd and open any of the provided html files

Navigating the screens:
	finance.png
		Home screen for the Finance View
		Accessed by selecting the Finance View icon from the vendors.html page
		NOTE: Screenshots for this page's features are omitted as the functionality is duplicate to the Product Manager Features
			For features on this page, please see the respective Product Manager screenshots
	prodManager.png
		Home screen for the Product Manager View
		Accessed by selecting the Product Manager View icon from the financials.html page
	prodManagerADD.png
		Displays the result when an entry is submitted
		This addition occurred after the deletion of item #2; note how the ID is 3 rather than an incorrect 2
	prodManagerDELETE.png
		Displays the popup when a delete icon is selected
		Note that the deletion will be cancelled if anything other than Ok is selected
	prodManagerDELETE1.png
		Displays the successful deletion of item 2 from the table
	prodManagerEDIT.png
		Displays the editing table once an edit icon is selected
		The form is prepopulated with the respective info from the selected row
	prodManagerEDIT1.png
		Displays the popup when an edit is submitted
		Note that the edit will be cancelled if anything other than Ok is selected
		If the edit is cancelled, the edit form stays populated with the user's entries/prepopulated data
	prodManagerEDIT2.png
		Displays the successful edit of the first item
		Note that the editing form disappears after a successful edit and the ID/item position stays the same

Overall program notes:
	Screens are adaptable to screen size and should fit mobile devices just as well as desktops
	If the screen is reduced to a small mobile size, the top ribbon is condensed into a hamburger menu
	Although not shown in the screenshots, the icon next to the tab in the browser is the company logo
	Data does NOT persist between screens

Step-by-step documentation of creating the application:
	Created a crude drawing of what the program will look like and how pages are linked to each other to help me create the program
	Cloned Tim's boilerplate code to work with
		Cleaned up his code to meet peronal formatting style
	Copied my code from the previous assignment to build off of
		Copied snippets of Tim's code into the copies, as well as formatting the pages to match assignment layout
	Implemented hyperlins, switching views, the tables, adding items, and deleting items all very quickly and easily
	Moved on to editing items, which was the longest feature to complete
	Once editing was implemented, I copied and pasted the features across all the different views
	Realized the project is overcomplicated and deleted many repetitive views
	Implemented the financial view
	Inserted comments and deleted unused code
	Took necessary screenshots