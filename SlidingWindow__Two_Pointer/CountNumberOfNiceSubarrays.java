import java.util.*;
//This problem can be easily converted to binary sum equals to K
public class CountNumberOfNiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        map.put(0, 1);

        for (int i : nums) {
            prefixSum += (i%2);

        if(map.containsKey(prefixSum-k))
        count+=map.get(prefixSum-k);

        map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 1, 2, 1, 1 };
        System.out.println(numberOfSubarrays(nums, 3));
    }
}