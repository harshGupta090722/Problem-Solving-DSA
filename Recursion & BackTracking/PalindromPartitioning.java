import java.util.*;

public class PalindromPartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, result, new ArrayList<>());
        return result;
    }

    public static void backtrack(int start, String s, List<List<String>> result, List<String> temp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                temp.add(s.substring(end, end + 1));
                backtrack(end + 1, s, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String args[]) {
        String s = "aab";
        System.out.println(partition(s));
    }
}

/*
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 */