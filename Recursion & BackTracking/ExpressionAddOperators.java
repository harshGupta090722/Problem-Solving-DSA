import java.util.*;
public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(num, target, result, new StringBuilder(), 0, 0);
        return result;
    }

    public static void backtrack(String num, int target, List<String> result, StringBuilder temp, int ans, int idx) { 
        if (ans == target && idx == num.length()) {
            result.add(temp.toString());
            return;
        }

        if (ans > target)
            return;

        // try multiplication
        char ch = num.charAt(idx);
        ans = ans + (ch - '0') * 1;
        backtrack(num, target, result, temp, ans, idx + 1);

        // try addition
        ch = num.charAt(idx);
        ans = ans + ch - '0';
        backtrack(num, target, result, temp, ans, idx + 1);

        // try substraction
        ch = num.charAt(idx);
        ans = ans - ch - '0';
        backtrack(num, target, result, temp, ans, idx + 1);
    }

    public static void main(String args[]) {
        String num = "123";
        int target = 6;
        System.out.println(addOperators(num, target));
    }
}