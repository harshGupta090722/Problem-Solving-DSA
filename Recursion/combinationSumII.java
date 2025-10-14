import java.util.*;

public class combinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, new ArrayList<>(), result, 0, target);
        return result;
    }

    public static void backtrack(int idx, int candidates[], List<Integer> temp, List<List<Integer>> result, int sum,
            int target) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (idx >= candidates.length || sum > target)
            return;

        temp.add(candidates[idx]);
        backtrack(idx + 1, candidates, temp, result, sum+candidates[idx], target); // include the current idx
        temp.remove(temp.size() - 1);

        int next = idx + 1;
        while (next < candidates.length && candidates[next] == candidates[idx])
            next++;

        backtrack(next, candidates, temp, result, sum, target);// exclude the current idx
    }

    public static void main(String args[]) {
        int candidates[] = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println(combinationSum2(candidates, 8));
    }
}