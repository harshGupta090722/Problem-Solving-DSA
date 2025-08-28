package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionOfTwoArrays {
    public static int[] unionArray(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int left1 = 0, left2 = 0;

        while (left1 < nums1.length && left2 < nums2.length) {
            if (nums1[left1] < nums2[left2]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[left1])
                    list.add(nums1[left1]);
                left1++;
            } else if (nums2[left2] < nums1[left1]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums2[left2])
                    list.add(nums2[left2]);
                left2++;
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[left1])
                    list.add(nums1[left1]);
                left1++;
                left2++;
            }
        }

        while (left1 < nums1.length) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums1[left1])
                list.add(nums1[left1]);
            left1++;
        }

        while (left2 < nums2.length) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums2[left2])
                list.add(nums2[left2]);
            left2++;
        }

        int arr[] = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String args[]) {
        int nums1[] = { 1, 2, 3, 4, 5 };
        int nums2[] = { 1, 2, 7 };

        int newarr[] = unionArray(nums1, nums2);

        for (int num : newarr) {
            System.out.print(num + " ");
        }
    }
}
//Important Question for practice
