import java.util.*;
public class AllPermutations {

    public static List<List<Integer>> permutate(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        BackTrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    public static void BackTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            tempList.add(nums[i]);
            used[i] = true;
            BackTrack(result, tempList, nums, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3 };
        System.out.println(permutate(nums));
    }
}