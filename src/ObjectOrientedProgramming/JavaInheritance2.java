package ObjectOrientedProgramming;

/**
 * Write the following code in your editor below:
 * 
 * 1. A class named Arithmetic with a method named add that takes 2 integers as
 * parameters and returns an integer denoting their sum. 
 * 2. A class named Adder that inherits from a superclass named Arithmetic. 
 * Your classes should not be be public.
 * 
 * Input Format
 * 
 * You are not responsible for reading any input from stdin; a locked code stub
 * will test your submission by calling the add method on an Adder object and
 * passing it integer parameters.
 * 
 * Output Format
 *
 * You are not responsible for printing anything to stdout. Your add method must
 * return the sum of its parameters.
 * 
 * Sample Output
 * 
 * The main method in the Solution class above should print the following:
 * 
 * My superclass is: Arithmetic 
 * 42 13 20
 * 
 * @author SMD_ASY
 *
 */

public class JavaInheritance2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adder ad = new Adder();
		System.out.printf("My superclass is: %s\n", ad.getClass().getSuperclass().getSimpleName());
		System.out.print(ad.add(10, 32) + " " + ad.add(10, 3) + " " + ad.add(10, 10));
	}

}

class Arithmetic {

	public int add(int a, int b) {
		return a + b;
	}
}

class Adder extends Arithmetic {

}
