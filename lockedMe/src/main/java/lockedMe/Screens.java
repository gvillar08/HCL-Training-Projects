package lockedMe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Screens
{
    private ArrayList<String> options = new ArrayList<>();
    Directory directory = new Directory();
    
	public void AddTestData()		//method is for adding sample data
    {
		directory.appender("test2.txt");
		directory.appender("Test1.txt");
		directory.appender("Creative_Essay.txt");
		directory.appender("New Folder");
		directory.appender("New Folder1");
    }

	public void WelcomeScreen()									//method for the Welcome Screen
	{
		System.out.println("Welcome to LockedMe.com!");
		System.out.println("Developer: Gabriel Villar");
		System.out.println("Menus can be navigated by entering the respective numeric option");
		
		breaker:
        while(true)												//display the following while the user is in this menu
        {			
        	options.add("1. Show Files");
	        options.add("2. Show File Options Menu");
	        options.add("3. Quit");
	        
	        PrtSc(options);										//display the options

	        switch(getOption())									//calls this method for valid user input
	        {
	            case 1:											//Show Files
	            	directory.sortDirectory(directory.files);		//calls directory class to sort files
	            	directory.printFiles();							//prints the results
	                break;
	            case 2:											//Show File Options Menu
	            	DirectoryService();								//calls this method to transfer the user over to this menu
	                break breaker;									//ends this screen
	            case 3:											//Quit
	            	System.out.println("Quitting...");
	            	break breaker;
	            default:										//if the user input doesn't match an option
	                System.out.println("Please enter a valid option");
	                break;
	        }
        }
	}
	
	public void DirectoryService()								//method for the File Options screen
	{
		breaker:
		while(true)												//display the following while the user is in this menu
		{
	        options.add("1. Add a File");
	        options.add("2. Delete a File");
	        options.add("3. Search a File");
	        options.add("4. Return to Main Menu");
	        options.add("5. Quit");
	        
	        PrtSc(options);										//display the options
	        
	        switch(getOption())									//calls this method for valid user input
	        {
	            case 1:											//Add a File
	            	System.out.println("Please enter a file name to add: ");
	            	directory.appender(fileInput());				//fileInput() gets user input, which is then passed to directory's appender()
	            	System.out.println("File added");
	                break;
	            case 2:											//Delete a File
	            	System.out.println("Please enter a file name to delete: ");
	            	directory.delete(fileInput());					//fileInput() gets user input, which is then passed to diretory's delete(). Delete() handles notifying the user of a fail/success
	                break;
	            case 3:											//Search a File
	            	System.out.println("Please enter a file name to search: ");
	            	int temp = directory.searchFile(fileInput());	//this temporary variable holds the resultant value of passing user input from fileInput() to directory's searchFile()
	            	if(temp != -1)									//if a match was found...
	            		System.out.println("Your searched file is item #"+(temp+1));	//...print the file's location. Note: files are sorted before printing file location
	            	break;
	            case 4:											//Return to Main Menu
	            	WelcomeScreen();								//calls this method to transfer user to Welcome Screen
	            	break breaker;									//ends this screen
	            case 5:											//Quit
	            	System.out.println("Quitting...");
	            	break breaker;
	            default:										//if user input doesn't match an option
	                System.out.println("Please enter a valid option");
	                break;
	        }
		}
	}
	
	public void PrtSc(ArrayList<String> options)				//this method prints all of the options and then clears the list for the next menu to utilize options
	{
		System.out.println();
		for (String s : options)								//for every option...
        {
            System.out.println(s);								//...print it...
        }
		this.options.clear();									//...and then clear all the stored options
	}
	
	private int getOption()										//method is called when numeric user input is required and returns the numeric user entry if applicable
    {
        Scanner sc = new Scanner(System.in);

        int returnOption = 0;									//default value if user input fails
        try														//try getting user input as an int
        {
            returnOption = sc.nextInt();
        }
        catch (InputMismatchException ex)						//catch the error if user entry isn't an int
        {}
        return returnOption;									//return the numeric user entry if applicable or the default value
    }
	
	private String fileInput()									//method is called when any form of user input is required and returns the user entry
	{
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();						//gets user input
        return userInput;										//returns user input
	}
}
