public class PowerOf2 {
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }

    public static double helper(double x, long n) {
        if (n == 1)
            return x;

        double half = helper(x, n / 2);
        if (n % 2 == 0)
            return half*half;
        else
            return x * half*half;
    }

    public static void main(String args[]) {
        Double x = 2.0;
        int n = 11;
        System.out.println(myPow(x, n));
    }
}