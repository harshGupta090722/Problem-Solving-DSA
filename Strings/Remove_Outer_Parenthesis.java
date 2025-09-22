public class Remove_Outer_Parenthesis {

    public static String removeOuterParentheses(String s) {
        StringBuffer ans = new StringBuffer();
        int startIdx = 0, endIdx = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count += 1;
            else if (s.charAt(i) == ')') {
                count -= 1;
                endIdx = i;
            }
            if (count == 0) {
                ans.append(s.substring(startIdx + 1, endIdx));
                startIdx = i+1;
            }
        }
        return ans.toString();
    }

    public static void main(String args[]) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }
}