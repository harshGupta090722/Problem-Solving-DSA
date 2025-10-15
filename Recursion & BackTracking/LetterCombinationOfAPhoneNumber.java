import java.util.*;

public class LetterCombinationOfAPhoneNumber {
    static String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;
        backtrack(0, result, new StringBuilder(), letters, digits);
        return result;
    }

    public static void backtrack(int digitsidx, List<String> result, StringBuilder temp, String letters[],
            String digits) {
        if (digitsidx == digits.length()) {
            result.add(temp.toString());
            return;
        }

        String letterForDigit = letters[digits.charAt(digitsidx) - '2'];

        for (int i = 0; i < letterForDigit.length(); i++) {
            temp.append(letterForDigit.charAt(i));
            backtrack(digitsidx + 1, result, temp, letters, digits);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String args[]) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}