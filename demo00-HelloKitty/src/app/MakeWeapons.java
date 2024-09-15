package app;

import basicOO.Sword;
import exceptions.InvalidDamageValueException;

public class MakeWeapons
{

	public static void main( String[] args )
	{

		try
		{
			Sword s = new Sword( 5 );
		}
		catch( InvalidDamageValueException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			// TODO
		}

	}

}
