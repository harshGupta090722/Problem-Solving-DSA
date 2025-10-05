class Solution {
    public static void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    public static void helper(char[] s, int left, int right) {
        if (left > right)
            return;

        helper(s, left + 1, right - 1);
        swap(s, left, right);
    }

    public static void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public static void main(String[] args) {
        char s[] = { 'h', 'a', 'r', 's', 'h', 'i', 't', 'a' };
        reverseString(s);
        for (char i : s) {
            System.out.print(i);
        }
    }
}