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
        //TODO test later, don't forger!!!
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
        StringBuilder sb = new StringBuilder();
        char[] chData = data.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < chData.length; i++) {
            if (Character.isAlphabetic(chData[i]) || Character.isDigit(chData[i])) {
                temp.append(chData[i]);
            } else if (temp.length() != 0) {
                sb.append(reverseStringBuilder(temp));
                temp.setLength(0);
            } else {
                sb.append(chData[i]);
            }
        }
        return sb.toString();
    }

    private static String reverseStringBuilder(StringBuilder sb) {
        char[] chArr = new char[sb.length()];
        sb.getChars(0, sb.length(), chArr, 0);
        for (int i = 0; i < chArr.length; i++) {
            if (!(Character.isAlphabetic(chArr[i]) && Character.isAlphabetic(chArr[chArr.length - 1 - i]))) {
                continue;
            }
            char ch = chArr[i];
            chArr[i] = chArr[chArr.length - 1 - i];
            chArr[chArr.length - 1 - i] = ch;
        }
        return new String(chArr);
    }

}
