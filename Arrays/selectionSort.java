package Arrays;

public class selectionSort {

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min])
                    min = j;
            }
            swap(nums, i, min);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArray(int nums[]) {
        for (int i : nums) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int nums[] = { 6, 8, 1, 3, 7, 92, 13 };
        selectionSort(nums);
        printArray(nums);
    }
}

/*
 * Learnings:-
 * 1)Mistakes
 * 
 * 1)min should store the index, not the value.
 * You need to track the position of the smallest element, not just the number
 * itself.
 * 
 * 2)Your swap call is wrong.
 * 
 * Java is pass-by-value, even for primitives.
 * Here you’re swapping copies of the numbers, not the actual array elements.
 * So nothing in the array ever changes.
 */