import java.util.*;

public class ImplementQueueUsingLL {
    LinkedList<Integer> ll;

    public ImplementQueueUsingLL() {
        ll = new LinkedList<>();
    }

    public void push(int x) {
        ll.addFirst(x);
    }

    public int pop() {
        return ll.removeLast();
    }

    public int peek() {
        return ll.getLast();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }
}