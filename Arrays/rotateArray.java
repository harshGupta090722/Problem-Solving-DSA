

public class rotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        //reverse array
        int left = 0, right = n-1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        //rotate first k elements
        left = 0;
        right = k - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        //rotate remaining k elements
        left = k; 
        right =n-1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }   
}