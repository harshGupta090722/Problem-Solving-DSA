import java.util.*;

class SubsetsII {
    List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // skip duplicates in the exclude branch
        int next = idx + 1;
        while (next < nums.length && nums[next] == nums[idx])
            next++;

        backtrack(nums, result, temp, next); // exclude

        // include
        temp.add(nums[idx]);
        backtrack(nums, result, temp, idx + 1);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        SubsetsII sol = new SubsetsII();
        int[] nums = { 1, 2, 2 };
        System.out.println(sol.subsetsWithDup(nums));
    }
}