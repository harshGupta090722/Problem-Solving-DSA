import java.util.*;

public class longestSubarrayWithSumK {

    public static int longestSubarrayUsingTwoPointer(int[] nums, int k) {
        // This solution will handle only +ve integers
        int left = 0, sum = 0, maxLen = 0, n = nums.length;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            if (sum == k)
                maxLen = Math.max(maxLen, right - left + 1);

            while (sum > k) {
                sum -= nums[left];
                left++;
            }
        }
        return maxLen;
    }

    public static int longestSubarrayBruteForce(int[] nums, int k) {
        // This solution will handle both +ve and -ve integers
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    public static int longestSubarrayOptimized(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }

            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }
        }
        return maxLen;
    }

    public static void main(String args[]) {
        int nums1[] = { 10, 5, 2, 7, 1, 9 };
        System.out.println(longestSubarrayUsingTwoPointer(nums1, 10));// ans->3

        int nums2[] = { 2, 3, -1, 6, -2, 4 };
        System.out.println(longestSubarrayBruteForce(nums2, 10));// ans->5
        System.out.println(longestSubarrayOptimized(nums2, 10)); // ans->5
    }
}

// Important Code-Learn this sliding window pattern