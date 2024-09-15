package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BasicFileIO
{

	public static void main( String[] args )
	{

//		File inputFile = new File( "res/sampleInput.txt" );
		File inputFile = new File( "sampleInput.txt" );
		Scanner input = null;

		try
		{
			input = new Scanner( inputFile );
		}
		catch( FileNotFoundException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while( input.hasNext() )
		{
			String name = input.next();
			System.out.println( name );

			String phoneNumber = input.next();
			System.out.println( phoneNumber );

			double amount = input.nextDouble();
			System.out.println( amount );
		}

	}

}
