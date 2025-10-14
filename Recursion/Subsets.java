import java.util.*;

public class Subsets {
    public static boolean checkSubsequenceSum(int[] nums, int k) {
        return backtrack(0, nums, new ArrayList<>(), k, 0);
    }

    public static boolean backtrack(int index, int[] nums, List<Integer> current, int k, int sum) {
        if (index == nums.length) {
            return sum == k;
        }
        current.add(nums[index]);
        sum += nums[index];
        if (backtrack(index + 1, nums, current, k, sum))
            return true;

        sum -= current.get(current.size() - 1);
        current.remove(current.size() - 1);
        if (backtrack(index + 1, nums, current, k, sum))
            return true;
        return false;
    }

    public static void main(String args[]) {
        int[] nums = { 4, 9, 2, 5, 1 };
        System.out.println("The number of subsets with sum=10 are " + checkSubsequenceSum(nums, 10));
    }
}

/*
 * Start: generateSubsets(0, [])
 * |
 * |-- include 4 → generateSubsets(1, [4])
 * | |
 * | |-- include 9 → generateSubsets(2, [4, 9])
 * | | |
 * | | |-- include 2 → generateSubsets(3, [4, 9, 2])
 * | | | → add [4,9,2]
 * | | | ← return
 * | | |
 * | | |-- exclude 2 → generateSubsets(3, [4, 9])
 * | | → add [4,9]
 * | | ← return
 * | | ← backtrack (remove 9)
 * | |
 * | |-- exclude 9 → generateSubsets(2, [4])
 * | |
 * | |-- include 2 → generateSubsets(3, [4, 2])
 * | | → add [4,2]
 * | | ← return
 * | |
 * | |-- exclude 2 → generateSubsets(3, [4])
 * | → add [4]
 * | ← return
 * | ← backtrack (remove 4)
 * | ← return to level 0
 * |
 * |-- exclude 4 → generateSubsets(1, [])
 * |
 * |-- include 9 → generateSubsets(2, [9])
 * | |
 * | |-- include 2 → generateSubsets(3, [9, 2])
 * | | → add [9,2]
 * | | ← return
 * | |
 * | |-- exclude 2 → generateSubsets(3, [9])
 * | → add [9]
 * | ← return
 * | ← backtrack (remove 9)
 * |
 * |-- exclude 9 → generateSubsets(2, [])
 * |
 * |-- include 2 → generateSubsets(3, [2])
 * | → add [2]
 * | ← return
 * |
 * |-- exclude 2 → generateSubsets(3, [])
 * → add []
 * ← return
 * ← backtrack
 * ← all recursion complete
 * 
 */