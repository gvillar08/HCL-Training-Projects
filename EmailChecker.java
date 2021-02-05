package emailIdValidation;

public class EmailChecker
{
	String[] sampleEmails = {"gvillar08@live.com", "gvillar08@gmail.com", "gwvillar@calpoly.edu", "gabriel.villar@hcl.com"};	//sample emails for this example
	
	public boolean CheckEmail(String userInput)		//this method returns a bool and takes a string as input
	{
		for(String email : sampleEmails)			//for every email in the list...
		{
			if(email.equals(userInput))				//...check if the user's input matches it verbatim...
			{
				return true;						//...and break the loop to return true if it does
			}
		}
		return false;								//If it reaches the end without a match, return false
	}
}
