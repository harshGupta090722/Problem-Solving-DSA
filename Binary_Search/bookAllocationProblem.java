public class bookAllocationProblem {

    static int allocateBooks(int[] nums, int m) {
        int n = nums.length;
        if (n < m)
            return -1;

        int low = 0, high = 0;
        for (int pages : nums) {
            high += pages;
            low = Math.max(low, pages);
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, m, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static boolean isPossible(int nums[], int m, int mid) {
        int studentCount = 1;
        int currentSum = 0;

        for (int pages : nums) {
            if (pages > mid)
                return false;
            if (currentSum + pages > mid) {
                studentCount++;
                currentSum = pages;

                if (studentCount > m) {
                    return false;
                }
            } else 
                currentSum += pages;

        }
        return true;
    }

    public static void main(String args) {
        int nums[] = { 10, 20, 30, 40, 50, 60 };
        int m = 5;
        System.err.println(isPossible(nums, m, 10));
    }
}