import java.util.Scanner;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/java-loops/problem?h_r=next-challenge&h_v=zen
 */

public class LoopsSecond {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.valueOf(sc.nextLine());
        int[][] lines = buils2DArray(q, sc);
        System.out.println(Arrays.deepToString(lines));
        print(calculation(lines));
    }

    private static int[][] buils2DArray(int q, Scanner sc) {
        int[][] ans = new int[q][];
        for (int i = 0; i < q; i++) {
            ans[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer :: valueOf).toArray();
        }
        return ans;
    }

    private static int[][] calculation(int[][] lines) {
        int[][] ans = new int[lines.length][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = makeArray(lines[i]);
        }
        return ans;
    }

    private static int[] makeArray(int[] lines) {
        int[] ans = new int[lines[lines.length - 1]];
        ans[0] = lines[0] + (int) Math.pow(2, 0) * lines[1];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + (int) Math.pow(2, i) * lines[1];
        }
        return ans;
    }

    private static void print(int[][] lines) {
        for (int i = 0; i < lines.length; i++) {
            for (int a : lines[i]) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
    
}
