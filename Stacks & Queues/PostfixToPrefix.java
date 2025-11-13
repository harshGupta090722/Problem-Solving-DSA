import java.util.*;

public class PostfixToPrefix {
    public static String postToPre(String postfix) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + "");
            } else {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push(ch + op2 + op1);
            }
        }
        return st.pop();
    }

    public static void main(String args[]) {
        String s = "ab+";
        System.out.println(postToPre(s));
    }
}