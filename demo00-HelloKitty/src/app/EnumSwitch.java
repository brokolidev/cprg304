package app;

public class EnumSwitch
{

	enum Province
	{
		AB, BC, ON
	}

	public static void main( String[] args )
	{
		Province prov = Province.AB;
		int tax = 0;

		switch( prov )
		{
//		 	case BC -> // Java14+ lambda operator: -> (C# =>)
			case BC:
				tax = tax + 7; // PST for BC
			case AB:
				tax = tax + 5; // GST
				break;
			case ON:
				tax = tax + 13; // HST for ON
				break;
			default:
				System.out.println( "Please enter a valid province." );
		}
		
		System.out.println( "Total tax rate is: " + tax );
		
	}

}
