package Advanced;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * This Java 8 challenge tests your knowledge of Lambda expressions!
 * 
 * Write the following methods that return a lambda expression performing a
 * specified action:
 * 
 * 1. PerformOperation isOdd(): The lambda expression must return true if a number is
 * odd or false if it is even.
 * 2. PerformOperation isPrime(): The lambda expression must return true if a number is
 * prime or false if it is composite.
 * 3. PerformOperation isPalindrome(): The lambda expression must return true if a
 * number is a palindrome or false if it is not.
 * 
 * Input Format
 * 
 * Input is handled for you by the locked stub code in your editor.
 * 
 * Output Format
 * 
 * The locked stub code in your editor will print lines of output.
 * 
 * Sample Input
 * 
 * The first line contains an integer, (the number of test cases).
 * 
 * The subsequent lines each describe a test case in the form of space-separated
 * integers:
 * The first integer specifies the condition to check for ( for Odd/Even, for
 * Prime, or for Palindrome). The second integer denotes the number to be
 * checked.
 * 
 * 5
 * 1 4
 * 2 5
 * 3 898
 * 1 3
 * 2 12
 * Sample Output
 * 
 * EVEN
 * PRIME
 * PALINDROME
 * ODD
 * COMPOSITE
 */

public class JavaLambdaExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int turns = Integer.valueOf(sc.nextLine());
        lambdaExpression(turns, sc);
        sc.close();
    }

    public static void lambdaExpression(int turns, Scanner sc) {
        Odd odd = x -> x % 2 != 0;
        Prime prime = x -> {
            if (x <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        };
        Palindrome palindrome = x -> {
            String s = String.valueOf(x);
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        };

        List<String> ls = new ArrayList<>();

        for (int i = 0; i < turns; i++) {
            int[] data = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int key = data[0];
            int n = data[1];
            switch (key) {
                case 1:
                    if (odd.isOdd(n)) {
                        ls.add("ODD");
                    } else {
                        ls.add("EVEN");
                    }
                    break;
                case 2:
                    if (prime.isPrime(n)) {
                        ls.add("PRIME");
                    } else {
                        ls.add("COMPOSITE");
                    }
                    break;
                case 3:
                    if (palindrome.isPalindrome(n)) {
                        ls.add("PALINDROME");
                    } else {
                        ls.add("IS NOT PALINDROME");
                    }
                    break;
                default:
                    System.out.println("Incorrect data input");
            }
        }

        ls.forEach(x -> System.out.println(x));
    }
}

interface Odd {
    public boolean isOdd(int n);
}

interface Prime {
    public boolean isPrime(int n);
}

interface Palindrome {
    public boolean isPalindrome(int n);
}
