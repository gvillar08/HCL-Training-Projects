package lockedMe;

import java.util.ArrayList;

public class Directory
{
    ArrayList<String> files = new ArrayList<String>();
    
    public void appender(String file)			//method appends input text to the end of the list of files
    {
    	files.add(file);
    }
    
    public void delete(String file)				//method deletes a specified file if found
    {
    	int temp = searchFile(file);			//calls searchFile() with the desired file to see if it exists
    	if(temp != -1)							//if the file does exist...
    	{
    		files.remove(temp);					//...remove it...
    		System.out.println("File successfully deleted");	//...and notify the user
    	}										//note: searchFile handles notifying the user if it doesn't exist
    }
    
    public int searchFile(String file)			//method searches for a specified file and returns its index if found
    {
        sortDirectory(files);					//files are sorted before searching
        
    	for(String ea : files)					//for every file...
        {
            if (ea.equals(file))				//...test if the entry is a match...
            {
                return files.indexOf(ea);		//...and return its index if successful
            }
        }
        System.out.println("Sorry, your entry was not found");	//notify the user if the entry was not found
        return -1;								//return a value to indicate failure
    }
    
    public void printFiles()					//method prints the list of files
    {
    	files.forEach(System.out::println);
    }
    
    public static void sortDirectory(ArrayList<String> arrayList)		//this does the "dividing" of MergeSort
    {
        if (arrayList.size() != 1)							//sorts if the size isn't 1
        {
            ArrayList<String> left = new ArrayList<>();		//arrayList for the left side and right side
            ArrayList<String> right = new ArrayList<>();
            boolean logicalSwitch = true;
            while (!arrayList.isEmpty())					//while the arrayList isn't empty...
            {
                if (logicalSwitch)							//...use the switch to toggle between the left and right sides
                    left.add(arrayList.remove(0));			//this moves the first value from the arrayList (which is expenses during the first run) to the left side
                else
                    right.add(arrayList.remove(0));			//same as above but to the right side
                
                logicalSwitch = !logicalSwitch;				//the switch is toggled
            }
            sortDirectory(left);
            sortDirectory(right);           
            arrayList.addAll(mergeSort(left, right));		//calls the mergeSort method to complete the sorting
        }
    }
    
    private static ArrayList<String> mergeSort(ArrayList<String> left,  ArrayList<String> right)		//this does the "conquering" (actual sorting) of MergeSort
    {
        ArrayList<String> merged = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty())			//while the left and right sides aren't empty...
        {
            if ((left.get(0).toLowerCase()).compareTo((right.get(0).toLowerCase())) <= 0)	//compare the first value of the left and right sides
                merged.add(left.remove(0));					//move the value from the left to the temporary arrayList, merged
            else
                merged.add(right.remove(0));				//same as above but the right side is moved
        }
        merged.addAll(left);
        merged.addAll(right);
        return merged;
    }
}
