import java.util.*;

public class GenerateStringWithoutConsecutive1s {
    public static List<String> generateBinaryStrings(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        helper(n, list, temp);
        return list;
    }

    public static void helper(int n, List<String> list, StringBuilder temp) {
        if (temp.length() == n) {
            list.add(temp.toString());
            return;
        }

        if (temp.length() == 0 || temp.charAt(temp.length() - 1) != '1') {
            temp.append('1');
            helper(n, list, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
        temp.append('0');
        helper(n, list, temp);
        temp.deleteCharAt(temp.length() - 1);
    }

    public static void main(String args[]) {
        int n = 3;
        System.out.println(generateBinaryStrings(n));
    }
}