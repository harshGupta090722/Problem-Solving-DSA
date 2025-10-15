import java.util.*;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, k, n, 1, 0, new ArrayList<>());
        return result;
    }

    static void backtrack(List<List<Integer>> result, int k, int n, int count, int sum, List<Integer> temp) {
        if (sum > n || temp.size() > k)
            return;

        if (temp.size() == k && sum == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (count == 10)
            return;

        temp.add(count);
        backtrack(result, k, n, count + 1, sum + count, temp); // include
        temp.remove(temp.size() - 1);

        backtrack(result, k, n, count + 1, sum, temp); // exclude
    }

    public static void main(String args[]) {
        System.out.println(combinationSum3(9, 45));
    }
}