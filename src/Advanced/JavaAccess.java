package Advanced;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;

/**
 * You are given a class Solution and an inner class Inner.Private. The main
 * method of class Solution takes an integer as input. The powerof2 in class
 * Inner.Private checks whether a number is a power of . You have to call the
 * method powerof2 of the class Inner.Private from the main method of the class
 * Solution.
 * 
 * Constraints
 * 
 * 1 <= num <= 2 ^ 30
 * 
 * Sample Input
 * 
 * 8
 * Sample Output
 * 
 * 8 is power of 2
 * An instance of class: Solution.Inner.Private has been created
 */

public class JavaAccess {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o = null;// Must be used to hold the reference of the instance of the class
            // Solution.Inner.Private
            o = new Inner().new Private();
            //o = new JavaAccess.Inner().new Private();  also works
            System.out.println(String.format("%s is %s", num, new Inner().new Private().powerof2(num)));
            // Write your code here

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }

        JavaAccess.print(); // when we are tryoing to access to static method we shouldn't create an instance of class, but to get access to static class we should use "new OutterClass.StaticClass()"
    }

    public static void print() {
        System.out.println("print");
    }

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }

}

class DoNotTerminate { // This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
