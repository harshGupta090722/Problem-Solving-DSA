public class CountNumberOfNiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0, left = 0, right = 0;

        while (right < nums.length) {

            if (nums[right] % 2 != 0) 
                k--;
            
            if (k < 0)
                count++;
                
            while (k < 0) {
                if (nums[left] % 2 != 0)
                    k++;
                left++;
            }

            right++;
        }
        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 1, 2, 1, 1 };
        System.out.println(numberOfSubarrays(nums, 3));
    }
}