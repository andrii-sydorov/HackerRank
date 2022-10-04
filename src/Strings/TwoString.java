package Strings;

import java.util.Scanner;

/**
 * "A string is traditionally a sequence of characters, either as a literal
 * constant or as some kind of variable." — Wikipedia: String (computer science)
 * 
 * This exercise is to test your understanding of Java Strings. A sample String
 * declaration:
 * 
 * String myString = "Hello World!"
 * The elements of a String are called characters. The number of characters in a
 * String is called the length, and it can be retrieved with the String.length()
 * method.
 * 
 * Given two strings of lowercase English letters, and , perform the following
 * operations:
 * 
 * 1. Sum the lengths of and .
 * 2. Determine if is lexicographically larger than (i.e.: does come before in the
 * dictionary?).
 * 3. Capitalize the first letter in and and print them on a single line, separated
 * by a space.
 * Input Format
 * 
 * The first line contains a string . The second line contains another string .
 * The strings are comprised of only lowercase English letters.
 * 
 * Output Format
 * 
 * There are three lines of output:
 * For the first line, sum the lengths of and .
 * For the second line, write Yes if is lexicographically greater than otherwise
 * print No instead.
 * For the third line, capitalize the first letter in both and and print them on
 * a single line, separated by a space.
 * 
 * Sample Input 0
 * 
 * hello
 * java
 * 
 * Sample Output 0
 * 
 * 9
 * No
 * Hello Java
 * Explanation 0
 * 
 * String is "hello" and is "java".
 * 
 * has a length of , and has a length of ; the sum of their lengths is .
 * When sorted alphabetically/lexicographically, "hello" precedes "java";
 * therefore, is not greater than and the answer is No.
 * 
 * When you capitalize the first letter of both and and then print them
 * separated by a space, you get "Hello Java".
 */

public class TwoString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        sc.close();
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println(firstLetterToUpperscase(A) + " " + firstLetterToUpperscase(B));
    }

    private static String firstLetterToUpperscase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                sb.append(Character.toString(s.charAt(i)).toUpperCase());
                continue;
            }
            sb.append(Character.toString(s.charAt(i)));
        }
        return sb.toString();
    }
}
