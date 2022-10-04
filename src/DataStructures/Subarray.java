package DataStructures;
import java.util.*;

/**
 * We define the following:
 * 
 * A subarray of an n-element array is an array composed from a contiguous block
 * of the original array's elements. For example, if array = [1, 2, 3], then the subarrays are [1],
 * [2], [3], [1, 2], [2, 3], and [1, 2, 3]. Something like [1, 3]would not be a subarray as it's not a contiguous
 * subsection of the original array.
 * The sum of an array is the total sum of its elements.
 *      An array's sum is negative if the total sum of its elements is negative.
 *      An array's sum is positive if the total sum of its elements is positive.
 * Given an array of n integers, find and print its number of negative subarrays
 * on a new line.
 * 
 * Input Format
 * 
 * The first line contains a single integer, n, denoting the length of array A = [a0, a1, ..., a(n-1)].
 * The second line contains n space-separated integers describing each respective
 * element, a(i), in array A.
 * 
 * Constraints
 * 
 * 1 <= n <= 100
 * -10^4 <= a(i) <= 10^4
 * 
 * Output Format
 * 
 * Print the number of subarrays of having negative sums.
 * 
 * Sample Input
 * 
 * 5
 * 1 -2 4 -5 1
 * 
 * Sample Output
 * 
 * 9
 * 
 * Explanation
 * 
 * There are nine negative subarrays of A = [1, -2, 4, -5, 1]:
 * 1. [1:1] => -2
 * 2. [3:3] => -5
 * 3. [0:1] => 1 + -2 = -1
 * 4. [2:3] => 4 + -5 = -1
 * 5. [3:4] => -5 + 1 = -4
 * 6. [1:3] => -2 + 4 + -5 = -3
 * 7. [0:3] => 1 + -2 + 4 + -5 = -2
 * 8. [1:4] => -2 + 4 + -5 + 1 = -2
 * 9. [0:4] => 1 + -2 + 4 + -5 + 1 = -1
 * 
 * Thus, we print on a new line.
 */

public class Subarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        System.out.println(calculateNegativeSubarray(arr));
        sc.close();
    }

    private static int calculateNegativeSubarray(int[] arr) {
        int count = 0;
        int number = arr.length;
        List<int[]> ls = new ArrayList<>();

        for (int i = 1; i < arr.length; i++, number--) {
            /*
             * i = length of array
             * number - number of array with length i
             */
            for (int k = 0, start = 0; k < number; k++, start++) {
                int[] temp = new int[i];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = arr[start + j];
                }
                ls.add(temp);
                if (calculateSumm(temp) < 0) {
                    count++;
                }
            }
        }
        if (calculateSumm(arr) < 0) {
            count++;
        }
        return count;
    }

    private static int calculateSumm(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}