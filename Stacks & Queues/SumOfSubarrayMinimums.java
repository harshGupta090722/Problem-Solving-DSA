import java.util.*;

public class SumOfSubarrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int nse[] = new int[n];
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

        st.clear();

        int pse[] = new int[n];
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long contributions = ((long) arr[i] * (i - pse[i]) % MOD) * ((nse[i] - i) % MOD);
            result = (result + contributions) % MOD;
        }

        return (int) result;
    }

    public static void main(String args[]) {
        int arr[] = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins(arr));
    }
}