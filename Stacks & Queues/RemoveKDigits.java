import java.util.*;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (k > 0 && !st.isEmpty() && ch < st.peek()) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while (k > 0 && !st.isEmpty()) {
            k--;
            st.pop();
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        ans.reverse();

        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        ans.delete(0, i);
        
        return ans.length() == 0 ? "0" : ans.toString();
    }

    public static void main(String args[]) {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }
}