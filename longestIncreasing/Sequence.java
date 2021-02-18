package longestIncreasing;

import java.util.ArrayList;
import java.util.Random;

public class Sequence
{
	ArrayList<Integer> sequence = new ArrayList<Integer>();			//used for holding the entire sequence
	ArrayList<Integer> subsequence = new ArrayList<Integer>();		//used for holding the currently analyzed sub sequence
	ArrayList<Integer> subsequenceIdeal = new ArrayList<Integer>();	//used for holding the longest known sub sequence

	Random rand = new Random();										//will be used for making random numbers
	
	public ArrayList<Integer> SequenceGenerator()					//this method generates the entire sequence
	{
		int size = rand.nextInt(100);								//this sets the size of the sequence to a number between 0-99
		
		for(int x = 0; x<size; x++)
		{
			sequence.add(rand.nextInt(100));						//for every empty cell in the sequence of length size, it adds a number between 0-99
		}
		return sequence;
	}

	public ArrayList<Integer> SequenceFinder()						//this method finds the longest subsequence
	{
		subsequenceIdeal.add(sequence.get(0));						//this exists for worst case scenarios: all the numbers are decreasing or the length is <= 1. This exists so the method returns a value in these instances

		if(sequence.size()>1)										//if the length is greater than 1, the following code will not break
		{
			for(int n = 1; n<sequence.size(); n++)					//for every number in the sequence starting at the second value...
			{
				if(sequence.get(n)>sequence.get(n-1))				//...check if the current number is greater than the previous
				{
					if(subsequence.size()==0)						//if it's a match and this is the first match of the subsequence...
					{
						subsequence.add(sequence.get(n-1));			//...add the previous value before continuing
					}
					subsequence.add(sequence.get(n));				//add the current value
				}
				if(subsequence.size()>subsequenceIdeal.size())		//if the subsequence's size is greater than the longest subsequence we've found so far...
				{
					subsequenceIdeal = new ArrayList<Integer>(subsequence);	//update the longest subsequence to equal a copy of the current subsequence we have
				}
				if(sequence.get(n)<=sequence.get(n-1))				//if the current value is less than or equal to the previous value...
				{
					subsequence.clear();							//...this marks the end of the subsequence we are currently checking, which means we need to clear it before we can search for other subsequences
				}
			}
		}
		return subsequenceIdeal;
	}
}
