package longestIncreasing;

public class LongestIncreasingApplication
{
	public static void main(String[] args)
	{
		Sequence seq = new Sequence();
		System.out.println("Please note that the length is randomly n<100 and each number is randomly n<100");
		System.out.println("The complete sequence is:   "+seq.SequenceGenerator());
		System.out.println("The longest subsequence is: "+seq.SequenceFinder());
	}
}