public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length, pivot = n;
        boolean flag = false;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot = i - 1;
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int j = n - 1; j >= pivot + 1; j--) {
                if (nums[j] > nums[pivot]) {
                    swap(nums, pivot, j);
                    break;
                }
            }
            int left = pivot + 1, right = n - 1;
            while (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        } else {
            int left = 0, right = n - 1;
            while (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }

    public void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

// Next Time write more cleaner code.