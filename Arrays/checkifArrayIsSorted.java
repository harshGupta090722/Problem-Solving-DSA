package Arrays;

public class checkifArrayIsSorted {
    public static boolean check(int[] nums) {
        int breakpoint = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i])
                breakpoint = i + 1;
        }
        if (breakpoint == -1)
            return true;
        int i = breakpoint;
        for (int j = 0; j < nums.length; j++) {
            if (i == nums.length-2){
                System.out.println(i);
                i = i % nums.length;
            }

            if (nums[i + 1] < nums[i])
                return false;
            i++;
        }
        return true;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 1, 3, 4 };
        System.out.println(check(nums));
    }
}