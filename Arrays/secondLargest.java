package Arrays;

public class secondLargest {

    public static int secondLargestElementM1(int[] nums) {
        int n = nums.length;
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < largest && secondLargest < nums[i]) {
                secondLargest = nums[i];
            }
        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static int secondLargestElementM2(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(secondLargestElementM1(nums));
        System.out.println(secondLargestElementM2(nums));
    }
}