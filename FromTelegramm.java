import java.util.Scanner;

/**
 * Товарищи, натолкните на мысль пожалуйста. У меня такой таск:
 * 1.ввести строку с клавы
 * 2.реверсировать её
 * 3.если в строке есть цифры, мы их игнорируем и реверс на них не
 * распространяется
 * Пример: Input: “a1bcd efg!h” -> Output: “d1cba hgf!e”
 */

public class FromTelegramm {

    public static void main(String[] args) {
        String[] test = { "a1bcd efg!h", "0123456789", "Foxminded coll 24/7", "abcd efgh" };
        // System.out.println("Enter your's words: ");
        // Scanner sc = new Scanner(System.in);
        // String st = sc.nextLine();
        // String[] data = st.split("\\s+");
        for (int i = 0; i < test.length; i++) {
            System.out.print("Before the execution of programms:\n" + test[i] + "\n");
            System.out.print("After execution of programms:\n" + reverseString(test[i].split("\\s+")) + "\n");
        }
        // System.out.println(reverseString(data));
        for (int i = 0; i < test.length; i++) {
            System.out.print("Before the execution of programms:\n" + test[i] + "\n");
            System.out.print("After execution of programms:\n" + reverseCompleteString(test[i]) + "\n");
        }

        // sc.close();
    }

    private static String reverseString(String[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            char[] chArr = data[i].toCharArray();
            for (int j = 0; j < chArr.length / 2; j++) {
                if (!Character.isAlphabetic(chArr[j]) || !Character.isAlphabetic(chArr[chArr.length - 1 - j])) {
                    continue;
                }
                char ch = chArr[j];
                chArr[j] = chArr[chArr.length - 1 - j];
                chArr[chArr.length - 1 - j] = ch;
            }
            sb.append(chArr).append(" ");
        }
        return sb.toString().trim();
    }

    private static String reverseCompleteString(String data) {

        return null;
    }

}
