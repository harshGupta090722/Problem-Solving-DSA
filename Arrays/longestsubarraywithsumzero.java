import java.util.*;

public class longestsubarraywithsumzero {
    public static int maxLen(int[] arr) {
        int len = 0, maxLen = 0, n = arr.length, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            }
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return maxLen;
    }

    public static void main(String args[]) {
        int arr[] = { 2,10,4 };
        System.out.println("The max lengh of the subarray is " + maxLen(arr));
    }
}
