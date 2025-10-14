import java.util.*;
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String str = new String();
        return helper(ans, str, n, n);
    }

    public static List<String> helper(List<String> ans, String str, int open, int close) {
        if (close == 0) {
            ans.add(str);
            str = "";
            return ans;
        }
        
        if (open > 0)
            helper(ans, str + "(", open - 1, close);

        if (close > open)
            helper(ans, str + ")", open, close - 1);
        return ans;
    }

    public static void main(String args[]) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}