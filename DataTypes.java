import java.util.Scanner;

public class DataTypes {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        final String[] st = { "* byte", "* short", "* int", "* long" };
        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                int index = 0;
                System.out.println(x + " can be fitted in:");
                if (x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) {
                    index = 0;
                } else if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
                    index = 1;
                } else if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
                    index = 2;
                } else {
                    index = 3;
                }
                print(index, st);
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
        sc.close();
    }

    private static void print(int index, String[] st) {
        for (int i = index ; i < st.length; i++) {
            System.out.println(st[i]);
        }
    }
}
