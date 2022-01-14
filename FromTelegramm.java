import java.util.Scanner;

public class FromTelegramm {

    public static void main(String[] args) {
        System.out.println("Enter your's words: ");
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("\\s+");
        System.out.println(reverseString(data));
        sc.close();
    }

    private static String reverseString(String[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            char[] chArr = data[i].toCharArray();
            for (int j = 0; j < chArr.length / 2; j++) {
                if (! Character.isAlphabetic(chArr[j]) || ! Character.isAlphabetic(chArr[chArr.length - 1 - j])) {
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
    
}
