
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * We define the following terms:
 * 
 * Lexicographical Order, also known as alphabetic or dictionary order, orders
 * characters as follows: 
 *  A < B <...< Y < Z < a < b < ... < y < z
 * For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.
 * 
 * A substring of a string is a contiguous block of characters in the string.
 * For example, the substrings of abc are a, b, c, ab, bc, and abc. Given a
 * string, s , and an integer, k , complete the function so that it finds the
 * lexicographically smallest and largest substrings of length .
 * 
 * Function Description
 * 
 * Complete the getSmallestAndLargest function in the editor below.
 * 
 * getSmallestAndLargest has the following parameters:
 * 
 * string s: a string 
 * int k: the length of the substrings to find Returns
 * 
 * string: the string ' + "\n" + ' where and are the two substrings 
 * Input Format
 * 
 * The first line contains a string denoting s. The second line contains an
 * integer denoting k.
 * 
 * Constraints
 * 
 * 1 <= s <= 100
 * 
 * consists of English alphabetic letters only (i.e., [a-zA-Z]). 
 * 
 * Sample Input 0
 * 
 * welcometojava 
 * 3 
 * 
 * Sample Output 0
 * 
 * ava 
 * wel 
 * 
 * Explanation 0
 * 
 * String has the following lexicographically-ordered substrings of length :
 * 
 * We then return the first (lexicographically smallest) substring and the last
 * (lexicographically largest) substring as two newline-separated values (i.e.,
 * ava\nwel).
 * 
 * The stub code in the editor then prints ava as our first line of output and
 * wel as our second line of output.
 */

public class LargestAndSmallestSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you String:");
        String s = sc.nextLine();
        System.out.println("Enter the length of substrings:");
        int k = sc.nextInt();
        LargestAndSmallestSubstring cl = new LargestAndSmallestSubstring();
        System.out.println(cl.getClass().getMethods()[1].getName() + "\n" + cl.getSmallestAndLargestList(s, k));
        System.out.println(cl.getClass().getMethods()[2].getName() + "\n" + cl.getSmallestAndLargestArrays(s, k));
        sc.close();
    }

    public String getSmallestAndLargestList(String s, int k) {
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            ls.add(s.substring(i, k + i));
        }
        Collections.sort(ls);
        return ls.get(0) + "\n" + ls.get(ls.size() - 1);
    }
    
    public String getSmallestAndLargestArrays(String s, int k) {
        String[] str = null;
        str = makeArray(s, k);
        String smallest = str[0];
        String largest = str[0];
        for (int i = 1; i < str.length; i++) {
            if (smallest.compareTo(str[i]) > 0) {
                smallest = str[i];
            } 
            if (largest.compareTo(str[i]) < 0) {
                largest = str[i];
            }
        }
        return smallest + "\n" + largest;
    }

    private String[] makeArray(String s, int k) {
        String[] str = new String[s.length() - k + 1];
        for (int i = 0; i < s.length() - k + 1; i++) {
            str[i] = s.substring(i, i + k);
        }
        return str;
    }
}
