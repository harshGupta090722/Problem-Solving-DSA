//1317. Convert Integer to the Sum of Two No-Zero Integers
public class Q1317 {
    public static int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            for (int j = n-1; j >= n / 2; j--) {
                if (i + j == n) {
                    if (!containsZero(i) && !containsZero(j))
                        return new int[] { i, j };
                }
            }
        }
        return new int[] { 1, 1 };
    }

    public static boolean containsZero(int n) {
        for (int i = n; i > 0; i = i / 10) {
            int rem = i % 10;
            if (rem == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 1500000; // you can change this value for testing
        int[] result = getNoZeroIntegers(n);
        System.out.println(result[0] + " " + result[1]);
    }
}
