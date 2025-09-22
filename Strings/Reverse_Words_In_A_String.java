public class Reverse_Words_In_A_String {
    public static String reverseWords(String s) {
        s = s.trim();
        StringBuffer revStr = new StringBuffer();
        StringBuffer ans = new StringBuffer();

        for (int i = s.length() - 1; i >= 0; i--) {
            revStr.append(s.charAt(i));
        }

        int startIdx = 0;
        for (int i = 0; i < revStr.length(); i++) {
            if (revStr.charAt(i) == ' ' || i == revStr.length() - 1) {
                ans.append(revString(revStr.substring(startIdx, i + 1).trim()));
                startIdx = i;
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    public static String revString(String s) {

        StringBuffer str = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }

    public static void main(String args[]) {
        String a = "the sky is blue ";
        System.out.println(reverseWords(a));
    }
}