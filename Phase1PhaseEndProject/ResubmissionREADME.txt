In this resubmission for the Phase 1 Phase End project, I have included screenshots of the code outputs. Since there is no explanation of the outputs in my documentation, I'll do so in this README.
Note that before taking each of these screenshots, I rebooted the program to minimize unnecessary console outputs from previous screenshots

MainMenu.png
	This is the main menu of the application
Show Files.png
	If you enter 1 in the main menu, it will output the test files as shown
Show File Options Menu.png
	If you enter 2 in the main menu, it will output the secondary menu screen as shown
Quit.png
	If you quit in either screen, it will output "Quitting..." before quitting
Add a File.png
	If you enter 1 in the secondary menu, you will be prompted to enter a new file name
	From here, you are notified of the success
	To prove that the file was appended, I then returned to the main menu and pressed 1 to output the list of files
	As you can see in the output, the test file, "qwerty", has been added successfully and is in alphabetical order
Delete a File_SUCCESS.png
	I went to the secondary menu and added "qwerty"
	From here, I entered 2 to delete a file and was prompted to enter a file name to delete
	I entered qwerty and the file name was successfully found and deleted
	I returned to the main menu and output the list of files to show it was successfully deleted
Delete a File_FAIL.png
	I went to the secondary menu and entered 2 to delete a file
	I entered "this file does not exist", which does not match any of the test files stored
	The program searched for it, failed, and notified me
Search a File_SUCCESS.png
	In the secondary menu, I entered 3 to search for a file and was prompted for an entry
	I searched "New Folder", and as this is a file in the program, it was found successfully and I was notified of its alphabetical position
Search a File_FAIL.png
	In the secondary menu, I entered 3 to search for a file and was prompted for an entry
	I searched "qwerty", and as this file has not been added to the program, I was notified it could not be found
Return to Main Menu.png
	This simply shows what happens if you select 4 within the secondary menu
