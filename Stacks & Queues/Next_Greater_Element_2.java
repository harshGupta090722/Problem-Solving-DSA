import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        int nge[] = new int[n];
        Arrays.fill(nge,-1);
        for (int i = 2*n - 1 ;i >= 0; i--) {
            int idx=i%n;
            while (!st.isEmpty() && nums[idx] >= st.peek()) {
                st.pop();
            }

            if (!st.isEmpty())
                nge[idx] = st.peek();

            st.push(nums[idx]);
        }
        return nge;
    }
}

//The thing to learn from this question is Circular array → simulate double pass → i % n → monotonic stack → result assignment ,This is a pattern to remember.