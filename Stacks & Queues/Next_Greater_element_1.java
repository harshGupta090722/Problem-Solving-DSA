import java.util.*;

class Next_Greater_element {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            nextGreaterMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterMap.get(nums1[i]);
        }

        return ans;
    }
}

// Things to remember-1)Use Deque as Stack using ArrayDeque-This is
// better,faster than Stack.They behave similar to Stack when implemented using
// ArrayDeque.2)Use of Map-to map nge of nums2 ,then fetching nge of each of
// num1 using that map.