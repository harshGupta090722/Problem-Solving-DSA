import java.util.*;

public class Asteroid_Collision {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                }

                if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                } else if (st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                }
            }
        }
        // Convert stack → array
        while (!st.isEmpty())
            result.add(st.pop());
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String args[]) {
        int[] asteroids = { 3, 5, -6, 2, -1, 4 };
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}