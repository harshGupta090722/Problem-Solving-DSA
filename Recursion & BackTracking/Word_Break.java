import java.util.*;

public class Word_Break {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return backtrack(s, dict, new StringBuilder(), 0, memo);
    }

    public static boolean backtrack(String s, Set<String> wordDict, StringBuilder temp, int index, Boolean[] memo) {
        if (index == s.length())
            return temp.length() == 0;

        if (memo[index] != null)
            return memo[index];

        temp.append(s.charAt(index));

        if (wordDict.contains(temp.toString())) {
            StringBuilder newTemp = new StringBuilder();
            if (backtrack(s, wordDict, newTemp, index + 1, memo))
                return memo[index] = true;
        }

        if (backtrack(s, wordDict, temp, index + 1, memo))
            return memo[index] = true;

        temp.setLength(temp.length() - 1);
        return memo[index] = false;
    }

    public static void main(String args[]) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        String a = "leet";
        String b = "code";
        wordDict.add(a);
        wordDict.add(b);
        System.out.println(wordBreak(s, wordDict));
    }
}