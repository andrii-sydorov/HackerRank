package Arrays;

import java.util.Deque;
import java.util.ArrayDeque;

public class Test {
    public static void main(String[] args) {
        Deque<Integer>deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        while(!deque.isEmpty()) {
            System.out.println(deque.pollLast());
        }
    }
}
