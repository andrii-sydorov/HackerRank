import java.util.*;

public class TryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printResult(sc);
        sc.close();
    }

    private static void printResult(Scanner sc) {
        int x, y;
        try {
            x = Integer.valueOf(sc.nextLine());
            y = Integer.valueOf(sc.nextLine());
            System.out.println(x / y);
        } catch(NumberFormatException i) {
          //  InputMismatchException ime = new InputMismatchException();
           // System.out.println(ime.getClass().getName());
        } catch(ArithmeticException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
