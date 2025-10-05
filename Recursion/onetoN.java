public class onetoN {
    public static void printOneToN(int n) {
        if (n <1)
            return;

        printOneToN(n - 1);
        System.out.println(n);
    }

    public static void main(String args[]) {
        int n = 10;
        printOneToN(n);
    }
}