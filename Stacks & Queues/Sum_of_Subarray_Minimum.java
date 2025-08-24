import java.util.*;

class Solution {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = (int) 1e9 + 7;

        //nse
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nse[i] = n;
            else
                nse[i] = st.peek();
            st.push(i);
        }

        //pse
        int pse[] = new int[n];
        Stack<Integer> st2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st2.isEmpty() && arr[i] < arr[st2.peek()]) {
                st2.pop();
            }
            if (st2.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st2.peek();
            st2.push(i);
        }

        //Contribution of each element
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum = (sum + (long) arr[i] * left * right) % MOD;
        }
        return (int) sum;
    }

    public static void main(String args[]) {
        int arr[] = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins(arr));
    }
}
