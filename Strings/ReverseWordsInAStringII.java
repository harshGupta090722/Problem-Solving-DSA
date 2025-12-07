public class ReverseWordsInAStringII {
    
    public static String reverseWordsII(String s) {
        StringBuffer ans = new StringBuffer();
        StringBuffer temp = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' '){
                temp.append(ch);
            }else {
                ans.append(temp.reverse());
                ans.append(" ");
                temp = new StringBuffer();
            }
        }
        
        ans.append(temp.reverse());
        return ans.toString();
    }
    
    public static void main(String args[]) {
        String a = "Let's take a LeetCode Contest";
        System.out.println(reverseWordsII(a));
    }
}