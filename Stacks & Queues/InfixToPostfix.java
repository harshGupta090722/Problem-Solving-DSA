import java.util.*;

public class InfixToPostfix {
    public static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
            } else {
                while (!st.isEmpty() && hasHigherPrecedence(st.peek(), ch)) {
                    result.append(st.pop()); // zada preference wale operator ko peek per maintain krne ki koshish krte
                                             // hai,so we pop it if it's the most preference operator
                }
                st.push(ch); // if not most preference ,just simply push it to the stack
            }
        }

        while (!st.isEmpty()) {
            result.append(st.pop()); // pop remaining elements from the stack
        }

        return result.toString();
    }

    public static boolean hasHigherPrecedence(char top, char current) {
        if (top == ')' || top == '(')
            return false;
        int ptop = precerence(top);
        int pcurrent = precerence(current);
        if (ptop == pcurrent && ptop == '^')
            return false;
        return ptop >= pcurrent;
    }

    public static int precerence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static void main(String args[]) {
        String s = "a+b*(c^d-e)";
        System.err.println(infixToPostfix(s));
    }
}