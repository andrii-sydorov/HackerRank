package Arrays;

import java.util.Scanner;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Let's play a game on an array! You're standing at index 0 of an n-element array
 * named game. From some index i (where 0 <= i < n), you can perform one of the following moves:
 * 
 *  - Move Backward: If cell i - 1 exists and contains a 0, you can walk back to cell i - 1.
 *  - Move Forward:
 *    - If cell i + 1 contains a zero, you can walk to cell i + 1.
 *    - If cell i + leap contains a zero, you can jump to cell i + leap.
 *    - If you're standing in cell n - 1 or the value of i + leap >= n, you can walk or jump off the end
 *      of the array and win the game.
 * In other words, you can move from index i to index i + 1, i - 1, or i + leap as long as the
 * destination index is a cell containing a 0. If the destination index is
 * greater than n - 1, you win the game.
 * 
 * Function Description
 * 
 * Complete the canWin function in the editor below.
 * 
 * canWin has the following parameters:
 * 
 * int leap: the size of the leap
 * int game[n]: the array to traverse
 * 
 * Returns
 * 
 * boolean: true if the game can be won, otherwise false
 * Input Format
 * 
 * The first line contains an integer, , denoting the number of queries (i.e.,
 * function calls).
 * The 2*q subsequent lines describe each query over two lines:
 * 
 * 1) The first line contains two space-separated integers describing the
 * respective values of n and leap.
 * 2) The second line contains space-separated binary integers (i.e., zeroes and
 * ones) describing the respective values of game[0], game[1], ... , game[n - 1].
 * 
 * Constraints
 * 
 * 1 <= q <= 5000
 * 2 <= n <= 100
 * 0 <= leap <= 100
 * 
 * It is guaranteed that the value of game[0] is always 0.
 * Sample Input
 * 
 * STDIN                    Function
 * -----                    --------
 * 4 q = 4                  (number of queries)
 * 5 3                      game[] size n = 5, leap = 3 (first query)
 * 0 0 0 0 0                game = [0, 0, 0, 0, 0]
 * 6 5                      game[] size n = 6, leap = 5 (second query)
 * 0 0 0 1 1 1              . . .
 * 6 3
 * 0 0 1 1 1 0
 * 3 1
 * 0 1 0
 * 
 * Sample Output
 * 
 * YES
 * YES
 * NO
 * NO
 * Explanation
 * 
 * We perform the following queries:
 * 
 * For and , we can walk and/or jump to the end of the array because every cell
 * contains a . Because we can win, we return true.
 * For and , we can walk to index and then jump units to the end of the array.
 * Because we can win, we return true.
 * For and , there is no way for us to get past the three consecutive ones.
 * Because we cannot win, we return false.
 * For and , there is no way for us to get past the one at index . Because we
 * cannot win, we return false.
 */

public class GameArray {

    private static String[] inputData;
    private static String[] correctAnswers;
    private static String pathToTask = "./Arrays/inputData.txt";
    private static String pathToAnswers = "./Arrays/results.txt";
    private static List<Integer> usedNodes = new LinkedList<>();
    private static Deque<Integer> deque = new ArrayDeque();

    public static void main(String[] args) {
        // buildMySolution();

        Scanner sc = new Scanner(System.in);
        mySolution(sc);
    }

    private static void buildMySolution() {
        readData(0, pathToTask);
        readData(1, pathToAnswers);
        int turns = Integer.valueOf(inputData[0]);
        String[] toPrint = new String[turns];
        int count = 0;
        for (int i = 0, k = 1; i < turns; i++) {
            System.out.println(i);
            usedNodes.clear();
            deque.clear();
            int[] data = Arrays.stream(inputData[k++].split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int size = data[0];
            int leap = data[1];
            int[] array = Arrays.stream(inputData[k++].split("\\s+")).mapToInt(Integer::valueOf).toArray();

            if (leap > size) {
                toPrint[i] = "YES";
            } else {
                // toPrint[i] = moveForwardJump(array, leap).equals("YES") ? "YES" :
                // moveForwardIncrement(array, leap);
                toPrint[i] = solution(0, array, leap);
            }
            if (toPrint[i].compareTo(correctAnswers[i]) != 0) {
                count++;
                System.out.println(i);
                System.out.println(toPrint[i]);
                System.out.println(correctAnswers[i]);
                System.out.println(Arrays.toString(data));
                System.out.println(Arrays.toString(array));
                System.exit(0);
                System.out.println();
            }
        }
        System.out.println(count);
    }

    private static String solution(int j, int[] array, int leap) {
        while (j < array.length) {
            if (j == array.length - 1) {
                return "YES";
            }
            int savedValue = j;
            while (--savedValue >= 0 && array[savedValue] == 0) {
                if (!(deque.contains(savedValue) || usedNodes.contains(savedValue))) {
                    deque.add(savedValue);
                }
            }
            if (array[j + 1] == 0 && !usedNodes.contains(j + 1)) {
                deque.add(j);
                j++;
                continue;
            } else if (j + leap >= array.length) {
                return "YES";
            } else if (array[j + leap] == 0) {
                usedNodes.add(j);
                j += leap;
                continue;
            } else {
                usedNodes.add(j);
                while (!deque.isEmpty()) {
                    int t = deque.pollLast();
                    usedNodes.add(t);
                    return solution(t, array, leap);
                }
                return "NO";
            }
        }
        return "NO";
    }

    private static void readData(int key, String path) {
        try {
            switch (key) {
                case 0:
                    inputData = readAllBytes(path).replaceAll("\r", "").split("\n");
                    break;
                case 1:
                    correctAnswers = readAllBytes(path).replaceAll("\r", "").split("\n");
                    break;
                default:
                    break;
            }
        } catch (IOException ioe) {
            System.out.println("The file was not found");
        }
    }

    private static String readAllBytes(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    private static void mySolution(Scanner sc) {
        int turns = Integer.valueOf(sc.nextLine());
        String[] toPrint = new String[turns];
        for (int i = 0; i < turns; i++) {
            usedNodes.clear();
            deque.clear();
            int[] data = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int size = data[0];
            int leap = data[1];
            int[] array = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            if (leap > size) {
                toPrint[i] = "YES";
            }
            toPrint[i] = solution(0, array, leap);
        }
        sc.close();
        for (String s : toPrint) {
            System.out.println(s);
        }
    }
}
