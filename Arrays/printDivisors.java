
import java.util.*;

public class printDivisors {
    public static void main(String[] args) {
        int n = 10;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) { 
                    list.add(n / i);
                }
            }
        }
        
        System.out.println(list);
    }
}