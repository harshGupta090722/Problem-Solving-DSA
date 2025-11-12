public class MaximumConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int p1 = 0, p2 = 0, maxLen = 0;

        while (p2 < nums.length) {
            if (nums[p2] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[p1] == 0) {
                    k++;
                }
                p1++;
            }
            maxLen = Math.max(maxLen, p2 - p1 + 1);
            p2++;
        }
        return maxLen;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        System.out.println(longestOnes(nums, 2));
    }
}