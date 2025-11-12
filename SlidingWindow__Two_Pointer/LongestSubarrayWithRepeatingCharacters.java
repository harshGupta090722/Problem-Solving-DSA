import java.util.*;

public class LongestSubarrayWithRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        else if (s.length() == 1)
            return 1;
        int p1 = 0, p2 = 0, len = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (p2 < s.length()) {

            char ch = s.charAt(p2);
            if (map.containsKey(ch)) {
                p1 = Math.max(p1, map.get(ch) + 1);
            }

            map.put(ch, p2);
            len = p2 - p1 + 1;
            maxLen = Math.max(maxLen, len);

            p2++;
        }
        return maxLen;
    }

    public static void main(String args[]) {
        String s = "ab";
        System.out.println(lengthOfLongestSubstring(s));
    }
}