public class ValidPalindrom {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;
            
        s = s.toLowerCase();

        return checkPalindrome(s, 0, s.length() - 1);
    }

    public static boolean checkPalindrome(String s, int left, int right) {
        System.out.println("Value of left is=" + left + " Value of right is =" + right);
        if (left > right)
            return true;
        if (!(s.charAt(left) >= 97 && s.charAt(right) <= 122) || !(s.charAt(left) >= 48 && s.charAt(right) <= 57)) {
            left++;
            right--;
        }

        if (s.charAt(left) != s.charAt(right))
            return false;
        left++;
        right--;
        return checkPalindrome(s, left, right);
    }

    public static void main(String args[]) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}