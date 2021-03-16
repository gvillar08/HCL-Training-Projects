package lockedMe;

public class Main
{
	public static Screens screens = new Screens();

	public static void main(String[] args)
	{
		screens.AddTestData();		//this line can be removed/commented to disable adding test data
		screens.WelcomeScreen();	//boots the program
	}
}
