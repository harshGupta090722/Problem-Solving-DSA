import java.util.*;

public class Next_Greater_element {
    public static int[] nextGreaterElement(int nums[]) {
        Stack<Integer> st = new Stack<>();
        int nge[] = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            
            while (!st.isEmpty() && nums[i] > st.peek()) {
                st.pop();
            }

            if (st.isEmpty()) 
                nge[i] = -1;
             else 
                nge[i] = st.peek();

            st.push(nums[i]);
        }
        return nge;
    }

    public static void main(String args[]) {
        int nums[] = { 4, 5, 2, 10, 8 };

        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}
