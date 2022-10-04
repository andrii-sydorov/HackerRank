import java.util.Scanner;
import java.util.Arrays;

/**
 * Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split
 * the string into tokens. We define a token to be one or more consecutive
 * English alphabetic letters. Then, print the number of tokens, followed by
 * each token on a new line.
 * 
 * Note: You may find the String.split method helpful in completing this
 * challenge.
 * 
 * Input Format
 * 
 * A single string, s.
 * 
 * Constraints
 * 
 * 1 <= length of s <= 4 * 10 ^ 5
 * s is composed of any of the following: English alphabetic letters, blank
 * spaces, exclamation points (!), commas (,), question marks (?), periods (.),
 * underscores (_), apostrophes ('), and at symbols (@). 
 * 
 * Output Format
 * 
 * On the first line, print an integer, n, denoting the number of tokens in s
 * string (they do not need to be unique). Next, print each of the  n tokens on a
 * new line in the same order as they appear in input string s.
 * 
 * Sample Input
 * 
 * He is a very very good boy, isn't he? 
 * 
 * Sample Output
 * 
 * 10 
 * He 
 * is 
 * a 
 * very 
 * very 
 * good 
 * boy 
 * isn 
 * t 
 * he 
 * 
 * Explanation
 * 
 * We consider a token to be a contiguous segment of alphabetic characters.
 * There are a total of such tokens in string s, and each token is printed in the
 * same order in which it appears in string s.
 */

public class StringTokens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your text: ");
        String s = sc.nextLine().trim();
        String[] ar = makeArray(s);
        printArray(ar);
        sc.close();
    }

    private static String[] makeArray(String s) {
        //String[] ar = s.split("[ !,?._'@]+");
        String[] ar = s.split("[^A-Za-z]+");
        if (s.isEmpty()) {
            ar = new String[] {};
        }
        System.out.println(Arrays.toString(ar));
        return ar;
    }

    private static void printArray(String[] ar) {
        System.out.println(ar.length);
        for (String s : ar) {
            System.out.println(s);
        }
    }
}
