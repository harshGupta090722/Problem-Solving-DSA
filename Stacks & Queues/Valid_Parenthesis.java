import java.util.*;

class Valid_Parenthesis {
    public static boolean isValid(String s) {
        char ch0 = s.charAt(0);
        if (ch0 == ')' || ch0 == '}' || ch0 == ']')
            return false;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else if (!st.isEmpty()) {
                if (ch == ')' && st.peek() == '(' || ch == '}' && st.peek() == '{' || ch == ']' && st.peek() == '[')
                    st.pop();
                else
                    return false;
            } else
                st.push(ch);
        }

        if (st.isEmpty())
            return true;
        return false;
    }

    public static void main(String args[]) {
        System.out.println(isValid("]"));
    }
}