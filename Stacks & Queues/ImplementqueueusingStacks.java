import java.util.*;

public class ImplementqueueusingStacks {
    Stack<Integer> st;

    public ImplementqueueusingStacks() {
        st = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> revStack = new Stack<>();
        while (!st.isEmpty()) {
            revStack.push(st.pop());
        }
        revStack.push(x);
        while (revStack.isEmpty()) {
            st.push(revStack.pop());
        }
    }

    public int pop() {
        if (!st.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return st.pop();
    }

    public int peek() {
        return st.peek();
    }

    public boolean empty() {
        return st.isEmpty();
    }
}