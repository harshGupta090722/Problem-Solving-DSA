public class Rotate_String {
    public static boolean rotateString(String s, String goal) {
        int l1 = s.length(), l2 = goal.length();

        if (l1 != l2)
            return false;

        StringBuffer s1 = new StringBuffer(s);
        StringBuffer goal1 = new StringBuffer(goal);
        for (int i = 0; i < l1; i++) {
            char ch = s1.charAt(0);
            s1.deleteCharAt(0);
            s1.append(ch);
            if (s1.toString().equals(goal1.toString()))
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
}