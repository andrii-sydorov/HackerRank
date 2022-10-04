package DataStructures;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Sometimes it's better to use dynamic size arrays. Java's Arraylist can
 * provide you this feature. Try to solve this problem using Arraylist.
 * 
 * You are given n lines. In each line there are zero or more integers. You need
 * to answer a few queries where you need to tell the number located y^th in
 * position of x^th line.
 * 
 * Take your input from System.in.
 * 
 * Input Format
 * The first line has an integer n. In each of the next lines there will be an
 * integer d denoting number of integers on that line and then there will be d
 * space-separated integers. In the next line there will be an integer q denoting
 * number of queries. Each query will consist of two integers x and y.
 * 
 * Constraints
 * 
 * 1 <= n <= 2000
 * 0 <= d <= 5000
 * 1 <= q <= 1000
 * 1 <= x <= n
 * 
 * Each number will fit in signed integer.
 * Total number of integers in n lines will not cross 10^5.
 * 
 * Output Format
 * In each line, output the number located in y^th position of x^th line. If
 * there is no such position, just print "ERROR!"
 * 
 * Sample Input
 * 
 * 5
 * 5 41 77 74 22 44
 * 1 12
 * 4 37 34 36 52
 * 0
 * 3 20 22 33
 * 5
 * 1 3
 * 3 4
 * 3 1
 * 4 3
 * 5 5
 * 
 * 
 * Sample Output
 * 
 * 74
 * 52
 * 37
 * ERROR!
 * ERROR!
 * Explanation
 * 
 * The diagram below explains the queries:
 */

public class JavaArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        List<List<Integer>> lsData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ls = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::valueOf)
                    .collect(Collectors.toList());
            lsData.add(ls);
        }
        int m = Integer.valueOf(sc.nextLine());
        List<List<Integer>> lsIndex = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> ls = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::valueOf)
                    .collect(Collectors.toList());
            lsIndex.add(ls);
        }
        sc.close();
        printResult(lsData, lsIndex);
    }

    private static void printResult(List<List<Integer>> lsData, List<List<Integer>> lsIndex) {
        for (int i = 0; i < lsIndex.size(); i++) {
            int line = lsIndex.get(i).get(0) - 1;
            int index = lsIndex.get(i).get(1);
            try {
                System.out.println(lsData.get(line).get(index));
            } catch (IndexOutOfBoundsException j) {
                System.out.println("ERROR!");
            }
        }
    }
}
