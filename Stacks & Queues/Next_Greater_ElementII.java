import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Next_Greater_ElementII {
    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int nge[] = new int[nums.length];
        Arrays.fill(nge, -1);
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int idx = i % nums.length;
            while (!st.isEmpty() && nums[idx] >= st.peek()) {
                st.pop();
            }

            if (!st.isEmpty())
                nge[idx] = st.peek();

            st.push(nums[idx]);
        }
        return nge;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 1 };

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}