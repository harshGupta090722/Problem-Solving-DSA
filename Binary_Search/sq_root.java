
public class sq_root {
    public static long floorSqrt(long n) {
        long left = 1, right = n, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mid == n / mid)
                return mid;

            if (mid > n / mid)
                right = mid - 1; // sq root is on the left side of the search!
            else
                left = mid + 1;// sq root is on the right side of the search!
        }
        return mid;
    }

    public static void main(String args[]) {
        long n = 28;
        System.out.println(floorSqrt(n));

    }
}