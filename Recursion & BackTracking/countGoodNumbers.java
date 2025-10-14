public class countGoodNumbers {
    public static int countgoodNumbers(long n) {
        int ans = 1;
        for (long i = 0; i < n; i++) {
            if (i % 2 == 0)
                ans *= 5;
            else
                ans *= 4;
        }
        return ans;
    }

    public static void main(String args[]) {
        System.out.println(countgoodNumbers((4)));// 5
    }
}