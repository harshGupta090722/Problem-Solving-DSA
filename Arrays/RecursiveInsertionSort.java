import java.util.Arrays;

public class RecursiveInsertionSort {

    public static int[] iterativeinsertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    public static void recursiveInsertionSort(int[] nums) {
        helper(nums, nums.length);
    }

    public static void helper(int[] nums, int n) {
        if (n <= 1)
            return;

        helper(nums, n - 1);

        int key = nums[n - 1];
        int j = n - 2;

        while (j >= 0 && nums[j] > key) {
            nums[j + 1] = nums[j];
            j--;
        }
        nums[j + 1] = key;
    }

    public static void main(String args[]) {
        int nums[] = { 7, 4, 1, 5, 3 };
        System.out.println(Arrays.toString(iterativeinsertionSort(nums)));
        recursiveInsertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}