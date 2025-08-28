package Arrays;

public class insertionSort {

    public static void insertionSort(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void printArray(int nums[]) {
        for (int i : nums) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int a[] = { 40, 20, 60, 10, 50, 30, };
        insertionSort(a);
        printArray(a);
    }
}