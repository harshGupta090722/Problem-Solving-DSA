public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 1)
            return 1;

        int a = 1, b = 1, c = 0;

        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String args[]) {
        System.out.println(climbStairs(3));
    }
}