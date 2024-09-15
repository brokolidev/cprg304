package app;

public class FunWithDataTypes
{

	public static void main( String[] args )
	{
		// 16-bit unicode
		char a = 'A'; // default: 0 = '\u0000', not the same as "null"!
		Character aWrapped = new Character( 'A' );
		Character aWrappedAlt = 'A';

		// no defined size
		boolean flag = true; // default = false

		// signed 8-bits, -128 to 127
		byte b = 0;

		// signed 16-bits, -32768 to 32767
		short s = 0;

		// signed 32-bits, -2^31 to 2^31-1
		int i = 0;

		// signed 64-bits, =2^63 to 2^63-1
		// unsigned longs exist in Java8+ but I don't recommend using it!
		long l = 0L;

		// 32-bit single precision, signed +/-3.410e-38 to +/-3.410e38
		// 7 digits of accuracy
		float f = 0.0f;

		// 62-bit double precision, signed +/-1.710e-308 to +/-1.710e308
		// 15 digits of accuracy
		double d = 0.0; // or 0.0d

		System.out.println( d = i ); // Java will add the .0 for you
		System.out.println( i = (int) d ); // You must cast yourself
	}

}
