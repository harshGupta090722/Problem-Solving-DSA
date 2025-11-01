import java.util.*;

public class PrefixToInfix {

    public static String prefixToInfix(String postfix) {
        Stack<String> st = new Stack<>();
        for (int i = postfix.length() - 1; i >= 0; i--) {
            char ch = postfix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + "");
            } else {
                String op1 = st.pop();
                String op2 = st.pop();
                String exp = "(" + op1 + ch + op2 + ")";
                st.push(exp);
            }
        }
        return st.peek();
    }

    public static void main(String args[]) {
        String postfix = "*+ab-cd";
        System.out.println(prefixToInfix(postfix));
    }
}