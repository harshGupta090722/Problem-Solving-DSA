import java.util.*;

class BinarSubarrayWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - goal))
                count += map.get(prefixSum - goal);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 0, 1, 0, 1 };
        System.out.println(numSubarraysWithSum(nums, 2));
    }
}