import java.util.*;

public class PermutationWithSpaces {

    public static ArrayList<String> permutation(String s) {
        ArrayList<String> list = new ArrayList<>();
        if (s == null || s.length() == 0)
            return list;

        StringBuilder temp = new StringBuilder();
        temp.append(s.charAt(0));
        backtrack(s, list, temp, 1);
        Collections.sort(list);
        return list;
    }

    public static void backtrack(String s, ArrayList<String> list, StringBuilder temp, int idx) {
        if (idx == s.length()) {
            list.add(temp.toString());
            return;
        }
        temp.append(" ").append(s.charAt(idx));
        backtrack(s, list, temp, idx + 1); // add space and characters
        temp.delete(temp.length() - 2, temp.length());

        temp.append(s.charAt(idx));
        backtrack(s, list, temp, idx + 1);// no space ,just add characters
        temp.deleteCharAt(temp.length() - 1);
    }

    public static void main(String args[]) {
        String s = "ABC";
        System.out.println(permutation(s));
    }
}