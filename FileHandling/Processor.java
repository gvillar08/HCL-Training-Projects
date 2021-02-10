package fileHandling;

import java.util.Scanner;

public class Processor
{
  public static void main(String[] args)
  {
	  FileHandling fileHandling = new FileHandling(); 
	  Scanner scanner = new Scanner(System.in);
	  
	  System.out.println("Checking if file exists...");
	  fileHandling.MakeFile();										//prints if the file already exists or not and creates it if not
	  String x = "Number 15: Burger king foot lettuce. The last thing you'd want in your Burger King burger is someone's foot fungus. But as it turns out, that might be what you get. A 4channer uploaded a photo anonymously to the site showcasing his feet in a plastic bin of lettuce. With the statement: This is the lettuce you eat at Burger King. Admittedly, he had shoes on."+"\n";
	  if(fileHandling.IsEmptyFile() == true)						//if the file is empty, it writes the above sample text into it
	  {
		  System.out.println("Writing sample text to file...");
		  fileHandling.WriteFile(x);
	  }
	  System.out.println("Printing file contents...");
	  fileHandling.ReadFile();										//reads the file and prints the contents. If the user previously appended text, it will show
	  System.out.println("Please type what you would like to append to the end of this file: ");
	  String apnd = scanner.nextLine();
	  fileHandling.WriteFile(apnd);									//appends the user's input to the end of the file
	  System.out.println("Append successful");
  }
}