package fileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

import java.util.Scanner;

public class FileHandling
{
    File doc = new File("C:\\Users\\gabriel.villar\\OneDrive - HCL Technologies Ltd\\Desktop\\tester\\generic.txt");	//please set the directory relevant to your computer!!!

	public void MakeFile()
	{  
		try
	    {		    
			if(doc.createNewFile())									//if it's a new file...
			{
				System.out.println("Created file: "+doc.getName());	//...tell the user it was created...
			}
			else
			{
				System.out.println("File already exists");			//...or tell the user it already exists
			}
	    }
		catch(Exception e)											//to catch exceptions
		{
			System.out.println("An error occured:");
			System.err.println(e.getMessage());
		}
	}
	
	public void WriteFile(String script)							//method for writing to file that takes in text to write
	{
		FileWriter writer = null;
		
        try
        {
            writer = new FileWriter(doc, true);						//creates the writer and allows it to append
    	    writer.write(script);									//writes the input text
        }
        catch(IOException iex)										//for catching an IO Exception
        {
            System.err.println("Failed writing to file.");
        }
        catch(NullPointerException npe)								//for catching a null pointer exception
        {
            System.err.println("File does not exist yet.");
        }
        finally
        {
            try
            {
                if (writer != null)									//after all of the above and if the writer isn't empty...
                {
                    writer.flush();									//flush the writer and close it
                    writer.close();
                }
            }
            catch (IOException e)									//for catching another IO Exception
            {
            	e.printStackTrace();
            }
        }
	}
	
	public void ReadFile()											//method for reading the file
	{        
		try
		{
			Scanner sc = new Scanner(doc);

			while(sc.hasNextLine())									//iterates over every line and prints each individually
			{
				String output = sc.nextLine();
				System.out.println(output);
			}
			sc.close();
		}
		catch(Exception e)											//for exception handling
		{
			System.out.println("Oopsies an error:");
			e.printStackTrace();
		}
	}
	
	public boolean IsEmptyFile()									//method for checking if the file is empty
	{
		if(doc.length() == 0)
		{
			return true;											//return true if it is empty
		}
		else
		{
			return false;
		}
	}
}