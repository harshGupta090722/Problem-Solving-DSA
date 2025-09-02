//This is Boyre Moore Majority Algorithm
public class majorityElement {
    public int majorityelement(int[] nums) {
        int count = 0, candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                candidate = nums[i];

            if (nums[i] == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}