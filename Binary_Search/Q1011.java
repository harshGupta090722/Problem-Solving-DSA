//Capacity to Ship Packages Within D days
public class Q1011 {
    public static int shipWithinDays(int[] weights, int days) {
        long l = getHeaviest(weights), r = getTotalWeight(weights), ans = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (canShip(weights, mid, days)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return (int) ans;
    }

    public static boolean canShip(int weights[], long mid, long days) {
        int sum = 0, daysreq = 1;
        for (int w:weights) {
            if (sum + w > mid) {
                daysreq++;
                sum = 0;
            }
            sum += w;
        }
        return daysreq <= days;
    }

    public static long getTotalWeight(int weights[]) {
        long sum = 0;
        for (int i : weights) {
            sum += i;
        }
        return sum;
    }

    public static long getHeaviest(int weights[]) {
        long max = 0;
        for (int i : weights) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String args[]) {
        int weights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(shipWithinDays(weights, 5));
    }
}