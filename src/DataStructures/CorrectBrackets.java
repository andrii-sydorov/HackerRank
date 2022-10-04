package DataStructures;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * In computer science, a stack or LIFO (last in, first out) is an abstract data
 * type that serves as a collection of elements, with two principal operations:
 * push, which adds an element to the collection, and pop, which removes the
 * last element that was added.(Wikipedia)
 * A string containing only parentheses is balanced if the following is true: 1.
 * if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is
 * correct, (A) and {A} and [A] are also correct.
 * 
 * Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
 * 
 * Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
 * 
 * Given a string, determine if it is balanced or not.
 * 
 * Input Format
 * 
 * There will be multiple lines in the input file, each having a single
 * non-empty string. You should read input till end-of-file.
 * 
 * The part of the code that handles input operation is already provided in the
 * editor.
 * 
 * Output Format
 * 
 * For each case, print 'true' if the string is balanced, 'false' otherwise.
 * 
 * Sample Input
 * 
 * {}()
 * ({()})
 * {}(
 * []
 * Sample Output
 * 
 * true
 * true
 * false
 * true
 */

public class CorrectBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");

        List<String> ls = new ArrayList<>();
        String s = sc.nextLine();
        while (s.length() != 0) {
            ls.add(s);
            s = sc.nextLine();
        }
        sc.close();

        for (String st : ls) {
            System.out.println(isValid(st, map));
        }

    }

    private static boolean isValid(String data, Map<String, String> map) {
        Stack<String> st = new Stack<>();
        String[] temp = data.split("");
        for (String s : temp) {
            if (map.containsValue(s)) {
                st.push(s);
            }
            if (map.containsKey(s)) {
                if (st.size() == 0 || !st.pop().equals(map.get(s))) {
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
}
