import java.util.*;

public class SubsetsI {

    public static List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        backtrack(nums, result, 0, 0);
        Collections.sort(result);
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> result, int idx, int sum) {
        if (idx == nums.length) {
            result.add(sum);
            return;
        }
        
        backtrack(nums, result, idx + 1, sum);// exclude
        backtrack(nums, result, idx + 1, sum + nums[idx]); // include
    }

    public static void main(String args[]) {
        int[] nums = {2,3};
        System.out.println(subsetSums(nums));
    }
}