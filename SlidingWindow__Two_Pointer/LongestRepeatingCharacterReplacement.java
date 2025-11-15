public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLen = 0, maxFreq=0;
        int freq[] = new int[26];

        while (right < s.length()) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String args[]) {
        System.out.println(characterReplacement("ABCDEFF", 2));
    }
}