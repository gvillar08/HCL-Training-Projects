package emailIdValidation;

import java.util.Scanner;

public class EmailIdValidation
{
	public static void main(String[] args)
	{
		EmailChecker emailChecker = new EmailChecker();				//For referencing the EmailChecker class
		Scanner sc = new Scanner(System.in);						//Create a new scanner for user input

		System.out.println("Welcome to Email ID Validator!");		//Instructions
		System.out.println("Type Quit to quit");
		System.out.println("Note that IDs are case-sensitive"+"\n");
		System.out.println("In this example, sample employee email IDs are as follows:");
		for(String email : emailChecker.sampleEmails)				//Lists all the sample emails
		{
			System.out.println(email);
		}
		System.out.println("\n"+"Please enter your search below");
		
		while(1==1)													//Loops till user quits
		{
			String entry = sc.nextLine();							//Retrieves user input
			
			if (entry.equals("Quit")||entry.equals("quit"))			//Checks if user wants to quit
			{
				System.out.println("Quitting...");
				break;												//Breaks the loop
			}
			else if((emailChecker.CheckEmail(entry)) == true)		//If the searched input is a match...
			{
				System.out.println(entry+" was found!");			//...notify user
			}
			else
			{
				System.out.println(entry+" couldn't be found. Make sure you are typing the email in correctly.");
			}
		}
	}
}