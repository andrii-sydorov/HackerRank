package Advanced;

import java.io.*;
import java.util.*;

/**
 * You are given a class Solution and its main method in the editor. Your task
 * is to create a class Prime. The class Prime should contain a single method
 * checkPrime.
 * 
 * The locked code in the editor will call the checkPrime method with one or
 * more integer arguments. You should write the checkPrime method in such a way
 * that the code prints only the prime numbers.
 * 
 * Please read the code given in the editor carefully. Also please do not use
 * method overloading!
 * 
 * Note: You may get a compile time error in this problem due to the statement
 * below:
 * 
 * BufferedReader br=new BufferedReader(new InputStreamReader(in));
 * 
 * This was added intentionally, and you have to figure out a way to get rid of
 * the error.
 * 
 * Input Format
 * 
 * There are only five lines of input, each containing one integer.
 * 
 * Output Format
 * 
 * There will be only four lines of output. Each line contains only prime
 * numbers depending upon the parameters passed to checkPrime in the main method
 * of the class Solution. In case there is no prime number, then a blank line
 * should be printed.
 * 
 * Sample Input
 * 
 * 2
 * 1
 * 3
 * 4
 * 5
 * Sample Output
 * 
 * 2
 * 2
 * 2 3
 * 2 3 5
 */

public class PrimeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = Integer.valueOf(sc.nextLine());
        int n2 = Integer.valueOf(sc.nextLine());
        int n3 = Integer.valueOf(sc.nextLine());
        int n4 = Integer.valueOf(sc.nextLine());
        int n5 = Integer.valueOf(sc.nextLine());
        PrimeCheck p = new PrimeCheck();
        p.checkPrime(n1);
        p.checkPrime(n1, n2);
        p.checkPrime(n1, n2, n3);
        p.checkPrime(n1, n2, n3, n4, n5);
        sc.close();
    }
}

class PrimeCheck {
    public void checkPrime(int... args) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (isPrime(args[i])) {
                ls.add(args[i]);
            }
        }
        ls.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
