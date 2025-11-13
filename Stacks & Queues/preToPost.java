import java.util.*;

public class preToPost {
    public static String prefixToPostfix(String s) {
        Stack<String> st = new Stack<>();
        for (int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + "");
            } else {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push(op1 + op2 + ch);
            }
        }
        return st.pop();
    }

    public static void main(String args[]) {
        String s = "*+ab-cd";
        System.out.println(prefixToPostfix(s));
    }
}

//Master Rule- Always scan the string in the direction of its notation and push operands first, combine when you see an operator.