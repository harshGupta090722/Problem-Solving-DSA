import java.util.*;

public class sumFibonacci {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 1, c = 0, n = sc.nextInt();

        if (n == 1) {
            System.out.println("0");
        } else if (n == 2) {
            System.out.println("1");
        } else {
            for (int i = 1; i <= n - 2; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println(c);
        }
        sc.close();
    }
}