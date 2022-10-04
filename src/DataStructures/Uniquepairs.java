package DataStructures;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 * In computer science, a set is an abstract data type that can store certain
 * values, without any particular order, and no repeated values(Wikipedia). {1,
 * 2, 3}is
 * an example of a set, but {1, 2, 3} is not a set. Today you will learn how to
 * use sets
 * in java by solving this problem.
 * 
 * You are given n pairs of strings. Two pairs (a, b) and (c, d) are identical
 * if a == c and b == d. That
 * also implies (a, b) is not same as (b, a). After taking each pair as input,
 * you need to
 * print number of unique pairs you currently have.
 * 
 * Complete the code in the editor to solve this problem.
 * 
 * Input Format
 * 
 * In the first line, there will be an integer T denoting number of pairs. Each
 * of
 * the next T lines will contain two strings seperated by a single space.
 * 
 * Constraints:
 * 
 * 1 <= T <= 100000
 * Length of each string is atmost and will consist lower case letters only.
 * 
 * Output Format
 * 
 * Print T lines. In the ith line, print number of unique pairs you have after
 * taking ith
 * pair as input.
 * 
 * Sample Input
 * 
 * 5
 * john tom
 * john mary
 * john tom
 * mary anna
 * mary anna
 * Sample Output
 * 
 * 1
 * 2
 * 2
 * 3
 * 3
 * 
 * Explanation
 * 
 * After taking the first input, you have only one pair: (john,tom)
 * After taking the second input, you have two pairs: (john, tom) and (john,
 * mary)
 * After taking the third input, you still have two unique pairs.
 * After taking the fourth input, you have three unique pairs: (john,tom),
 * (john, mary) and (mary, anna)
 * After taking the fifth input, you still have three unique pairs.
 */

public class Uniquepairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int turns = Integer.valueOf(sc.nextLine());
        List<Integer> ls = new ArrayList<>();
        Set<String> st = new HashSet<>();
        for (int i = 0; i < turns; i++) {
            st.add(sc.nextLine());
            ls.add(st.size());
        }
        sc.close();
        for (Integer i : ls) {
            System.out.println(i);
        }
    }
}
