import java.util.*;

public class NextSmallerElement {

    public static int[] nextSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty())
                nse[i] = -1;
            else
                nse[i] = arr[st.peek()];

            st.push(i);
        }
        return nse;
    }

    public static void main(String args[]) {
        int nums[] = { 4, 8, 5, 2, 25 };
        System.out.println(Arrays.toString(nextSmallerElement(nums)));
    }
}