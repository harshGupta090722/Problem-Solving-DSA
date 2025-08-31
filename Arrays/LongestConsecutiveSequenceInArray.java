import java.util.HashMap;

public class LongestConsecutiveSequenceInArray {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i] - 1)) {
                int length = 1;
                int current = nums[i];
                while (map.containsKey(current + 1)) {
                    length++;
                    current++;
                }
                maxLen = Math.max(maxLen, length);
            }
        }
        return maxLen;
    }
}