import java.util.*;

public class ImplementStackUsingLL {

    LinkedList<Integer> ll;

    public ImplementStackUsingLL() {
        ll = new LinkedList<>();
    }

    public void push(int x) {
        ll.add(x);
    }

    public int pop() {
        if (ll.isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return ll.removeLast();
    }

    public int top() {
        if (ll.isEmpty()) {
            System.out.println("stack is Empty");
            return -1;
        }
        return ll.getLast();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }
}