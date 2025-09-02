//This is Boyre Moore Majority Algorithm,Element in majority-Very Important learn it as a pattern

import java.util.ArrayList;
import java.util.List;

public class majorityElement {
    public int majorityelementI(int[] nums) { // This is basic of boyre moore majority algo ,that helps finding majoriy
                                              // element in the array ,as there will be only element that would occur
                                              // more n/2 times that's why we don't traverse twice
        int count = 0, candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                candidate = nums[i];

            if (nums[i] == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }

    public List<Integer> majorityElementII(int[] nums) { // This is an extension of boyre moore algo ,in any array there
                                                         // can be atmost 2 elements with freq n/3 ,to confirm there
                                                         // freq ,we need to traverse twice.
        int count1 = 0, count2 = 0, n = nums.length;
        List<Integer> list = new ArrayList<>();
        int candidate1 = 0, candidate2 = 0;
        for (int i = 0; i < n; i++) {

            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            }
        }
        if (count1 > n / 3)
            list.add(candidate1);

        if (count2 > n / 3)
            list.add(candidate2);

        return list;
    }
}