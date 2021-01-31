package calculator;

import java.util.*;

public class calculator
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Arithmetic Calculator!");
		System.out.println("Limited to one operator per formula. Valid operators are +-*/");
		System.out.println("You may type Quit at any time to quit");
		System.out.println("");
		
		outerloop:
		while (1==1)
		{
			double x = 0;
			String y = "";
			double z = 0;
			
			//First number entry
			System.out.println("Enter a number: ");
			while (1==1)												//loop exists in case there is a mis-entry
			{
				boolean catcher = false;								//resets a catch to continue the loop
				String entry1 = sc.nextLine();							//Retrieves value
				
				if (entry1.equals("Quit")||entry1.equals("quit"))		//checks if user wants to quit
				{
					System.out.println("Quitting...");
					break outerloop;									//breaks the whole code
				}
				
				try														//tries parsing the input into an int
				{
					x = Integer.parseInt(entry1);
				}
				catch (Exception e)										//if fails, it requests a number
				{
					System.out.println("Please enter a valid number");
					catcher = true;
				}
				if (catcher == false)									//if the code didn't cycle through the catch...
				{
					x = Integer.parseInt(entry1);						//...it sets the value because we now know it won't throw an error
					break;												//break this inner loop
				}
			}
			

			
			//Operator entry
			System.out.println("Enter an operator: ");
			while (1==1)
			{
				String entry2 = sc.nextLine();							//Retrieves value
				
				if (entry2.equals("Quit")||entry2.equals("quit"))		//checks if user wants to quit
				{
					System.out.println("Quitting...");
					break outerloop;
				}

				if (entry2.equals("+")||entry2.equals("-")||entry2.equals("*")||entry2.equals("/"))
				{
					y = entry2;											//if it is a valid operator, it breaks this inner loop...
					break;
				}
				else
				{
					System.out.println("Please enter a valid operator");//...otherwise, it will continue the loop till the user enters the correct operator or quits
				}
			}			
			
			
			
			//Final number entry. Essentially the same as first entry
			System.out.println("Enter a number: ");
			while (1==1)
			{
				boolean catcher = false;
				String entry3 = sc.nextLine();							//Retrieves value
				
				if (entry3.equals("Quit")||entry3.equals("quit"))		//checks if user wants to quit
				{
					System.out.println("Quitting...");
					break outerloop;
				}
				
				try														//tries parsing the input into an int
				{
					z = Integer.parseInt(entry3);
				}
				catch (Exception g)										//if fails, it requests a number
				{
					System.out.println("Please enter a valid number");
					catcher = true;
				}
				if (catcher == false)
				{
					z = Integer.parseInt(entry3);
					break;
				}
			}
			
			
			
			switch (y)													//Switch cases to perform the respective operator entry
			{
				case "+":
					System.out.println(x+z);
					break;
				case "-":
					System.out.println(x-z);
					break;
				case "*":
					System.out.println(x*z);
					break;
				case "/":
					System.out.println(x/z);
					break;
			}
		}
	}
}