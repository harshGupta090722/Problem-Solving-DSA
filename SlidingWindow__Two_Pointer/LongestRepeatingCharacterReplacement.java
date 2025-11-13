public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLen = 0;

        while (right< s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                k--;
            }
            while (k < 0) {
                if (s.charAt(left) != s.charAt(right)) {
                    k++;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String args[]) {
        System.out.println(characterReplacement("AABA", 0));
    }
}