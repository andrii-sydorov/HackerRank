import java.util.Scanner;

/**
 * Two strings, and , are called anagrams if they contain all the same
 * characters in the same frequencies. For this challenge, the test is not
 * case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC,
 * and CtA.
 * 
 * Function Description
 * 
 * Complete the isAnagram function in the editor.
 * 
 * isAnagram has the following parameters:
 * 
 * string a: the first string 
 * string b: the second string Returns
 * 
 * Returns
 * 
 * boolean: If and are case-insensitive anagrams, return true. Otherwise, return
 * false. Input Format
 * 
 * Input format
 * 
 * The first line contains a string . 
 * The second line contains a string .
 * 
 * Constraints
 * 
 * 1 <= length(a), length(b) <= 50
 * Strings a and b consist of English alphabetic characters. 
 * The comparison should NOT be case sensitive. 
 * 
 * Sample Input 0
 * 
 * anagram 
 * margana 
 * 
 * Sample Output 0
 * 
 * Anagrams
 */

public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String a = sc.nextLine();
        System.out.println("Enter the second string: ");
        String b = sc.nextLine();
        System.out.println(isAnagram(a, b) ? "Anagrams" : "Not Anagrams");
        sc.close();
    }

    public static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() != b.length()) {
            return false;
        }
        a = sort(a);
        b = sort(b);
        return a.equals(b);
    }

    public static String sort(String s) {
        char[] ar = s.toCharArray();
        for(int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length - i - 1; j++) {
                if (ar[j] > ar[j +1]) {
                    char temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }
        return new String(ar);
    }
}
