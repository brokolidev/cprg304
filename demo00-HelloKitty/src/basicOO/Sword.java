package basicOO;

import exceptions.InvalidDamageValueException;

public class Sword implements Weapon
{

	private int damage;

	public Sword()
	{
		this.damage = 1;
	}

	public Sword( int damage ) throws InvalidDamageValueException
	{
		if( damage < 1 )
			throw new InvalidDamageValueException();
		this.damage = damage;
	}

	public int getdamage()
	{
		return damage;
	}

	public void setdamage( int damage ) throws InvalidDamageValueException
	{
		if( damage < 1 )
			throw new InvalidDamageValueException();
		this.damage = damage;
	}

	@Override
	public void attack()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void drop()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public String toString()
	{
		return "This sword has a damage of " + this.damage + ".";
	}

}
