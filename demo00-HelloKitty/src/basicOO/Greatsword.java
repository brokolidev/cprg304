package basicOO;

import exceptions.InvalidDamageValueException;

public class Greatsword extends Sword
{

	public Greatsword( int... values ) throws InvalidDamageValueException
	{
		super( values[0] );
		this.setdamage( getdamage() * values[1] );
	}

}
