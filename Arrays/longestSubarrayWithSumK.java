public class longestSubarrayWithSumK {

    public static int longestSubarray(int[] nums, int k) {
        int left = 0, sum = 0, maxLen = 0, n = nums.length;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            if (sum == 15)
                maxLen = Math.max(maxLen, right - left + 1);

            while (sum > 15) {
                sum -= nums[left];
                left++;
            }
        }
        return maxLen;
    }

    public static void main(String args[]) {
        int nums[]={10, 5, 2, 7, 1, 9};
        System.out.println(longestSubarray(nums, 0));
    }
}

//Important Code-understand this sliding window pattern