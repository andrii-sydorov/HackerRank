package DataStructures;

import java.io.*;
import java.util.*;

/**
 * You are given a 2D array. An hourglass in an array is a portion shaped like
 * this:
 * 
 * a b c
 *   d
 * e f g
 * For example, if we create an hourglass using the number 1 within an array
 * full of zeros, it may look like this:
 * 
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * Actually, there are many hourglasses in the array above. The three leftmost
 * hourglasses are the following:
 * 
 * 1 1 1  1 1 0  1 0 0
 *   1      0      0
 * 1 1 1  1 1 0  1 0 0
 * The sum of an hourglass is the sum of all the numbers within it. The sum for
 * the hourglasses above are 7, 4, and 2, respectively.
 * 
 * In this problem you have to print the largest sum among all the hourglasses
 * in the array.
 * 
 * Input Format
 * 
 * There will be exactly lines, each containing integers seperated by spaces.
 * Each integer will be between and inclusive.
 * 
 * Output Format
 * 
 * Print the answer to this problem on a single line.
 * 
 * Sample Input
 * 
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 * 
 * 19
 * Explanation
 * 
 * The hourglass which has the largest sum is:
 * 
 * 2 4 4
 *   2
 * 1 2 4
 */

public class GlassArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[][] data = new int[6][];
        for (int i = 0; i < data.length; i++) {
            data[i] = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        bufferedReader.close();
        System.out.println(calculateSum(data));
    }

    private static int calculateSum(int[][] data) {
        // TODO
        int n = 3;
        int[][] subMatrix = new int[3][3];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= data.length - n; i++) {
            for (int j = 0; j <= data[i].length - n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        subMatrix[k][l] = data[i + k][j + l];
                    }
                }
                if (max < getSum(subMatrix)) {
                    max = getSum(subMatrix);
                }
            }
        }
        return max;
    }

    private static int getSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((i == 1 && j == 0) || (i == 1 && j == 2)) {
                    continue;
                }
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
