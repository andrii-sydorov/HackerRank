import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Given a double-precision number, , denoting an amount of money, use the
 * NumberFormat class' getCurrencyInstance method to convert into the US,
 * Indian, Chinese, and French currency formats. Then print the formatted values
 * as follows:
 * 
 * US: formattedPayment India: formattedPayment China: formattedPayment France:
 * formattedPayment where is formatted according to the appropriate Locale's
 * currency.
 * 
 * Note: India does not have a built-in Locale, so you must construct one where
 * the language is en (i.e., English).
 * 
 * Input Format
 * 
 * A single double-precision number denoting payment.
 * 
 * Constraints
 * 
 * 0 <= payment <= 10^6
 * 
 * Output Format
 * 
 * On the first line, print US: u where is payment formatted for US currency. 
 * On the second line, print India: i where is payment formatted for Indian currency. 
 * On the third line, print China: c where is payment formatted for Chinese currency. 
 * On the fourth line, print France: f, where is payment formatted for French currency.
 * 
 * Sample Input
 * 
 * 12324.134 
 * Sample Output
 * 
 * US: $12,324.13 
 * India: Rs.12,324.13 
 * China: ￥12,324.13 
 * France: 12 324,13 €
 * Explanation
 * 
 * Each line contains the value of formatted according to the four countries'
 * respective currencies.
 */

public class Currency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        double payment = sc.nextDouble();
        sc.close();
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("hi","IN"));
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("US: " + us.format(payment));
        System.out.println("India: " + india.format(payment));
        System.out.println("China: " + china.format(payment));
        System.out.println("France: " + france.format(payment));
    }
}
