package utilities;

import java.util.Scanner;

public class GrabUserName
{

	public String getTheName()
	{
		System.out.println( "What is your name?" );
		Scanner keyboardInput = new Scanner( System.in );
		String userName = keyboardInput.nextLine();
		return userName;
	}

}
