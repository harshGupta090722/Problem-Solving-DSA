import java.util.*;

public class Minimize_Max_Distance_to_Gas_Station {

    public static double minMaxDist(int[] stations, int K) {
        int maxDistance = Integer.MIN_VALUE;
        for (int i = 0; i < stations.length - 1; i++) {
            maxDistance = Math.max(maxDistance, stations[i + 1] - stations[i]);
        }
        double l = 0.0, r = maxDistance;
        while (r - l > 1e-4) {
            double mid = l + (r - l) / 2.0;
            if (canAdd(stations, mid, K)) {
                r = mid;
            } else
                l = mid;
        }
        return r;
    }

    public static boolean canAdd(int stations[], double mid, int K) {
        int required = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];
            required += (int) (gap / mid);
        }
        return required <= K;
    }

    public static void main(String args[]) {
        int stations[] = { 1, 2, 3, 4, 5 };
        int k = 2;
        System.out.println("Max Gap left is =" + minMaxDist(stations, k));
    }
}