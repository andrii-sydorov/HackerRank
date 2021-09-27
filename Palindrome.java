import java.util.Scanner;

/**
 * A palindrome is a word, phrase, number, or other sequence of characters which
 * reads the same backward or forward.
 * 
 * Given a string , print Yes if it is a palindrome, print No otherwise.
 * 
 * Constraints
 * 
 * A will consist at most 50 lower case english letters. 
 * 
 * Sample Input
 * 
 * madam 
 * 
 * Sample Output
 * 
 * Yes
 */

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your world: ");
        String A = sc.nextLine();
        System.out.println(isPalindrome(A) ? true : false);
        sc.close();
    }

    public static boolean isPalindrome(String A) {
        if (A.length() == 1) {
            return true;
        }

        for (int i = 0; i < A.length() / 2; i++) {
            if (A.charAt(i) != A.charAt(A.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
