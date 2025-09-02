import java.util.*;
class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        long sum = 0;

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
        // nge
        int nge[] = new int[n];
        Stack<Integer> st3 = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st3.isEmpty() && arr[i] >= arr[st3.peek()]) {
                st3.pop();
            }
            if (st3.isEmpty())
                nge[i] = n;
            else
                nge[i] = st3.peek();
            st3.push(i);
        }

        // pge
        int pge[] = new int[n];
        Stack<Integer> st4 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st4.isEmpty() && arr[i] > arr[st4.peek()]) {
                st4.pop();
            }
            if (st4.isEmpty())
                pge[i] = -1;
            else
                pge[i] = st4.peek();
            st4.push(i);
        }

        for (int i = 0; i < n; i++) {
            long leftMax = i - pge[i];
            long rightMax = nge[i] - i;
            long maxCount = leftMax * rightMax;

            long leftMin = i - pse[i];
            long rightMin = nse[i] - i;
            long minCount = leftMin * rightMin;
         //Total=∑(sum of contributions as max)−∑(sum of contributions as min)
            sum += (long) arr[i] * (maxCount - minCount);
        }
        return sum;
    }
}