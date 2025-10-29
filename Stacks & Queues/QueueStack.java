import java.util.*;

public class QueueStack {
    Queue<Integer> q;

    public QueueStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int size = q.size();
        q.add(x);
        for (int i = 1; i <= size; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return q.remove();
    }

    public int top() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}