public class ReverseInteger {
    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;

        boolean positive = true;

        if (x < 0)
            positive = false;

        int num = Math.abs(x);
        int rev = 0;
        int ans=helper(num, rev);
        if(positive)
        return ans;
        return -ans;
    }

    public static int helper(int x, int rev) {
        if (x == 0)
            return rev;
        int rem = x % 10;
        rev = 10 * rev + rem;
        return helper(x / 10, rev);
    }

    public static void main(String args[]) {
        int x = 123;
        System.out.println(reverse(x));
    }
}