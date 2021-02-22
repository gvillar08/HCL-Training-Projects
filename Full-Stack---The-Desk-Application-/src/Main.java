//package fixBugs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	private static ArrayList<Integer> expenses = new ArrayList<>();	//moved
    private static Scanner sc = new Scanner(System.in);				//moved

	public static void addSampleExpenses()			//moved
	{
		expenses.add(1000);		//moved
        expenses.add(2300);		//moved
        expenses.add(45000);	//moved
        expenses.add(32000);	//moved
        expenses.add(110);		//moved
	}
    public static void main(String[] args)
    {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        addSampleExpenses();		//added
        optionsSelection();
    }
    private static void optionsSelection()
    {
    	boolean firstRun = true;	//this is read only on the first pass of the code, therefore, it is true
    	
        breaker:		//added this breaker to break out of while loop if the user wants quit
        while(true)		//added
        {
    		String[] arr = {"1. I wish to review my expenditure",
	                "2. I wish to add my expenditure",
	                "3. I wish to delete my expenditures",		//changed "expenditure" to "expenditures". This action doesn't delete a single expenditure, rather all of them
	                "4. I wish to sort the expenditures",
	                "5. I wish to search for a particular expenditure",
	                "6. Close the application"
	        };
	        int[] arr1 = {1,2,3,4,5,6};
	        int  slen = arr1.length;
	        
	        for(int i=0; i<slen;i++)
	        {
	            System.out.println(arr[i]);
	            // display the all the Strings mentioned in the String array
	        }
	        
	        System.out.println("\nEnter your choice:\t");
	        
	        if(intChecker(firstRun))		//added this to check if user's entry is an int
	        {
	        	int  options =  sc.nextInt();
		        
		        switch (options)
		        {
		            case 1:
		                System.out.println("Your saved expenses are listed below: \n");
		                System.out.println(expenses+"\n");
		                break;
		            case 2:
		                System.out.println("Enter the value to add your Expense: \n");
		    	        if(intChecker(firstRun))	//added
		    	        {
			                int value = sc.nextInt();
			                expenses.add(value);
			                System.out.println("Your value is updated\n");
			                System.out.println(expenses+"\n");
		    	        }
		                break;
		            case 3:
		                System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
		    	        if(intChecker(firstRun))	//added
		    	        {
			                int con_choice = sc.nextInt();
			                if(con_choice==options)
			                {
			                    expenses.clear();
			                    System.out.println("All your expenses are erased!\n");
			                }
			                else
			                {
			                    System.out.println("Oops... try again!");
			                }
		    	        }
		                break;
		            case 4:
		                sortExpenses(expenses);
		                System.out.println(expenses);		//added
		                break;
		            case 5:
		                System.out.println("Enter the expense you need to search:\t");	//moved
		                if(intChecker(firstRun))	//added
		                {
		                	int search = sc.nextInt();			//added
		            		searchExpenses(expenses, search);	//included search
		                }
		                break;
		            case 6:
		                System.out.println("Closing your application... \nThank you!");
		                break breaker;
		            default:
		                System.out.println("You have made an invalid choice!");
		                break;
		        }
	        }
	        firstRun = false;		//sets 
        }
    }
    private static boolean intChecker(boolean first)	//this method checks if the user's entry is numeric to ensure the code does not break, as well as not copy/pasting the else statement into every case that has an entry
    {
    	if(first == false)		//if this were true on the first run, it would initially ask the user for two entries
    		sc.nextLine();		//this essentially flushes the scanner to allow another entry if it returns false
    	if(sc.hasNextInt())		//checks if the entry is an int
    		return true;
    	else					//notifies the user if the entry isn't purely numeric
    	{
    		System.out.println("Please submit a numeric entry\n");
    		return false;
    	}
    }
    private static void searchExpenses(ArrayList<Integer> arrayList, int search)		//included a search to pass in
    {
        if(arrayList.indexOf(search) == -1)			//if the search couldn't be found:
           System.out.println("Expense "+search+" could not be found");
        else										//if the search could be found:
           System.out.println("Expense "+search+" is item #"+(arrayList.indexOf(search)+1));
    }
    private static void sortExpenses(ArrayList<Integer> arrayList)		//this does the "dividing" of MergeSort
    {
        if (arrayList.size() != 1)							//sorts if the size isn't 1
        {
            ArrayList<Integer> left = new ArrayList<>();	//arrayList for the left side and right side
            ArrayList<Integer> right = new ArrayList<>();
            boolean logicalSwitch = true;
            while (!arrayList.isEmpty())					//while the arrayList isn't empty...
            {
                if (logicalSwitch)							//...use the switch to toggle between the left and right sides
                    left.add(arrayList.remove(0));			//this moves the first value from the arrayList (which is expenses during the first run) to the left side
                else
                    right.add(arrayList.remove(0));			//same as above but to the right side
                
                logicalSwitch = !logicalSwitch;				//the switch is toggled
            }
            sortExpenses(left);
            sortExpenses(right);           
            arrayList.addAll(mergeSort(left, right));		//calls the mergeSort method to complete the sorting
        }
    }
    private static ArrayList<Integer> mergeSort(ArrayList<Integer> left,  ArrayList<Integer> right)		//this does the "conquering" (actual sorting) of MergeSort
    {
        ArrayList<Integer> merged = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty())			//while the left and right sides aren't empty...
        {
            if (left.get(0).compareTo(right.get(0)) <= 0)	//compare the first value of the left and right sides
                merged.add(left.remove(0));					//move the value from the left to the temporary arrayList, merged
            else
                merged.add(right.remove(0));				//same as above but the right side is moved
        }
        merged.addAll(left);
        merged.addAll(right);
        return merged;
    }
}