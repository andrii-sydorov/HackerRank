package DataStructures;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.*;
import java.util.ArrayList;

/**
 * For this problem, we have types of queries you can perform on a List:
 * 
 * Insert at index :
 * 
 * Insert
 * x y
 * Delete the element at index :
 * 
 * Delete
 * x
 * Given a list, L, of N integers, perform Q queries on the list. Once all queries
 * are completed, print the modified list as a single line of space-separated
 * integers.
 * 
 * Input Format
 * 
 * The first line contains an integer, N(the initial number of elements in L).
 * The second line contains N space-separated integers describing L.
 * The third line contains an integer, Q (the number of queries).
 * The 2Q subsequent lines describe the queries, and each query is described over
 * two lines:
 * 
 * If the first line of a query contains the String Insert, then the second line
 * contains two space separated integers x y, and the value y must be inserted into
 * at index x.
 * If the first line of a query contains the String Delete, then the second line
 * contains index x, whose element must be deleted from L.
 * 
 * Constraints
 * 1 <= n <= 4000
 * 1 <= Q <= 4000
 * Each element in is a 32-bit integer.
 * 
 * Output Format
 * 
 * Print the updated list L as a single line of space-separated integers.
 * 
 * Sample Input
 * 
 * 5
 * 12 0 1 78 12
 * 2
 * Insert
 * 5 23
 * Delete
 * 0
 * Sample Output
 * 
 * 0 1 78 12 23
 * 
 * Explanation
 * 
 * L = [12, 0, 1, 78, 12]
 * Q0: Insert 23 at index 5.
 * L0 = [12, 0, 1, 78, 12, 23]
 * Q1: Delete the element at index 0.
 * L1 = [0, 1, 78, 12, 23]
 * Having performed all Q queries, we print L1 as a single line of space-separated
 * integers.
 */

public class JavaList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.valueOf(sc.nextLine());
        List<String> ls = new ArrayList<>();
        ls = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        int turns = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < turns; i++) {
            String s = sc.nextLine();
            switch (s) {
                case "Insert":
                    String[] data = sc.nextLine().split("\\s+");
                    ls.add(Integer.valueOf(data[0]), data[1]);
                    break;
                case "Delete":
                    int index = Integer.valueOf(sc.nextLine());
                    ls.remove(index);
                    break;
                default:
                    break;
            }
        }
        ls.forEach(x -> System.out.print(x + " "));
        sc.close();
    }
}
