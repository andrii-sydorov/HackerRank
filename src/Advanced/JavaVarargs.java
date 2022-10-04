package Advanced;

import java.util.Scanner;

/**
 * You are given a class Solution and its main method in the editor.
 * Your task is to create the class Add and the required methods so that the
 * code prints the sum of the numbers passed to the function add.
 * 
 * Note: Your add method in the Add class must print the sum as given in the
 * Sample Output
 * 
 * Input Format
 * 
 * There are six lines of input, each containing an integer.
 * 
 * Output Format
 * 
 * There will be only four lines of output. Each line contains the sum of the
 * integers passed as the parameters to add in the main method.
 * 
 * Sample Input
 * 
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 
 * Sample Output
 * 
 * 1+2=3
 * 1+2+3=6
 * 1+2+3+4+5=15
 * 1+2+3+4+5+6=21
 */

public class JavaVarargs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = 6;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(sc.nextLine());
        }
        sc.close();
        Add.sum(arr);
    }

    public static class Add {

        public static void sum(int... nums) {
            String[] first = { String.valueOf(nums[0]), String.valueOf(nums[1]) };
            int sumFirst = nums[0] + nums[1];
            String[] second = { String.valueOf(nums[0]), String.valueOf(nums[1]), String.valueOf(nums[2]) };
            int sumSecond = sumFirst + nums[2];
            String[] third = { String.valueOf(nums[0]), String.valueOf(nums[1]), String.valueOf(nums[2]),
                    String.valueOf(nums[3]), String.valueOf(nums[4]) };
            int sumThird = sumSecond + nums[3] + nums[4];
            String[] fourth = { String.valueOf(nums[0]), String.valueOf(nums[1]), String.valueOf(nums[2]),
                    String.valueOf(nums[3]), String.valueOf(nums[4]), String.valueOf(nums[5]) };
            int sumFourth = sumThird + nums[5];
            System.out.println(String.join("+", first) + "=" + sumFirst);
            System.out.println(String.join("+", second) + "=" + sumSecond);
            System.out.println(String.join("+", third) + "=" + sumThird);
            System.out.println(String.join("+", fourth) + "=" + sumFourth);
        }
    }
}
