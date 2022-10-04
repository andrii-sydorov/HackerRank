import java.util.Calendar;
import java.util.Scanner;

/**
 * The Calendar class is an abstract class that provides methods for converting
 * between a specific instant in time and a set of calendar fields such as YEAR,
 * MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar
 * fields, such as getting the date of the next week.
 * 
 * You are given a date. You just need to write the method, , which returns the
 * day on that date. To simplify your task, we have provided a portion of the
 * code in the editor.
 * 
 * Function Description
 * 
 * Complete the findDay function in the editor below.
 * 
 * findDay has the following parameters:
 * 
 * int: month 
 * int: day 
 * int: year Returns
 * 
 * string: the day of the week in capital letters Input Format
 * 
 * A single line of input containing the space separated month, day and year,
 * respectively, in format.
 * 
 * Constraints
 * 
 * 2000 < year < 3000
 * 
 * Sample Input
 * 
 * 08 
 * 05 
 * 2015 
 * Sample Output
 * 
 * WEDNESDAY 
 * 
 * Explanation
 * 
 * The day on August th was WEDNESDAY.
 */

public class DateAndTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = Integer.valueOf(sc.nextLine());
        int day = Integer.valueOf(sc.nextLine());
        int year = Integer.valueOf(sc.nextLine());
        System.out.println(findDay(month, day, year));
        sc.close();
    }

    private static String findDay(int month, int day, int year) {
        Calendar cl = Calendar.getInstance();
        cl.set(year, month - 1, day);
        int i = cl.get(Calendar.DAY_OF_WEEK);
        String ans = null;
        switch(i) {
            case 1:
            ans = "SUNDAY";
            break;
            case 2:
            ans = "MONDAY";
            break;
            case 3:
            ans = "TUESDAY";
            break;
            case 4:
            ans = "WEDNESDAY";
            break;
            case 5:
            ans = "THURSDAY";
            break;
            case 6:
            ans = "FRIDAY";
            break;
            case 7:
            ans = "SATURDAY";
            break;
            default:
            break;
        }
        return ans;
    }
}