import java.util.*;

public class AsteroidCollision {
    static Stack<Integer> st = new Stack<>();

    public static int[] asteroidCollision(int[] arr, int idx) {
        if (idx == arr.length) {
            return printStack();
        }
        int curr = arr[idx];

        while (!st.isEmpty() && st.peek() > 0 && curr < 0) {
            if (st.peek() < -curr) {
                st.pop();
                continue;
            } else if (st.peek() == -curr) {
                st.pop();
                curr = 0;
                break;
            } else {
                curr = 0;
                break;
            }
        }
        if (curr != 0) {
            st.push(curr);
        }

        return asteroidCollision(arr, idx + 1);
    }

    public static int[] printStack() {
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] asteroids = { 5, 10, -5 };
        System.out.println(Arrays.toString(asteroidCollision(asteroids, 0)));
    }
}