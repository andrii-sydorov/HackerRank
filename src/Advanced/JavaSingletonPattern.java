package Advanced;

import java.util.Scanner;

/**
 * "The singleton pattern is a design pattern that restricts the instantiation
 * of a class to one object. This is useful when exactly one object is needed to
 * coordinate actions across the system."
 * - Wikipedia: Singleton Pattern
 * 
 * Complete the Singleton class in your editor which contains the following
 * components:
 * 
 * 1. A private Singleton non parameterized constructor.
 * 2. A public String instance variable named .
 * 3. Write a static method named getSingleInstance that returns the single
 * instance of the Singleton class.
 * Once submitted, our hidden Solution class will check your code by taking a
 * String as input and then using your Singleton class to print a line.
 * 
 * Input Format
 * 
 * You will not be handling any input in this challenge.
 * 
 * Output Format
 * 
 * You will not be producing any output in this challenge.
 * 
 * Sample Input
 * 
 * hello world
 * Sample Output
 * 
 * Hello I am a singleton! Let me say hello world to you
 */

public class JavaSingletonPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        Singleton sg = Singleton.getSingleInstance();
        sg.setStr(s);
        System.out.println(sg.str);
    }
}

class Singleton {

    public String str;
    private static Singleton sg;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (sg == null) {
            sg = new Singleton();
            return sg;
        }
        return sg;
    }

    public void setStr(String s) {
        str = String.format("Hello I am a singleton! Let me say %s to you", s);
    }
}
