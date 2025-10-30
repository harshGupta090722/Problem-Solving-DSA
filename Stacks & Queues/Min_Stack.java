import java.util.*;

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);

        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        } else {
            minSt.push(minSt.peek());        
        }
    }

    public void pop() {
        if (!st.isEmpty()) {
            minSt.pop();
            st.pop();
        }
    }

    public int top() {
        if (st.isEmpty())
            return -1;

        return st.peek();
    }

    public int getMin() {
        if (minSt.isEmpty())
            return -1;

        return minSt.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Top element: " + ms.top()); // Expected 2
        System.out.println("Minimum: " + ms.getMin()); // Expected 2

        ms.pop();
        System.out.println("Top element after pop: " + ms.top()); // Expected 7
        System.out.println("Minimum after pop: " + ms.getMin()); // Expected 3

        ms.pop();
        System.out.println("Top element after pop: " + ms.top()); // Expected 3
        System.out.println("Minimum after pop: " + ms.getMin()); // Expected 3

        ms.pop();
        System.out.println("Top element after pop: " + ms.top()); // Expected 5
        System.out.println("Minimum after pop: " + ms.getMin()); // Expected 5
    }
}