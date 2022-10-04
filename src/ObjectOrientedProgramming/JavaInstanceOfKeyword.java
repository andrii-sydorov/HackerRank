package ObjectOrientedProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * The Java instanceof operator is used to test if the object or instance is an
 * instanceof the specified type.
 * 
 * In this problem we have given you three classes in the editor:
 * 
 * Student class Rockstar class Hacker class In the main method, we populated an
 * ArrayList with several instances of these classes. count method calculates
 * how many instances of each type is present in the ArrayList. The code prints
 * three integers, the number of instance of Student class, the number of
 * instance of Rockstar class, the number of instance of Hacker class.
 * 
 * But some lines of the code are missing, and you have to fix it by modifying
 * only lines! Don't add, delete or modify any extra line.
 * 
 * To restore the original code in the editor, click on the top left icon in the
 * editor and create a new buffer.
 * 
 * Sample Input
 * 
 * 5 
 * Student 
 * Student 
 * Rockstar 
 * Student 
 * Hacker 
 * 
 * Sample Output
 * 
 * 3 1 1
 * 
 * @author SMD_ASY
 *
 */

public class JavaInstanceOfKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Object> ls = new ArrayList<>();
		int turns = Integer.valueOf(sc.nextLine());
		for (int i = 0; i < turns; i++) {
			switch (sc.nextLine()) {
			case "Student":
				ls.add(new Student());
				break;
			case "Rockstar":
				ls.add(new Rockstar());
				break;
			case "Hacker":
				ls.add(new Hacker());
				break;
			}
		}
		sc.close();
		System.out.println(countClasses(ls));
	}

	private static String countClasses(List<Object> ls) {
		int st = 0;
		int rs = 0;
		int hk = 0;
		for (Object object : ls) {
			st += object instanceof Student ? 1 : 0;
			rs += object instanceof Rockstar ? 1 : 0;
			hk += object instanceof Hacker ? 1 : 0;
		}
//		long st = Stream.of(ls).filter(x -> x instanceof Student).count();
//		long rs = Stream.of(ls).filter(x -> x instanceof Rockstar).count();
//		long hk = Stream.of(ls).filter(x -> x instanceof Hacker).count();
		return st + " " + rs + " " + hk;
	}

}

class Student {

}

class Rockstar {

}

class Hacker {

}
